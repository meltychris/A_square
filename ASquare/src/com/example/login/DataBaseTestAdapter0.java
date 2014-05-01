package com.example.login;

import java.io.IOException; 

import android.content.ContentValues;
import android.content.Context; 
import android.database.Cursor; 
import android.database.SQLException; 
import android.database.sqlite.SQLiteDatabase; 
import android.util.Log; 
 
public class DataBaseTestAdapter0  
{ 
    protected static final String TAG = "DataAdapter"; 
 
    private final Context mContext; 
    private SQLiteDatabase mDb; 
    private DataBaseHelper0 mDbHelper; 
 
    public DataBaseTestAdapter0(Context context)  
    { 
        this.mContext = context; 
        mDbHelper = new DataBaseHelper0(mContext); 
    } 
 
    public DataBaseTestAdapter0 createDatabase() throws SQLException  
    { 
        try  
        { 
            mDbHelper.createDataBase(); 
        }  
        catch (IOException mIOException)  
        { 
            Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase"); 
            throw new Error("UnableToCreateDatabase"); 
        } 
        return this; 
    } 
 
    public DataBaseTestAdapter0 open() throws SQLException  
    { 
        try  
        { 
            mDbHelper.openDataBase(); 
            mDbHelper.close(); 
            mDb = mDbHelper.getReadableDatabase(); 
        }  
        catch (SQLException mSQLException)  
        { 
            Log.e(TAG, "open >>"+ mSQLException.toString()); 
            throw mSQLException; 
        } 
        return this; 
    } 
 
    public void close()  
    { 
        mDbHelper.close(); 
    } 
 
     public Cursor getTestData(String sql) 
     { 
         try 
         { 
 
             Cursor mCur = mDb.rawQuery(sql, null); 
             if (mCur!=null) 
             { 
                mCur.moveToNext(); 
             } 
             return mCur; 
         } 
         catch (SQLException mSQLException)  
         { 
             Log.e(TAG, "getTestData >>"+ mSQLException.toString()); 
             throw mSQLException; 
         } 
     }
     
     

 	public boolean SaveData(String name, String user, String msg) 
 	{
 		try
 		{
            mDbHelper.openDataBase(); 
            mDbHelper.close(); 
            mDb = mDbHelper.getWritableDatabase(); 
            
            ContentValues cv = new ContentValues();
 			cv.put("Receiver", name);
 			cv.put("Sender", user);
 			cv.put("Msg", msg);
 			
 			mDb.insert("chatroom", null, cv);
 			mDb.close();

 			Log.d("Saved", "informationsaved");
 			return true;
 		}
 		catch(Exception ex)
 		{
 			Log.d("Saved", ex.toString());
 			return false;
 		}
 	}
     
    public void delele_table()  
    { 
    	//mDb.delete("Exam", null, null);
    	mDb.execSQL("DELETE FROM Exam");


    } 
    
    public void delete_one(String Course)  
    { 
    	mDb.execSQL("DELETE FROM Exam WHERE Code='" + Course +"'");

    } 

} 

