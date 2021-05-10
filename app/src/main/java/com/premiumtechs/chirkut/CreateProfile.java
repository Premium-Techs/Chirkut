package com.premiumtechs.chirkut;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateProfile extends AppCompatActivity {
    private String profileId;
    private EditText profileName;
    private EditText profileBio;
    private EditText profilePhoneNo;
    private DatabaseHelper databaseHelper;
    private Button btnSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
        databaseHelper = new DatabaseHelper(this);
        profileId = String.valueOf(System.currentTimeMillis());
        profileName = findViewById(R.id.etName);
        profileBio = findViewById(R.id.etBio);
        profilePhoneNo = findViewById(R.id.etPhoneNo);
        btnSub = findViewById(R.id.btnSub);

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Profile profile = new Profile(profileId, profileName.getText().toString(), profilePhoneNo.getText().toString(), profileBio.getText().toString());
                databaseHelper.insertProfile(profile);
                Toast.makeText(getApplicationContext(), "Welcome " + profileName.getText().toString(), Toast.LENGTH_SHORT).show();
                Intent switchActivityIntent = new Intent(CreateProfile.this, Home.class);
                startActivity(switchActivityIntent);
            }
        });
    }
}
