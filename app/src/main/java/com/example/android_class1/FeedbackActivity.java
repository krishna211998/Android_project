package com.example.android_class1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity {
    private RatingBar ratingBar;
    private Button button;
    private float rate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        ratingBar=findViewById(R.id.rating);
        button=findViewById(R.id.btnRating);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rate=ratingBar.getRating();
                Toast.makeText(FeedbackActivity.this,"Thanks for giving feedback:"+rate,Toast.LENGTH_LONG).show();
            }
        });
    }
}
