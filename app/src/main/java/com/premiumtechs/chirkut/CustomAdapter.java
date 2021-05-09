package com.premiumtechs.chirkut;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Message> {
    private final List<Message> dataSet;
    Context context;

    public CustomAdapter(List<Message> messages, @NonNull Context context) {
        super(context, R.layout.chat_page, messages);
        this.dataSet = messages;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Message message = getItem(position);
        ViewHolder viewHolder = new ViewHolder();

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.msg_box_others, parent, false);
            viewHolder.msgBody = convertView.findViewById(R.id.msgBody);
            viewHolder.msgTime = convertView.findViewById(R.id.msgTime);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.msgBody.setText(message.getMessages());
        viewHolder.msgTime.setText(message.getSendTime());

        return convertView;
    }

    private static class ViewHolder {
        TextView msgBody;
        TextView msgTime;
    }
}
