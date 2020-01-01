package com.bipul.example.sqlitedatabasesignupsignin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "user_details.db";
    private static final String TABLE_NAME = "user_details";
    private static final String ID = "_id";
    private static final String NAME = "Name";
    private static final String EMAIL = "Email";
    private static final String USERNAME = "Username";
    private static final String PASSWORD = "Password";
    private static final int VERISON_NUMBER = 3;

    Context context;

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(255) NOT NULL, " + EMAIL + " TEXT NOT NULL, " + USERNAME + " TEXT NOT NULL, " + PASSWORD + " TEXT NOT NULL)";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERISON_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(CREATE_TABLE);

            Toast.makeText(context, "OnCreate is called", Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            Toast.makeText(context, "Exception : " + e, Toast.LENGTH_LONG).show();

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        try {
            Toast.makeText(context, "OnUpgrade is called", Toast.LENGTH_LONG).show();
            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);


        } catch (Exception e) {
            Toast.makeText(context, "Exception : " + e, Toast.LENGTH_LONG).show();

        }

    }
    public long insertData(UserDetails userDetails){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, userDetails.getName());
        contentValues.put(EMAIL, userDetails.getEmail());
        contentValues.put(USERNAME, userDetails.getUsername());
        contentValues.put(PASSWORD, userDetails.getPassword());

        long rowId = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        return rowId;
    }

    public Boolean findPassword(String uname, String pass){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME, null);
        Boolean result = false;

        if(cursor.getCount() == 0){
            Toast.makeText(context, "No data is found", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                String username = cursor.getString(3);
                String password = cursor.getString(4);

                if(username.equals(uname) && password.equals(pass)){
                    result = true;
                    break;
                }

            }
        }
        return result;

    }
}

