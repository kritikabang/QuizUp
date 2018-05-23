package com.coder.quizup;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class dbHelper2 extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="register.db";
    public static final String TABLE_NAME2="score";
    public static final String COLO_1="ID";
    public static final String COLO_2="Name";
    public static final String COLO_3="Result";
    private static final String CREATE_TABLE2= " CREATE TABLE " + TABLE_NAME2 + " ( " +
            COLO_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLO_2 + " TEXT NOT NULL, " +
            COLO_3 + " TEXT " +
            ")";
    private static final String DROP_TABLE = " DROP TABLE " + TABLE_NAME2;
    public dbHelper2(Context context) {
        super(context, DATABASE_NAME, null, 2);
    }
    SQLiteDatabase database;
    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Password TEXT,Email TEXT,Phone TEXT)");
        db.execSQL(CREATE_TABLE2);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2); //Drop older table if exists
        onCreate(db);
    }


}
