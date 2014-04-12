package com.example.exam_count_down;

import java.io.IOException; 

import android.content.ContentValues;
import android.content.Context; 
import android.database.Cursor; 
import android.database.SQLException; 
import android.database.sqlite.SQLiteDatabase; 
import android.util.Log; 
 
public class DataBaseTestAdapter2  
{ 
    protected static final String TAG = "DataAdapter"; 
 
    private final Context mContext; 
    private SQLiteDatabase mDb; 
    private DataBaseHelper2 mDbHelper; 
 
    public DataBaseTestAdapter2(Context context)  
    { 
        this.mContext = context; 
        mDbHelper = new DataBaseHelper2(mContext); 
    } 
 
    public DataBaseTestAdapter2 createDatabase() throws SQLException  
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
 
    public DataBaseTestAdapter2 open() throws SQLException  
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
     
     

 	public boolean SaveData(String Code, String Date) 
 	{
 		try
 		{
            mDbHelper.openDataBase(); 
            mDbHelper.close(); 
            mDb = mDbHelper.getWritableDatabase(); 
            
            ContentValues cv = new ContentValues();
 			cv.put("Code", Code);
 			cv.put("Date", Date);
 			//cv.put("Number", email);
 			
 			mDb.insert("Exam", null, cv);
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

