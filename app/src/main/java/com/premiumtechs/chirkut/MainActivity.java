package com.premiumtechs.chirkut;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText profileId;
    private EditText profileName;
    private EditText profileBio;
    private DatabaseHelper databaseHelper;
    private Button btnSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new DatabaseHelper(this.getApplicationContext());
        profileId = (EditText) findViewById(R.id.etId);
        profileName = (EditText) findViewById(R.id.etName);
        profileBio = (EditText) findViewById(R.id.etBio);
        btnSub = (Button) findViewById((R.id.btnSub));

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Profile profile = new Profile(profileId.getText().toString(), profileName.getText().toString(), profileBio.getText().toString());
                databaseHelper.insertProfile(profile);
                Intent switchActivityIntent = new Intent(MainActivity.this, UpdateProfile.class);
                startActivity(switchActivityIntent);
            }
        });
    }
}
