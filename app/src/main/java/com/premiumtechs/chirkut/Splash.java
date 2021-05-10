package com.premiumtechs.chirkut;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity implements Runnable {
    final int DEBUG = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        long numOfProfilesInDB = new DatabaseHelper(this.getApplicationContext()).getNumOfProfilesInDB();
        //if (DEBUG == 0 && numOfProfilesInDB == 0) {
        if (numOfProfilesInDB == 0) {
            startActivity(new Intent(Splash.this, CreateProfile.class));
        }
        if (DEBUG != 0) {
            DummyDatabaseHelper dummyDatabaseHelper = new DummyDatabaseHelper();
            dummyDatabaseHelper.insertDummyProfile();
        }
        if (numOfProfilesInDB != 0) {
            startActivity(new Intent(Splash.this, Home.class));
        }
        setContentView(R.layout.activity_splash);
        this.finish();
    }


    @Override
    public void run() {
    }

    public class DummyDatabaseHelper {
        public void insertDummyProfile() {
            DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
            String[] profileids = new String[]{"0", "5", "8", "27", "39", "2003", "2005", "2008", "2027", "2039", "202003"};
            //databaseHelper.insertProfile(new Profile(profileids[0], "Me", "000", "Me"));
            databaseHelper.insertProfile(new Profile(profileids[1], "Mimma", "016", "Mimma"));
            databaseHelper.insertProfile(new Profile(profileids[2], "Sakib", "017", "Sakib"));
            databaseHelper.insertProfile(new Profile(profileids[3], "Naima", "017", "Naima"));
            databaseHelper.insertProfile(new Profile(profileids[4], "Ahmed", "017", "Ahmed"));
            databaseHelper.insertProfile(new Profile(profileids[5], "Rahat", "015", "Rahat"));
            databaseHelper.insertProfile(new Profile(profileids[6], "Mimma Akter", "016", "Mimma"));
            databaseHelper.insertProfile(new Profile(profileids[7], "Md. Nazmus Sakib", "017", "Sakib"));
            databaseHelper.insertProfile(new Profile(profileids[8], "Kazi Naima Sultana", "017", "Naima"));
            databaseHelper.insertProfile(new Profile(profileids[9], "Ahmed Ullah", "017", "Ahmed"));
            databaseHelper.insertProfile(new Profile(profileids[10], "Md. Ashraful Haq Rahat", "015", "Rahat"));
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
            databaseHelper.insertMessage(new Message(null, profileids[0], profileids[5], quotes[1], String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis())));
            databaseHelper.insertMessage(new Message(null, profileids[1], profileids[0], quotes[2], String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis())));
            databaseHelper.insertMessage(new Message(null, profileids[0], profileids[2], quotes[4], String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis())));
            databaseHelper.insertMessage(new Message(null, profileids[2], profileids[0], quotes[6], String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis())));
            databaseHelper.insertMessage(new Message(null, profileids[0], profileids[2], quotes[3], String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis())));
            databaseHelper.insertMessage(new Message(null, profileids[3], profileids[0], quotes[1], String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis())));
            databaseHelper.insertMessage(new Message(null, profileids[0], profileids[4], quotes[6], String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis())));
            databaseHelper.insertMessage(new Message(null, profileids[4], profileids[0], quotes[4], String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis())));
        }
    }
}
