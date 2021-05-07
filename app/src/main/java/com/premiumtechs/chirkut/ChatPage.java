package com.premiumtechs.chirkut;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ChatPage extends AppCompatActivity {
    private String messageId;
    private EditText etMessage;
    private ListView lvMessages;
    private EditText profilePhoneNo;
    private DatabaseHelper databaseHelper;
    private Button btnSend;

    private String profileId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_page);

        initUi();
        if (profileId==null) {
            //Toast.makeText(getApplicationContext(),"Profile ID not found", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ChatPage.this, Home.class));
            return;
        }
        databaseHelper = new DatabaseHelper(this);
        //todo search message for profileID
        List<Message> messageList = databaseHelper.getAllMessage();
        lvMessages.setAdapter(new CustomAdapter(messageList, this.getApplicationContext()));
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo send message
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
        lvMessages = findViewById(R.id.listMessages);
        //btnDelete = findViewById(R.id.btnDelete);
        profileId = getIntent().getExtras().getString("profileID");
    }

    public void sendMessage(View view) {
    }
}
