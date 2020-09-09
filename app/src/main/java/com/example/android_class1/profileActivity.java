package com.example.android_class1;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;


public class profileActivity extends AppCompatActivity {
    private TextView Heading1,Heading2;
    String YourName1,YourName2;
    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Heading1=findViewById(R.id.text_1);
        Heading2=findViewById(R.id.text_2);
//        txtYourName=findViewById(R.id.text_2);

        preferences= PreferenceManager.getDefaultSharedPreferences(this);
        editor=preferences.edit();

        YourName1=preferences.getString("CURRENT_USER","");
        YourName1=getIntent().getStringExtra("DATA");

        YourName2=preferences.getString("CURRENT_LOL","");
        YourName2=getIntent().getStringExtra("LOL");

        Heading1.setText("Hello "+YourName1+"\n ");
        Heading2.setText("You are Currently staying in: "+YourName2+" ");


    }
}
