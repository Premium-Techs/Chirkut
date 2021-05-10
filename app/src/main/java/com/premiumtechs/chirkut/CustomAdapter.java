package com.premiumtechs.chirkut;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class CustomAdapter extends ArrayAdapter<Message> {
    private final List<Message> dataSet;
    private final LinearLayout.LayoutParams layoutParamsSelf;
    private final LinearLayout.LayoutParams layoutParamsOthers;
    private final int CHAT_INSET = 80;
    Context context;

    public CustomAdapter(List<Message> messages, @NonNull Context context) {
        super(context, R.layout.activity_chat_page, messages);
        this.dataSet = messages;
        this.context = context;
        layoutParamsSelf = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParamsOthers = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParamsSelf.setMargins(CHAT_INSET, 0, 0, 0);
        layoutParamsOthers.setMargins(0, 0, CHAT_INSET, 0);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Message message = getItem(position);
        ViewHolder viewHolder = new ViewHolder();

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.msg_box_common, parent, false);
            viewHolder.msgLayoutOuter = convertView.findViewById(R.id.msg_box_common_outer);
            viewHolder.msgLayoutInner = convertView.findViewById(R.id.msg_box_common_inner);
            viewHolder.msgBody = convertView.findViewById(R.id.msg_box_body);
            viewHolder.msgTime = convertView.findViewById(R.id.msg_box_time);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (message.getSenderId().equals("0")) {
            viewHolder.msgLayoutOuter.setGravity(Gravity.RIGHT);
            viewHolder.msgLayoutInner.setBackgroundResource(R.drawable.border_msg_self);
            viewHolder.msgLayoutInner.setLayoutParams(layoutParamsSelf);
        } else {
            viewHolder.msgLayoutOuter.setGravity(Gravity.LEFT);
            viewHolder.msgLayoutInner.setBackgroundResource(R.drawable.border_msg_others);
            viewHolder.msgLayoutInner.setLayoutParams(layoutParamsOthers);
        }
        viewHolder.msgBody.setText(message.getMessages());
        //Date sendDate = new Date(message.getSendTime());
        //viewHolder.msgTime.setText(DateFormat.getDateInstance(DateFormat.FULL).format(Long.parseLong(message.getSendTime())));
        String dateFormat = "dd/MM/YY hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat, Locale.US);
        viewHolder.msgTime.setText(simpleDateFormat.format(Long.parseLong(message.getSendTime())));

        return convertView;
    }

    private static class ViewHolder {
        TextView msgBody, msgTime;
        LinearLayout msgLayoutOuter, msgLayoutInner;
    }
}
