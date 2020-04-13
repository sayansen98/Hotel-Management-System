package com.example.hotelmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class databasehelper extends SQLiteOpenHelper {



    public static final String DATABASE_NAME="register.db";
    public static final String TABLE_NAME="registeruser";
    public static final String TABLE_NAME1="registeruser1";
    public static final String   col_1="id";
    public static final String col_3="password";
    public static final String col_2="Email";


    public databasehelper(Context context)
    {
        super(context,DATABASE_NAME,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE registeruser(id INTEGER PRIMARY KEY AUTOINCREMENT,email TEXT,password TEXT )");
        sqLiteDatabase.execSQL("CREATE TABLE registeruser1(id INTEGER PRIMARY KEY AUTOINCREMENT,email TEXT,hoteln TEXT,qty TEXT,amount TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int j) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME1);
        onCreate(sqLiteDatabase);
    }

    public long adduser(String email,String password)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("Email",email);
        contentValues.put( "password",password);

        long res=db.insert("registeruser",null,contentValues);
        db.close();
        return res;


    }
    public long addhotel(String email,String hotel,String qty,String price)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("email",email);
        contentValues.put("hoteln",hotel);
        contentValues.put("qty",qty);
        contentValues.put("amount",price);


        long res=db.insert("registeruser1",null,contentValues);
        db.close();
        return res;


    }
    public String getString( Cursor cursor, int columnIndex )
    {
        String value = "";


            if ( !cursor.isNull( columnIndex ) )
            {
                value = cursor.getString( columnIndex );
            }
            else
            {
                value=""+columnIndex;
            }

        return value;
    }
    public String gethotels(String email)
    {

        SQLiteDatabase db = getReadableDatabase();


        Cursor cursor =db.rawQuery("SELECT * FROM registeruser1 where email='"+email+"'",null);
        String h="";

        if(cursor.moveToFirst())
        {
            do
            {
                h+="Name: "+getString(cursor,cursor.getColumnIndex("hoteln"))+ "qty:"+getString(cursor,cursor.getColumnIndex(" qty"))+" amount:"+getString(cursor,cursor.getColumnIndex("amount"))+"\n";
            }
            while(cursor.moveToNext());

        }
        else
        {
            h="No Records found";
        }
        db.close();
        return h;

    }
    public boolean chkuser(String email,String password) {
        String[] columns = {col_1};
        SQLiteDatabase db = getReadableDatabase();
        String selection = col_2 + "=?" + "and " + col_3 + "=?";
        String[] selectionarg = {email, password};
        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionarg, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();
        if (count > 0)
            return true;
        else
            return false;
    }


}

