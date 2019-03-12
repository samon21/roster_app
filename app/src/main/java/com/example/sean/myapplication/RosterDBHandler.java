package com.example.sean.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import android.support.annotation.Nullable;

public class RosterDBHandler extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "roster.db";
    public static final String TABLE_PERSONNEL_NAME = "personnel";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";

    public RosterDBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_PERSONNEL_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT "
                + ");";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSONNEL_NAME);
    onCreate(db);
    }

    //add a person to database
    public void addPersonnel(Personnel personnel){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, personnel.get_name());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PERSONNEL_NAME, null, values);
        db.close();

    }

    //delete a person from the database
    public void removePersonnel(String name)
    {
        SQLiteDatabase db = getWritableDatabase();
db.execSQL("DELETE FROM " + TABLE_PERSONNEL_NAME + " WHERE " + COLUMN_NAME + "=\""+name+"\";");
    }

    public String dbToString()
    {
        String result = "";
        SQLiteDatabase db = getWritableDatabase();

        String query = " SELECT * FROM " + TABLE_PERSONNEL_NAME + " WHERE 1;";
        db.execSQL(query);

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        while(!c.isAfterLast())
        {
            if(c.getString(c.getColumnIndex(COLUMN_NAME)) != null){
                result += c.getString(c.getColumnIndex(COLUMN_NAME));
                result += "\n";
            }
        }
        db.close();
        return result;
    }
}
