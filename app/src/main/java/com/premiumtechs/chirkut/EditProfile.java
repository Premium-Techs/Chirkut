package com.premiumtechs.chirkut;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class EditProfile extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    //private String profileId;
    private EditText profileName;
    private EditText profileBio;
    private EditText profilePhoneNo;
    private Button btnUpdate;
    //private Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        initUi();
        databaseHelper = new DatabaseHelper(this);
        List<Profile> profiles = databaseHelper.getAllProfile();
        setProfileData(profiles);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (profiles != null && profiles.get(0) != null) {
                    Profile profile = profiles.get(0);
                    Profile newProfile = new Profile(
                            profile.getProfileId(),
                            profileName.getText().toString(),
                            profilePhoneNo.getText().toString(),
                            profileBio.getText().toString()
                    );
                    //Log.i("Profile", "onClick: "+newProfile.toString());
                    int check = databaseHelper.updateProfile(newProfile);
                    Toast.makeText(EditProfile.this, "Successfully Updated", Toast.LENGTH_SHORT).show();
                }
                Intent switchActivityIntent = new Intent(EditProfile.this, UpdateProfile.class);
                startActivity(switchActivityIntent);
            }
        });
    }

    private void setProfileData(List<Profile> profiles) {
        if (profiles != null && profiles.get(0) != null) {
            Profile profile = profiles.get(0);
            profileName.setText(profile.getProfileName());
            profilePhoneNo.setText(profile.getProfilePhoneNo());
            profileBio.setText(profile.getProfileBio());
        }
    }

    private void initUi() {
        profileName = findViewById(R.id.edtName);
        profilePhoneNo = findViewById(R.id.edtPhoneNo);
        profileBio = findViewById(R.id.edtBio);
        btnUpdate = findViewById(R.id.btnUpdate);
        //btnDelete = findViewById(R.id.btnDelete);
    }

}
