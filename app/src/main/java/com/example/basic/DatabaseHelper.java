package com.example.basic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "CFG";
    private static final String Table_name = "userDetails";
    private static final String id = "id";
    private static final String name = "name";
    private static final String password = "password";
    private static final String phone = "phone";
    private static final String email = "email";
    SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME,null,1);
        Log.d("create","construct");
        db = getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        db.execSQL("create table userDetails(id integer primary key autoincrement,name text,phone text,email text,password text,gender text);");
        Log.d("create","created");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("Drop table if exists "+Table_name);
        onCreate(db);
    }

    public Boolean insertData(String name,String phone,String email,String password,String gender){
        //db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("name",name);
        content.put("phone",phone);
        content.put("email",email);
        content.put("password",password);
        content.put("gender",gender);

        long result = db.insert(Table_name,null,content);

        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getDataOnEmail(String email){
        Cursor cursor = db.rawQuery("select * from "+Table_name+" where email = '"+email+"'",null);
        return cursor;
    }
}