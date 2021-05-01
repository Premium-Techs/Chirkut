package com.premiumtechs.chirkut;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.List;

public class UpdateProfile extends AppCompatActivity {
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_update_profile);

        databaseHelper = new DatabaseHelper(this);
        List<Profile> profiles = databaseHelper.getAllProfile();
        TextView tvProfile = (TextView) findViewById(R.id.tvProfile);
        StringBuilder stringBuilder = new StringBuilder();
        for (Profile profile : profiles) {
            stringBuilder.append( profile.getProfileId()+","  + profile.getProfileName() + "," + profile.getProfileBio() + "," + profile.getProfilePhoneNo() + "\n");
        }
        tvProfile.setText(stringBuilder.toString().trim());
    }
}
