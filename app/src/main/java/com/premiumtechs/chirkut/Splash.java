package com.premiumtechs.chirkut;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity implements Runnable {
    final int DEBUG = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        long numOfProfilesInDB = new DatabaseHelper(this.getApplicationContext()).getNumOfProfilesInDB();
        if (DEBUG == 0) {
            if (numOfProfilesInDB == 0) {
                startActivity(new Intent(Splash.this, MainActivity.class));
            } else {
                startActivity(new Intent(Splash.this, Home.class));
            }
            this.finish();
        }

        setContentView(R.layout.activity_splash);
        /*
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        databaseHelper.getReadableDatabase();
        for (int i = 0; i < 10; i++) {
            databaseHelper.deleteProfile(new Profile("" + i, "name" + i, "bio" + i, "phone" + i));
            databaseHelper.insertProfile(new Profile("" + i, "name" + i, "bio" + i, "phone" + i));
            databaseHelper.insertMessage(new Message("" + i, "2", "3", "4", "5", "6"));
        }
        */
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
        if (DEBUG != 0 && numOfProfilesInDB == 0) {
            DummyDatabaseHelper dummyDatabaseHelper = new DummyDatabaseHelper();
            dummyDatabaseHelper.insertDummyProfile();
        }
    }

    @Override
    public void run() {
    }

    public class DummyDatabaseHelper {
        public void insertDummyProfile() {
            DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
            String[] profileids = new String[]{"0", "5", "8", "27", "39", "2003", "2005", "2008", "2027", "2039", "202003"};
            databaseHelper.insertProfile(new Profile(profileids[0], "Me", "Me", "000"));
            databaseHelper.insertProfile(new Profile(profileids[1], "Mimma", "Mimma", "016"));
            databaseHelper.insertProfile(new Profile(profileids[2], "Sakib", "Sakib", "017"));
            databaseHelper.insertProfile(new Profile(profileids[3], "Naima", "Naima", "017"));
            databaseHelper.insertProfile(new Profile(profileids[4], "Ahmed", "Ahmed", "017"));
            databaseHelper.insertProfile(new Profile(profileids[5], "Rahat", "Rahat", "015"));
            databaseHelper.insertProfile(new Profile(profileids[6], "Mimma Akter", "Mimma", "016"));
            databaseHelper.insertProfile(new Profile(profileids[7], "Md. Nazmus Sakib", "Sakib", "017"));
            databaseHelper.insertProfile(new Profile(profileids[8], "Kazi Naima Sultana", "Naima", "017"));
            databaseHelper.insertProfile(new Profile(profileids[9], "Ahmed Ullah", "Ahmed", "017"));
            databaseHelper.insertProfile(new Profile(profileids[10], "Md. Ashraful Haq Rahat", "Rahat", "015"));
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
            databaseHelper.insertMessage(new Message("a", profileids[0], profileids[5], quotes[1], "sendtime", "receivetime"));
            databaseHelper.insertMessage(new Message("b", profileids[5], profileids[0], quotes[4], "sendtime", "receivetime"));
            databaseHelper.insertMessage(new Message("c", profileids[0], profileids[5], quotes[0], "sendtime", "receivetime"));
            databaseHelper.insertMessage(new Message("d", profileids[5], profileids[0], quotes[2], "sendtime", "receivetime"));
            databaseHelper.insertMessage(new Message("e", profileids[0], profileids[5], quotes[5], "sendtime", "receivetime"));
            databaseHelper.insertMessage(new Message("f", profileids[5], profileids[0], quotes[3], "sendtime", "receivetime"));
        }
    }
}


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
                            i + " " + j + " From the summit of yonder pyramids forty centuries look down upon you. \n He who has one thousand friends has nobody to spare, he who has one enemy meets him everywhere ",
                            String.valueOf(System.currentTimeMillis()),
                            i + " " + j
                    );
                    databaseHelper.insertMessage(message);
                }
            }
            */
