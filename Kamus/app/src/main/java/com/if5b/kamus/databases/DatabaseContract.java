package com.if5b.kamus.databases;

import android.provider.BaseColumns;

public class DatabaseContract {
    static String TABLE_NAME = "english_indonesia";

    static final class EnglishIndonesiaColumn implements BaseColumns {
        static String ENGLISH_INDONESIA_TITLE = "title";
        static String ENGLISH_INDONESIA_DESC = "description";
    }
}
