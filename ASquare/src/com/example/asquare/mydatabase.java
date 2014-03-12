package com.example.asquare;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class mydatabase extends SQLiteOpenHelper {

	private final static int _DBVersion = 1;
	private final static String _DBName = "SampleList.db";	
	private final static String _TableName = "MySample";
	
	public mydatabase(Context context) {
		super(context, _DBName, null, _DBVersion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		final String SQL = "CREATE TABLE IF NOT EXISTS " + _TableName + "( " +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
	               "_TITLE VARCHAR(50), " +
                "_CONTENT TEXT," +
	               "_KIND VARCHAR(10)" +
	           ");";
		db.execSQL(SQL);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		final String SQL = "DROP TABLE " + _TableName;
        db.execSQL(SQL);	
	}

}