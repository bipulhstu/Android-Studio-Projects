package com.bipul.example.sqlitedisplayalldata;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

class MyDatabaseHelper {
    private static final String DATABASE_NAME = "student.db";
    private static final String TABLE_NAME = "student_details";
    private static final String ID = "_id";

    private static final String NAME = "Name";
    private static final String AGE = "Age";
    private static final String GENDER = "Gender";
    private static final int VERSION_NUMBER = 2;

    public MyDatabaseHelper(MainActivity mainActivity) {

    }

    public SQLiteDatabase getWritableDatabase() {
        return null;
    }

    public long insertData(String name, String age, String gender) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,name);
        contentValues.put(AGE,age);
        contentValues.put(GENDER,gender);

        long rowId = sqLiteDatabase.insert(TABLE_NAME, contentValues);

        return rowId;
        return 0;
    }
}
