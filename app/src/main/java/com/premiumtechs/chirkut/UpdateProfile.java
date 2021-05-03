package com.premiumtechs.chirkut;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.List;

public class UpdateProfile extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    /*private String profileId;
    private EditText profileName;
    private EditText profileBio;
    private EditText profilePhoneNo;*/
    private TextView tvProfile;
    private Button btnEdit;
    private Button btnDelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_update_profile);
        initUi();
        databaseHelper = new DatabaseHelper(this);
        List<Profile> profiles = databaseHelper.getAllProfile();
        StringBuilder stringBuilder = new StringBuilder();
        for (Profile profile : profiles) {
            stringBuilder.append(profile.getProfileId() + "\n" + profile.getProfileName() + "\n" + profile.getProfilePhoneNo() + "\n" + profile.getProfileBio() + "\n");
        }
        tvProfile.setText(stringBuilder.toString().trim());

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent switchActivityIntent = new Intent(UpdateProfile.this, EditProfile.class);
                startActivity(switchActivityIntent);
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(profiles != null && profiles.get(0) != null) {
                    Profile profile = profiles.get(0);
                   int check =  databaseHelper.deleteProfile(profile);
                    //Toast.makeText(UpdateProfile.this, String.valueOf(check), Toast.LENGTH_SHORT).show();
                    Toast.makeText(UpdateProfile.this, "Successfully Deleted", Toast.LENGTH_SHORT).show();
                }
                Intent switchActivityIntent = new Intent(UpdateProfile.this, MainActivity.class);
                startActivity(switchActivityIntent);
            }
        });
    }

    /*private void setProfileData(List<Profile> profiles) {

        if(profiles != null && profiles.get(0) != null){
            Profile profile = profiles.get(0);
            profileName.setText(profile.getProfileName());
            profilePhoneNo.setText(profile.getProfilePhoneNo());
            profileBio.setText(profile.getProfileBio());
        }

    }*/

    private void initUi() {
        tvProfile = (TextView) findViewById(R.id.tvProfile);
        btnEdit=(Button) findViewById(R.id.btnEdit) ;
        btnDelete =(Button) findViewById(R.id.btnDelete);
    }
}