package com.example.sandumihai.discovertheworld;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelperLogin extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "users.db";
    private static final String TABLE_NAME = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";
    SQLiteDatabase db;

    private static final String TABLE_CREATE = "create table users (id integer primary key not null, " +
            " email text not null, username text not null, password text not null);";

    public DataBaseHelperLogin(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db=db;
    }

    public void insertUser(Contact contact){
        db=this.getWritableDatabase();
        ContentValues cvalues=new ContentValues();
        String query="select * from users";
        Cursor cursor=db.rawQuery(query,null);
        int count=cursor.getCount();

        cvalues.put(COLUMN_ID,count);
        cvalues.put(COLUMN_EMAIL,contact.getEmail());
        cvalues.put(COLUMN_USERNAME,contact.getUsername());
        cvalues.put(COLUMN_PASSWORD,contact.getPassword());

        db.insert(TABLE_NAME, null, cvalues);
        db.close();
    }

    public String searchPassword(String username){
        db=this.getReadableDatabase();
        String query="select username,password from " + TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        String a,b;
            b="not found";
        if(cursor.moveToFirst()){
            do{
                a=cursor.getString(0);

                if(a.equals(username)){
                    b=cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query="DROP TABLE IF EXISTS" + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
