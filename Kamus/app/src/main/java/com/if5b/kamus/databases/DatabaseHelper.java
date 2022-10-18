package com.if5b.kamus.databases;

import static android.provider.BaseColumns._ID;
import static com.if5b.kamus.databases.DatabaseContract.EnglishIndonesiaColumn.ENGLISH_INDONESIA_DESC;
import static com.if5b.kamus.databases.DatabaseContract.EnglishIndonesiaColumn.ENGLISH_INDONESIA_TITLE;
import static com.if5b.kamus.databases.DatabaseContract.TABLE_NAME;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static String DB_NAME = "dbkamus";
    private static final int DB_VERSION = 1;

    public static String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ENGLISH_INDONESIA_TITLE + " TEXT NOT NULL, " + ENGLISH_INDONESIA_DESC + " TEXT NOT NULL);";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
