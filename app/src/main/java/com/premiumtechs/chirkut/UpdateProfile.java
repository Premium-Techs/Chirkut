package com.premiumtechs.chirkut;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import java.util.List;

public class UpdateProfile extends AppCompatActivity {
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);

        //Mimma
        databaseHelper=new DatabaseHelper(this.getApplicationContext());
        List<Profile>profiles=databaseHelper.getAllProfile();
        TextView tvProfile=(TextView) findViewById(R.id.tvProfile);
        StringBuilder stringBuilder=new StringBuilder();
        for (Profile profile:profiles){
            stringBuilder.append(profile.getProfileName()+","+profile.getProfileBio()+"\n");
        }
        tvProfile.setText(stringBuilder.toString().trim());
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}