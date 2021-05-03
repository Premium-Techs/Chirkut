package com.premiumtechs.chirkut;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private String profileId;
    private EditText profileName;
    private EditText profileBio;
    private EditText profilePhoneNo;
    private DatabaseHelper databaseHelper;
    private Button btnSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new DatabaseHelper(this);
        profileId = String.valueOf(System.currentTimeMillis());
        profileName = (EditText) findViewById(R.id.etName);
        profileBio = (EditText) findViewById(R.id.etBio);
        profilePhoneNo = (EditText) findViewById(R.id.etPhoneNo);
        btnSub = (Button) findViewById(R.id.btnSub);

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Profile profile = new Profile(profileId, profileName.getText().toString(), profilePhoneNo.getText().toString(), profileBio.getText().toString());
                databaseHelper.insertProfile(profile);
                Intent switchActivityIntent = new Intent(MainActivity.this, UpdateProfile.class);
                startActivity(switchActivityIntent);
            }
        });
    }
}
