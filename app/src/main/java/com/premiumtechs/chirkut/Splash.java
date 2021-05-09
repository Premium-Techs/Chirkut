package com.premiumtechs.chirkut;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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
        Intent intent;
        if (databaseHelper.getNumOfProfilesInDB()==0)
            intent = new Intent(Splash.this, MainActivity.class);
        else
            intent = new Intent(Splash.this, UpdateProfile.class);
        startActivity(intent);
        */
        /*
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        databaseHelper.getReadableDatabase();
        for (int i = 0; i < 10; i++) {
            databaseHelper.deleteProfile(new Profile("" + i, "name" + i, "bio" + i, "phone" + i));
            databaseHelper.insertProfile(new Profile("" + i, "name" + i, "bio" + i, "phone" + i));
            databaseHelper.insertMessage(new Message("" + i, "2", "3", "4", "5", "6"));
        }
                 */
        DummyDatabaseHelper dummyDatabaseHelper = new DummyDatabaseHelper();
        dummyDatabaseHelper.insertDummyProfile();
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

    public class DummyDatabaseHelper {
        public void insertDummyProfile() {
            DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
            SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
            /*
            for (int i = 0; i < 20; i++) {
                Profile profile = new Profile(
                        String.valueOf(i),
                        String.valueOf(i),
                        String.valueOf(i),
                        String.valueOf(i)
                );
                databaseHelper.insertProfile(profile);
                for (int j = 0; j < 30; j++) {
                    Message message = new Message(
                            i + " " + j,
                            String.valueOf(i),
                            String.valueOf(i),
                            i + " " + j + " From the summit of yonder pyramids forty centuries look down upon you. \n He who has one thousand friedns has nobody to spare, he who has one enemy meets him everywhere ",
                            String.valueOf(System.currentTimeMillis()),
                            i + " " + j
                    );
                    databaseHelper.insertMessage(message);
                }
            }
            */
            String[] profileids = new String[]{"0", "5", "8", "27", "39", "2003"};
            databaseHelper.insertProfile(new Profile(profileids[0], "Me", "Me", "000"));
            databaseHelper.insertProfile(new Profile(profileids[1], "Mimma", "Mimma", "016"));
            databaseHelper.insertProfile(new Profile(profileids[2], "Sakib", "Sakib", "017"));
            databaseHelper.insertProfile(new Profile(profileids[3], "Naima", "Naima", "017"));
            databaseHelper.insertProfile(new Profile(profileids[4], "Ahmed", "Ahmed", "017"));
            databaseHelper.insertProfile(new Profile(profileids[5], "Rahat", "Rahat", "015"));
            String[] quotes = new String[]{
                    "There are more things in heaven and earth Horatio, than are dreamt of in your philosophy",
                    "What is in a name?",
                    "That which we call a rose by any other names would smell as sweet",
                    "All the world's a stage",
                    "To be, or not to be, that is the question",
                    "He who has one thousand friends, has nobody to spare!\nHe who has one enemy meets him everywhere",
                    "Cogito, ergo sum",
                    "Veni, Vedi, Vici",
                    "From the summit of yonder pyramids, forty centuries look down upon you!"
            };
        }
    }
}
