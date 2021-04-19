package com.premiumtechs.chirkut;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import static java.lang.Thread.sleep;

public class Splash extends AppCompatActivity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DatabaseHelper databaseHelper = new DatabaseHelper(this.getApplicationContext());
        List<Profile> profiles = databaseHelper.getAllProfile();
        Intent intent;
        if (profiles.isEmpty())
            intent = new Intent(Splash.this, MainActivity.class);
        else
            intent = new Intent(Splash.this, UpdateProfile.class);
        startActivity(intent);
    }

    @Override
    public void run() {
    }
}
