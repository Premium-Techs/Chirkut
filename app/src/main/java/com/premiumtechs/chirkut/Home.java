package com.premiumtechs.chirkut;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.List;

public class Home extends AppCompatActivity {
    private ListView listView;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle(R.string.app_name);
        initUI();
        databaseHelper = new DatabaseHelper(this.getApplicationContext());
        List<Profile> profileList = databaseHelper.getAllProfile();
        listView.setAdapter(new CustomAdapterProfiles(profileList, this.getApplicationContext()));
    }

    private void initUI() {
        listView = findViewById(R.id.listProfiles);
    }

    public class CustomAdapterProfiles extends ArrayAdapter<Profile> {

        private final List<Profile> profiles;
        Context context;

        public CustomAdapterProfiles(List<Profile> profiles, @NonNull Context context) {
            super(context, R.layout.profile_box, profiles);
            this.profiles = profiles;
            this.context = context;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            final Profile profile = getItem(position);
            ViewHolder viewHolder = new ViewHolder();

            if (convertView == null) {
                LayoutInflater layoutInflater = LayoutInflater.from(context);
                convertView = layoutInflater.inflate(R.layout.profile_box, parent, false);
                viewHolder.profile = convertView.findViewById(R.id.profileHome);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.profile.setText(profile.getProfileName());

            viewHolder.profile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Home.this, ChatPage.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("profile", (Serializable) profile);
                    //intent.putExtra("profileID", profile.getProfileId());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });

            return convertView;
        }

        private class ViewHolder {
            TextView profile;
        }

    }

}
