package com.premiumtechs.chirkut;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        /*
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
        */
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        for (int i = 0; i < 10; i++) {
            databaseHelper.deleteProfile(new Profile("" + i, "name" + i, "bio" + i, "phone" + i));
            databaseHelper.insertProfile(new Profile("" + i, "name" + i, "bio" + i, "phone" + i));
            databaseHelper.insertMessage(new Message("" + i, "2", "3", "4", "5", "6"));
        }
        Button rhtabt = findViewById(R.id.rhtabt);
        rhtabt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Splash.this, About.class));
            }
        });
        Button rhtcht = findViewById(R.id.rhtcht);
        rhtcht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Splash.this, ChatPage.class));
            }
        });
        Button rhthome = findViewById(R.id.rhthome);
        rhthome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Splash.this, Home.class));
            }
        });
    }

    @Override
    public void run() {
    }
}
