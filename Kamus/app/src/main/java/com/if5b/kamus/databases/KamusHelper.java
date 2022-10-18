package com.if5b.kamus.databases;

import static android.provider.BaseColumns._ID;
import static com.if5b.kamus.databases.DatabaseContract.EnglishIndonesiaColumn.ENGLISH_INDONESIA_DESC;
import static com.if5b.kamus.databases.DatabaseContract.EnglishIndonesiaColumn.ENGLISH_INDONESIA_TITLE;
import static com.if5b.kamus.databases.DatabaseContract.TABLE_NAME;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.if5b.kamus.models.Kamus;

import java.util.ArrayList;

public class KamusHelper {
    private Context context;
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;

    public KamusHelper(Context context) {
        this.context = context;
    }

    public KamusHelper open() throws SQLException {
        databaseHelper = new DatabaseHelper(context);
        database = databaseHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        databaseHelper.close();
    }

    public ArrayList<Kamus> getAllDatabyTitle(String title) {
        Cursor cursor = database.query(TABLE_NAME,
                null,
                ENGLISH_INDONESIA_TITLE + " LIKE ?",
                new String[] {"%" + title + "%"},
                null,
                null,
                _ID + " ASC",
                null);
        cursor.moveToFirst();
        ArrayList<Kamus> arrayList = new ArrayList<>();
        Kamus kamus;
        if (cursor.getCount() > 0) {
            do {
                kamus = new Kamus();
                kamus.setId(cursor.getInt(cursor.getColumnIndexOrThrow(_ID)));
                kamus.setTitle(cursor.getString(cursor.getColumnIndexOrThrow(ENGLISH_INDONESIA_TITLE)));
                kamus.setDesc(cursor.getString(cursor.getColumnIndexOrThrow(ENGLISH_INDONESIA_DESC)));

                arrayList.add(kamus);
                cursor.moveToNext();
            } while (!cursor.isAfterLast());
        }
        cursor.close();
        return arrayList;
    }

    public ArrayList<Kamus> getAllData() {
        Cursor cursor = database.query(TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                _ID + " ASC",
                null);
        cursor.moveToFirst();
        ArrayList<Kamus> arrayList = new ArrayList<>();
        Kamus kamus;
        if (cursor.getCount() > 0) {
            do {
                kamus = new Kamus();
                kamus.setId(cursor.getInt(cursor.getColumnIndexOrThrow(_ID)));
                kamus.setTitle(cursor.getString(cursor.getColumnIndexOrThrow(ENGLISH_INDONESIA_TITLE)));
                kamus.setDesc(cursor.getString(cursor.getColumnIndexOrThrow(ENGLISH_INDONESIA_DESC)));

                arrayList.add(kamus);
                cursor.moveToNext();
            } while (!cursor.isAfterLast());
        }
        cursor.close();
        return arrayList;
    }

    public long insertData(Kamus kamus) {
        ContentValues cv = new ContentValues();
        cv.put(ENGLISH_INDONESIA_TITLE, kamus.getTitle());
        cv.put(ENGLISH_INDONESIA_DESC, kamus.getDesc());
        return database.insert(TABLE_NAME, null, cv);
    }

    public int updateData(Kamus kamus) {
        ContentValues cv = new ContentValues();
        cv.put(ENGLISH_INDONESIA_TITLE, kamus.getTitle());
        cv.put(ENGLISH_INDONESIA_DESC, kamus.getDesc());
        return database.update(TABLE_NAME, cv,  _ID + "= '" + kamus.getId() + "'", null);
    }

    public int deleteData(int id) {
        return database.delete(TABLE_NAME,   _ID + "= '" + id + "'", null);
    }
}
