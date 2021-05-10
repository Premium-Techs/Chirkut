package com.premiumtechs.chirkut;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ChatPage extends AppCompatActivity {
    final private String TAG = "ChatPage";
    public int selectedMsg = -1;
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
        //Log.d(TAG, messageList.toString());
        lvMessages.setAdapter(new CustomAdapter(messageList, this.getApplicationContext()));
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message = new Message();
                message.setMessages(etMessage.getText().toString().trim());
                message.setSenderId("0");
                message.setRecieverId(profileId);
                message.setSendTime(String.valueOf(System.currentTimeMillis()));
                message.setRecieveTime(null);
                databaseHelper.insertMessage(message);
                Bundle bundle = new Bundle();
                bundle.putSerializable("profile", profile);
                Intent switchActivityIntent = new Intent(ChatPage.this, ChatPage.class);
                switchActivityIntent.putExtras(bundle);
                startActivity(switchActivityIntent);
            }
        });

        ListView listViewMessages = findViewById(R.id.listMessages);
        listViewMessages.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listViewMessages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });
        listViewMessages.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                listViewMessages.setSelection(position);
                selectedMsg = position;
                view.setSelected(true);
                return true;
            }
        });
        listViewMessages.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater menuInflater = mode.getMenuInflater();
                menuInflater.inflate(R.menu.menu_context, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_delete:
                        dell();
                        mode.finish();
                        return true;
                    default:
                        return false;
                }
            }

            public void dell() {
                Toast.makeText(getApplicationContext(), listViewMessages.getItemAtPosition(selectedMsg).toString(), Toast.LENGTH_LONG).show();
                Message deleteMessage = (Message) listViewMessages.getItemAtPosition(selectedMsg);
                new DatabaseHelper(getApplicationContext()).deleteMessage(deleteMessage.getMessageId());
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                selectedMsg = -1;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_common, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_about:
                startActivity(new Intent(ChatPage.this, About.class));
                return true;
            case R.id.menu_settings:
                startActivity(new Intent(ChatPage.this, Settings.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
