package com.premiumtechs.chirkut;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    private TextView tvProfile;
    private Button btnEdit;
    private Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initUi();
        databaseHelper = new DatabaseHelper(this);
        Profile profile = databaseHelper.getProfileFromID("0");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name : " + profile.getProfileName() + "\n"
                + "Phone no.: " + profile.getProfilePhoneNo() + "\n"
                + "Bio: " + profile.getProfileBio() + "\n");
        tvProfile.setText(stringBuilder.toString().trim());
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent switchActivityIntent = new Intent(v.getContext(), EditProfile.class);
                startActivity(switchActivityIntent);
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatabaseHelper(v.getContext()).deleteAll();
                Intent switchActivityIntent = new Intent(v.getContext(), Splash.class);
                startActivity(switchActivityIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_home:
                startActivity(new Intent(Settings.this, Home.class));
                return true;
            case R.id.menu_about:
                startActivity(new Intent(Settings.this, About.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initUi() {
        tvProfile = findViewById(R.id.tvProfile);
        btnEdit = findViewById(R.id.btnEdit);
        btnDelete = findViewById(R.id.btnDelete);
    }
}
