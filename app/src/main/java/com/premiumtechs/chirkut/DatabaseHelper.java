package com.premiumtechs.chirkut;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.content.Context;
import android.os.Bundle;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "chirkut.db";
    public static final String PROFILE_TABLE_NAME = "profile";
    public static final String PROFILE_COLUMN_NAME = "profileName";
    public static final String PROFILE_COLUMN_BIO ="profileBio";
    public static final String PROFILE_CREATE_TABLE = "create table " +PROFILE_TABLE_NAME+
      "("+PROFILE_COLUMN_NAME+"text,"+PROFILE_COLUMN_BIO+"text)";

    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME, null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqliteDatabase) {
        sqliteDatabase.execSQL(PROFILE_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}

