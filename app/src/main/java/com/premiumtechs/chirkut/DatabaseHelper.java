package com.premiumtechs.chirkut;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "chirkut.db";
    public static final String PROFILE_TABLE_NAME = "profile";
    public static final String PROFILE_COLUMN_ID = "profileId";
    public static final String PROFILE_COLUMN_NAME = "profileName";
    public static final String PROFILE_COLUMN_PHONENO = "profilePhoneNo";
    public static final String PROFILE_COLUMN_BIO = "profileBio";
    public static final String PROFILE_CREATE_TABLE = "create table IF NOT EXISTS "
            + PROFILE_TABLE_NAME
            + "(" + PROFILE_COLUMN_ID + " integer primary key autoincrement, "
            + PROFILE_COLUMN_PHONENO + " text,"
            + PROFILE_COLUMN_NAME + " text,"
            + PROFILE_COLUMN_BIO + " text)";
    public static final String MESSAGE_TABLE_NAME = "message";
    public static final String MESSAGE_COLUMN_ID = "messageId";
    public static final String MESSAGE_COLUMN_MESSAGES = "messages";
    public static final String MESSAGE_COLUMN_SENDTIME = "sendTime";
    public static final String MESSAGE_COLUMN_RECIEVETIME = "recieveTime";
    public static final String MESSAGE_COLUMN_MEDIA = "media";
    public static final String MESSAGE_COLUMN_LINKS = "links";
    public static final String MESSAGE_COLUMN_DOCS = "docs";
    public static final String MESSAGE_COLUMN_SENDERID = "senderId"; //FOREIGN KEY PROFILEID
    public static final String MESSAGE_COLUMN_RECIEVERID = "recieverId";
    public static final String MESSAGE_CREATE_TABLE = "create table IF NOT EXISTS "
            + MESSAGE_TABLE_NAME
            + "(" + MESSAGE_COLUMN_ID + " integer primary key autoincrement, "
            + MESSAGE_COLUMN_MESSAGES + " text,"
            + MESSAGE_COLUMN_SENDTIME + " text,"
            + MESSAGE_COLUMN_RECIEVETIME + " text,"
            + MESSAGE_COLUMN_SENDERID + " text,"
            + MESSAGE_COLUMN_RECIEVERID + " text,"
            + MESSAGE_COLUMN_MEDIA + " text,"
            + MESSAGE_COLUMN_LINKS + " text,"
            + MESSAGE_COLUMN_DOCS + " text,"
            + " FOREIGN KEY (" + MESSAGE_COLUMN_SENDERID + ") REFERENCES " + PROFILE_TABLE_NAME + " (" + PROFILE_COLUMN_ID + "))";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqliteDatabase) {
        sqliteDatabase.execSQL(PROFILE_CREATE_TABLE);
        sqliteDatabase.execSQL(MESSAGE_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
/*
        db.execSQL("DROP TABLE IF EXISTS "+PROFILE_TABLE_NAME);
        onCreate(db);
*/
    }

    public void insertProfile(Profile profile) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PROFILE_COLUMN_ID, profile.getProfileId());
        contentValues.put(PROFILE_COLUMN_NAME, profile.getProfileName());
        contentValues.put(PROFILE_COLUMN_PHONENO, profile.getProfilePhoneNo());
        contentValues.put(PROFILE_COLUMN_BIO, profile.getProfileBio());
        db.insert(PROFILE_TABLE_NAME, null, contentValues);
    }

    public int deleteProfile(Profile profile) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(PROFILE_TABLE_NAME, "profileId = ?", new String[]{profile.getProfileId()});
    }

    public int updateProfile(Profile profile) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PROFILE_COLUMN_ID, profile.getProfileId());
        contentValues.put(PROFILE_COLUMN_NAME, profile.getProfileName());
        contentValues.put(PROFILE_COLUMN_PHONENO, profile.getProfilePhoneNo());
        contentValues.put(PROFILE_COLUMN_BIO, profile.getProfileBio());
        return db.update(PROFILE_TABLE_NAME, contentValues, "profileId = ?", new String[]{profile.getProfileId()});
    }

    public List<Profile> getAllProfile() {
        List<Profile> profiles = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(PROFILE_TABLE_NAME, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String profileId = cursor.getString(cursor.getColumnIndex(PROFILE_COLUMN_ID));
            String profileName = cursor.getString(cursor.getColumnIndex(PROFILE_COLUMN_NAME));
            String profilePhoneNo = cursor.getString(cursor.getColumnIndex(PROFILE_COLUMN_PHONENO));
            String profileBio = cursor.getString(cursor.getColumnIndex(PROFILE_COLUMN_BIO));
            profiles.add(new Profile(profileId, profileName, profilePhoneNo, profileBio));
        }
        cursor.close();
        return profiles;
    }

    /*Message_Table*/
    public void insertMessage(Message message) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MESSAGE_COLUMN_ID, message.getMessageId());
        contentValues.put(MESSAGE_COLUMN_MESSAGES, message.getMessages());
        contentValues.put(MESSAGE_COLUMN_SENDERID, message.getSenderId());
        contentValues.put(MESSAGE_COLUMN_RECIEVERID, message.getMessageId());
        contentValues.put(MESSAGE_COLUMN_SENDTIME, message.getSendTime());
        contentValues.put(MESSAGE_COLUMN_RECIEVETIME, message.getRecieveTime());
        contentValues.put(MESSAGE_COLUMN_MEDIA, message.getMedia());
        contentValues.put(MESSAGE_COLUMN_LINKS, message.getLinks());
        contentValues.put(MESSAGE_COLUMN_DOCS, message.getDocs());
        db.insert(MESSAGE_TABLE_NAME, null, contentValues);
    }

    public List<Message> getAllMessage() {
        List<Message> messageList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(MESSAGE_TABLE_NAME, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String messageId = cursor.getString(cursor.getColumnIndex(MESSAGE_COLUMN_ID));
            String sendId = cursor.getString(cursor.getColumnIndex(MESSAGE_COLUMN_SENDERID));
            String recieveId = cursor.getString(cursor.getColumnIndex(MESSAGE_COLUMN_RECIEVERID));
            String messages = cursor.getString(cursor.getColumnIndex(MESSAGE_COLUMN_MESSAGES));
            String sendTime = cursor.getString(cursor.getColumnIndex(MESSAGE_COLUMN_SENDTIME));
            String recieveTime = cursor.getString(cursor.getColumnIndex(MESSAGE_COLUMN_RECIEVETIME));
            //String media = cursor.getString(cursor.getColumnIndex(MESSAGE_COLUMN_MEDIA));
            //String links = cursor.getString(cursor.getColumnIndex(MESSAGE_COLUMN_LINKS));
            //String docs = cursor.getString(cursor.getColumnIndex(MESSAGE_COLUMN_DOCS));
            messageList.add(new Message(messageId, sendId, recieveId, messages, sendTime, recieveTime));
        }
        cursor.close();
        return messageList;
    }
}
