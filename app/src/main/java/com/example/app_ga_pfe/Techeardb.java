package com.example.app_ga_pfe;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Techeardb extends SQLiteOpenHelper {
    private static final String database="teachers.db";
    private static final int version = 1 ;
    private final String TABLE_NAME = "Teachers";
    private  String COLUMN_NAME = "NomPrenom";
    private  String COLUMN_CODE = "CodeTeach";
    private String createTableQuery ;
    public Techeardb(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE "+ TABLE_NAME+"("
                +COLUMN_NAME+"TEXT,"
                +COLUMN_CODE+"TEXT)";
        db.execSQL(createTableQuery);
        insertData(db,"alami nabil" , "1234");
        insertData(db,"fissaoui mohamed","5678");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists teachers");
        onCreate(db);
    }

    public boolean insertData(SQLiteDatabase db, String NOM, String CODE) {
        ContentValues Values = new ContentValues();
        Values.put(COLUMN_NAME,NOM);
        Values.put(COLUMN_CODE , CODE);
        long result = db.insert(TABLE_NAME , null , Values);
        return result != -1 ;

    }
}
