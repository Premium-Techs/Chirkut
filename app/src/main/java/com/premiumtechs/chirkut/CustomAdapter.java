package com.premiumtechs.chirkut;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import androidx.annotation.NonNull;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Message> {
    private List<Message> dataSet;
    Context context;
    private static class ViewHolder{
        EditText etMessage;
    }
    public CustomAdapter(List<Message> messages,@NonNull Context context) {
        super(context, R.layout.chat_page,messages);
        this.dataSet=messages;
        this.context=context;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        Message message=getItem(position);
        ViewHolder viewHolder;
        final View result;
        if(convertView == null){
            viewHolder=new ViewHolder();
            LayoutInflater inflater=LayoutInflater.from(getContext());
            viewHolder.etMessage=convertView.findViewById(R.id.etMessage);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder=(ViewHolder)convertView.getTag();
        }
        String chat=message.getMessages();
        return convertView;
    }
}
