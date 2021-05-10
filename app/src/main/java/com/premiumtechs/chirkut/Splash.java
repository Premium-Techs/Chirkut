package com.premiumtechs.chirkut;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
                startActivity(new Intent(Splash.this, CreateProfile.class));
            } else {
                startActivity(new Intent(Splash.this, Home.class));
            }
            this.finish();
        }

        setContentView(R.layout.activity_splash);
        try {
            Log.d("MAC ADDRESS", "MAC ADDRESS");
            Log.d("MAC ADDRESS", ChirkutMACFinder.getMacAddress());
            Log.d("MAC ADDRESS", "MAC ADDRESS");
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        databaseHelper.getReadableDatabase();
        for (int i = 0; i < 10; i++) {
            databaseHelper.deleteProfile(new Profile("" + i, "name" + i, "bio" + i, "phone" + i));
            databaseHelper.insertProfile(new Profile("" + i, "name" + i, "bio" + i, "phone" + i));
            databaseHelper.insertMessage(new Message("" + i, "2", "3", "4", "5", "6"));
        }
        */
        Button btnAbt = findViewById(R.id.btnAbt);
        btnAbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Splash.this, About.class));
            }
        });
        Button btnChat = findViewById(R.id.btnCht);
        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Splash.this, ChatPage.class));
            }
        });
        Button btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Splash.this, Home.class));
            }
        });
        Button btnEdt = findViewById(R.id.btnEdt);
        btnEdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Splash.this, Settings.class));
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
            databaseHelper.insertMessage(new Message(null, profileids[0], profileids[5], quotes[1], String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis())));
            databaseHelper.insertMessage(new Message(null, profileids[5], profileids[0], quotes[4], String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis())));
            databaseHelper.insertMessage(new Message(null, profileids[0], profileids[5], quotes[0], String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis())));
            databaseHelper.insertMessage(new Message(null, profileids[5], profileids[0], quotes[2], String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis())));
            databaseHelper.insertMessage(new Message(null, profileids[0], profileids[5], quotes[5], String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis())));
            databaseHelper.insertMessage(new Message(null, profileids[5], profileids[0], quotes[3], String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis())));
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
