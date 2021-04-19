package com.premiumtechs.chirkut;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "chirkut.db";
    public static final String PROFILE_TABLE_NAME = "profile";
    public static final String PROFILE_COLUMN_ID = "profileId";
    public static final String PROFILE_COLUMN_NAME = "profileName";
    public static final String PROFILE_COLUMN_BIO = "profileBio";
    public static final String PROFILE_CREATE_TABLE = "create table IF NOT EXISTS "
            + PROFILE_TABLE_NAME
            + "(" + PROFILE_COLUMN_ID + " integer primary key autoincrement, "
            + PROFILE_COLUMN_NAME + "text," + PROFILE_COLUMN_BIO + "text)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqliteDatabase) {
        sqliteDatabase.execSQL(PROFILE_CREATE_TABLE);
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
        contentValues.put(PROFILE_COLUMN_NAME, profile.getProfileName());
        contentValues.put(PROFILE_COLUMN_BIO, profile.getProfileBio());
        db.insert(PROFILE_TABLE_NAME, null, contentValues);
    }

    public List<Profile> getAllProfile() {
        List<Profile> profiles = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(PROFILE_TABLE_NAME, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String profileId = cursor.getString(cursor.getColumnIndex(PROFILE_COLUMN_ID));
            String profileName = cursor.getString(cursor.getColumnIndex(PROFILE_COLUMN_NAME));
            String profileBio = cursor.getString(cursor.getColumnIndex(PROFILE_COLUMN_BIO));
            profiles.add(new Profile(profileId, profileName, profileBio));
        }
        return profiles;
    }
}
