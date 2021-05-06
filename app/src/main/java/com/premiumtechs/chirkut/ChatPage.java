package com.premiumtechs.chirkut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class ChatPage extends AppCompatActivity {
    private String messageId;
    private EditText etMessage;
    private ListView lvMessages;
    private EditText profilePhoneNo;
    private DatabaseHelper databaseHelper;
    private Button btnSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_page);
        initUi();
        databaseHelper = new DatabaseHelper(this);
        List<Message> messageList = databaseHelper.getAllMessage();
        lvMessages.setAdapter(new CustomAdapter(messageList,this.getApplicationContext()));
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Profile profile = new Profile(profileId, profileName.getText().toString(), profilePhoneNo.getText().toString(), profileBio.getText().toString());
                //databaseHelper.insertMessage(message);
                //Intent switchActivityIntent = new Intent(MainActivity.this, UpdateProfile.class);
                //startActivity(switchActivityIntent);
            }
        });
    }
    private void initUi() {
        etMessage = findViewById(R.id.etMessage);
        btnSend = findViewById(R.id.btnSend);
        lvMessages=findViewById(R.id.lvMessages);
        //btnDelete = findViewById(R.id.btnDelete);
    }
}