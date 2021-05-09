package com.premiumtechs.chirkut;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ChatPage extends AppCompatActivity {
    final private String TAG = "ChatPage";
    private String messageId;
    private String senderId;
    private String recieveId;
    private String sendTime;
    private String recieveTime;
    private EditText etMessage;
    private ListView lvMessages;
    private EditText profilePhoneNo;
    private DatabaseHelper databaseHelper;
    private Button btnSend;

    private String profileId;
    private Profile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_page);
        initUi();

        if (profile == null) {
            //getIntent().setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            this.finish();
            startActivity(new Intent(ChatPage.this, Home.class));
            return;
        }
        profileId = profile.getProfileId();
        Log.d(TAG, profileId);
        setTitle(profile.getProfileName());
        databaseHelper = new DatabaseHelper(this);
        List<Message> messageList = databaseHelper.getAllMessageOfAProfile(profile, true);
        lvMessages.setAdapter(new CustomAdapter(messageList, this.getApplicationContext()));
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo send message
                Message message = new Message();
                databaseHelper.insertMessage(message);
                Intent switchActivityIntent = new Intent(ChatPage.this, ChatPage.class);
                startActivity(switchActivityIntent);
            }
        });

    }

    private void initUi() {
        etMessage = findViewById(R.id.etMessage);
        btnSend = findViewById(R.id.btnSend);
        lvMessages = findViewById(R.id.listMessages);
        //btnDelete = findViewById(R.id.btnDelete);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            //profileId = getIntent().getExtras().getString("profileID");
            profile = (Profile) bundle.getSerializable("profile");
            bundle.clear();
        }
    }

    public void sendMessage(View view) {

    }
}
