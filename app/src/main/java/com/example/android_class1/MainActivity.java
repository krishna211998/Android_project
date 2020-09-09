package com.example.android_class1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText eduname,edpwd;
    private Button btnlogn;
    private Button cancel;
/* edUsername and edPassword are id's and edusername and edpassword are left hand side contain the variables.*/
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    /* both shared preferences and shared preferences.editor are interfaces used to handle session works like center repository
    *  of our app present within our mobile individual shared preferences are used to store data that are used to store
    * data at mobile level
    * Editor :- to write something in preferences we need the permission /help of editor*/

    String uName ,pwd;
    final String u_name="krishna@gmail.com";
    final String u_pass="krishna_21";

    RadioGroup radioselect;
    TextView txtshow;

    String data;
    Spinner spinner;
    String []india={"Select residence ","Bihar","Calcutta","Delhi","Uttar Pradesh","Madhya pradesh","Sikkim","Shimla","Jammu & kashmir",
    "Arunachal Pradesh","Goa","Hyderabad","Meghalaya","Kerala"};
    String []foreign={"Select residence ","america","london","japan","south korea","china","United Kingdom","North Korea",
    "Russia","Pakistan","France","Germany","Newzealand","Brazil","Saudi Arabia"};
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eduname=findViewById(R.id.edUsername);
        /* write side of = contains contains the id of the value name.*/
        edpwd=findViewById(R.id.edPassword);
        btnlogn=findViewById(R.id.btnlgn);
        cancel=findViewById(R.id.btnlgnn);
        preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        editor= preferences.edit();

        radioselect=findViewById(R.id.radioGroup1);
        txtshow=findViewById(R.id.txtselectedvalue);
        spinner=findViewById(R.id.spinnerName);

        radioselect.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.radioBtnMca)
                {
                    //data="MCA";
                    adapter =new ArrayAdapter(MainActivity.this,R.layout.support_simple_spinner_dropdown_item
                            ,india);

                }
                else if(checkedId==R.id.radioBtnBt)
                {
                    // data="B.Tech";
                    adapter=new ArrayAdapter(MainActivity.this,R.layout.support_simple_spinner_dropdown_item
                            ,foreign);
                }
                //txtshow.setText("value Selected : "+data);
                spinner.setAdapter((adapter));
            }
        });
        generateActionForSpinner();
    }
    private void generateActionForSpinner() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    txtshow.setText("Selected name :" + spinner.getSelectedItem());
                    data = spinner.getSelectedItem().toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        btnlogn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uName = eduname.getText().toString().trim();
                pwd = edpwd.getText().toString().trim();
                if (uName.isEmpty()) {
                    eduname.setError("Enter valid mail id");
                } else if (pwd.isEmpty()) {
                    edpwd.setError("Enter valid password");
                } else if (uName.equals(u_name) && pwd.equals(u_pass)) {
                    Intent intent = new Intent(MainActivity.this, welcomeActivity.class);
                    intent.putExtra("DATA", uName);
                    intent.putExtra("LOL", data);
                    startActivity(intent);
                    editor.putString("CURRENT_USER", uName);
                    editor.putString("CURRENT_LOL", data);
                    editor.apply();
                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    MainActivity.this.finish();

                    /* to make intent active,we should write start activity*/

                    /* we should provide current file and destination file*/
                    /*toast.maketext is to display the message to main function and for how long i have to show*toast.length_short()*/
                } else {
                    Toast.makeText(MainActivity.this, "Login failed \n invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Please back", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, CancelActivity.class);
                startActivity(intent);
                MainActivity.this.finish();
            }
        });
    }
}

