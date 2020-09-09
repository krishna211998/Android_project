package com.example.android_class1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CancelActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel);
        textView= findViewById(R.id.txt1);
        button=findViewById(R.id.btnlgnn);
        String x;
        x=" PLEASE PRESS GOTO BUTTON TO LOGIN AGAIN";
        textView.setText(x);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(CancelActivity.this,MainActivity.class);
                startActivity(intent);
                //CancelActivity.this.finish();
            }
        });
    }
}