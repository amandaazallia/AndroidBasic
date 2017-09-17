package com.example.android.jsonparser.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.HashMap;

/**
 * Created by Adroady on 9/15/2017.
 */

public class SQLiteHandler {
    private static final String TAG = SQLiteHandler.class.getSimpleName();

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "adroady_db";

    private static final String TABLE_USER = "publisher_user";

    private static final String KEY_ID = "id";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_ACCESS_TOKEN = "access_token";
    private static final String KEY_CREATED_AT = "created_at";

    public SQLiteHandler (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_LOGIN_TABLE = "CREATE TABLE " + TABLE_USER + "("
                + KEY_ID + "INTEGET PRIMARY KEY," + KEY_USERNAME + " TEXT,"
                + KEY_EMAIL + " TEXT_UNIQUE," + KEY_ACCESS_TOKEN + "TEXT,"
                + KEY_CREATED_AT + " TEXT" + ")";
        db.execSQL(CREATE_LOGIN_TABLE);

        Log.d(TAG, "Database tables created");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);

        onCreate(db);
    }
    public void addUser(String username, String email, String access_token, String created_at){
        SQLiteDatabase db = this.getWritableDatabes();

        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, username);
        values.put(KEY_EMAIL, email);
        values.put(KEY_ACCESS_TOKEN, access_token);
        values.put(KEY_CREATED_AT, created_at);

        long id = db.insert(TABLE_USER, null, values);
        db.close();

        Log.d(TAG, "New User inserted to sqlite: " + id);

    }
    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<String, String>();
        String selectQuery = "SELECT * FROM " + TABLE_USER;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            user.put("username", cursor.getString(1));
            user.put("email", cursor.getString(2));
            user.put("access_token", cursor.getString(3));
            user.put("created_at", cursor.getString(4));

        }
        cursor.close();
        db.close();

        Log.d(TAG, "Fetching user from sqlite: " + user.toString());

        return user;

    }
    public void deleteUsers(){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_USER, null, null);
        db.close();

        Log.d(TAG, "Deleted all user info from sqlite");
    }
}


short for "magnitude" ,
        where the earthquake accured ,
        when the earthquake accured ,
        how strong this quake was felt ,
        was there a tsunami alert issued? ,
        the title of the quake (mag + place) ,
        where the earthquake occured ( long, lat, depth )