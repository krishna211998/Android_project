package com.example.android_class1;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
public class SplashActivity extends AppCompatActivity {

    SharedPreferences preferences;
    private String user;
    /* string user is used to check current user*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        preferences= PreferenceManager.getDefaultSharedPreferences(SplashActivity.this);
        user=preferences.getString("CURRENT_USER","");
        /* if the user exists get that else ""*/

        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        if (user.equals("")) {
                            startActivity(new Intent(SplashActivity.this, MainActivity.class));
                        }

                    else
                    {
                        startActivity(
                                new Intent(SplashActivity.this, welcomeActivity.class));
                    }
                    SplashActivity.this.finish(); //destroy current activity
                    }
                }, 3000);
    }

}
