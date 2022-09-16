package com.example.assign_2_bscs_19011519_006;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBName = "Login.db";

    public DBHelper(Context context) {
        super(context, DBName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        //execSQL will execute SQL query and we going to create table and its column
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop TABLE if exists users");
    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    // check user exist or not
    public Boolean checkUsername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[] {username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkUsernamePassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username, password});

        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
}
