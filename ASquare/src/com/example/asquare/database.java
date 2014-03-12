package com.example.asquare;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
http://jim690701.blogspot.hk/2012/06/android-sqlite.html


public class database extends SQLiteOpenHelper {            
	
	
	onUpgrade()
	private static final int VERSION = 1;

	
	public NewListDataSQL(Context context, String name, CursorFactory factory,int version) 
	{    super(context, name, factory, version);   }     
	
	public NewListDataSQL(Context context,String name) {
		this(context, name, null, VERSION);
		}         
	
	public NewListDataSQL(Context context, String name, int version){       
		this(context, name, null, version);
		}

	@Override  
	public void onCreate(SQLiteDatabase db) {
		String DATABASE_CREATE_TABLE =      "create table newMemorandum("       + "_ID INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL,"             + "date VARCHAR,"             + "note VARCHAR,"             + "pw VARCHAR,"             + "reminder INT,"             + "type VARCHAR,"             + "memo VARCHAR"         + ")";
		db.execSQL(DATABASE_CREATE_TABLE);
		}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		}
	@Override
	public void onOpen(SQLiteDatabase db) {
		super.onOpen(db);
		}
	
	@Override
	public synchronized void close() {
		super.close();
		}
	}

}

 
import android.content.ContentValues; 
import android.content.Context; 
import android.database.Cursor; 
import android.database.sqlite.SQLiteDatabase; 
import android.database.sqlite.SQLiteOpenHelper; 
import android.database.sqlite.SQLiteDatabase.CursorFactory;   
