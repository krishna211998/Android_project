package com.example.android_class1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class welcomeActivity extends AppCompatActivity {
    SharedPreferences preferences;
    private TextView textUname,textUname2;
    String uname,hn;
//    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    /* i am taking a string value and storing the edit text value*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        textUname=findViewById(R.id.textusername);
        textUname2=findViewById(R.id.textusername2);
        preferences= PreferenceManager.getDefaultSharedPreferences(this);
        editor=preferences.edit();
        uname=preferences.getString("CURRENT_USER","");
        uname=getIntent().getStringExtra("DATA");
        textUname.setText("Welcome "+uname+"\n");
        hn=preferences.getString("CURRENT_LOL","");
        hn=getIntent().getStringExtra("LOL");
        textUname2.setText("\n You are currently staying in: "+hn+", ");
    }
    // add menu to activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.welcome_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_profile:
                Intent intent = new Intent(welcomeActivity.this,profileActivity.class);
                intent.putExtra("DATA",uname);
                intent.putExtra("LOL",hn);
                startActivity(intent);
                editor.putString("CURRENT_USER",uname);
                editor.putString("CURRENT_LOL",hn);
                editor.apply();
//                Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
//                MainActivity.this.finish();

//                startActivity(new Intent(welcomeActivity.this,profileActivity.class));
                break;
            case R.id.find_location:
                startActivity(new Intent(welcomeActivity.this,MapActivity.class));
              //  Toast.makeText(welcomeActivity.this,"find_location",Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_logout:
                confirmcall();
                Toast.makeText(welcomeActivity.this,"Logout Successful",Toast.LENGTH_LONG).show();
                break;
            case R.id.Feedback:
                startActivity(new Intent(welcomeActivity.this,FeedbackActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void confirmcall() {
        AlertDialog.Builder builder = new AlertDialog.Builder(welcomeActivity.this);
        builder.create();
        builder.setCancelable(false);
        builder.setMessage("Are you sure to exit?");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                editor.clear();
                editor.commit();
                Toast.makeText(welcomeActivity.this, "Logout Successful", Toast.LENGTH_LONG).show();
                startActivity(new Intent(welcomeActivity.this, MainActivity.class));
                welcomeActivity.this.finish();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(welcomeActivity.this, "Logout Cancel", Toast.LENGTH_LONG).show();
                //startActivity(new Intent(welcomeActivity.this, MainActivity.class));
                //welcomeActivity.this.finish();
                dialog.dismiss();
            }
        });
        builder.show();
    }
// to perform operations against menu item
}
