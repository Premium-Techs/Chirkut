package com.premiumtechs.chirkut;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Message> {
    private final List<Message> dataSet;
    private final LinearLayout.LayoutParams layoutParamsSelf;
    private final LinearLayout.LayoutParams layoutParamsOthers;
    Context context;

    public CustomAdapter(List<Message> messages, @NonNull Context context) {
        super(context, R.layout.chat_page, messages);
        this.dataSet = messages;
        this.context = context;
        layoutParamsSelf = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        layoutParamsOthers = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        //layoutParamsSelf.setMargins(50, 0, 0, 0);
        layoutParamsSelf.leftMargin = 50;
        layoutParamsSelf.topMargin = 0;
        layoutParamsSelf.rightMargin = 0;
        layoutParamsSelf.bottomMargin = 0;
        layoutParamsOthers.setMargins(0, 0, 50, 0);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Message message = getItem(position);
        ViewHolder viewHolder = new ViewHolder();

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.msg_box_common, parent, false);
            viewHolder.msgLayout = convertView.findViewById(R.id.msg_box_common_inner);
            viewHolder.msgBody = convertView.findViewById(R.id.msg_box_body);
            viewHolder.msgTime = convertView.findViewById(R.id.msg_box_time);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (message.getSenderId().equals("0")) {
            viewHolder.msgLayout.setBackgroundResource(R.drawable.border_msg_self);
            viewHolder.msgLayout.setLayoutParams(layoutParamsSelf);
        } else {
            viewHolder.msgLayout.setBackgroundResource(R.drawable.border_msg_others);
            viewHolder.msgLayout.setLayoutParams(layoutParamsOthers);
        }
        viewHolder.msgBody.setText(message.getMessages());
        viewHolder.msgTime.setText(message.getSendTime());

        return convertView;
    }

    private static class ViewHolder {
        TextView msgBody, msgTime;
        LinearLayout msgLayout;
    }
}
