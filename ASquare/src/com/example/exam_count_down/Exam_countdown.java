package com.example.exam_count_down;

import java.util.ArrayList;
import java.util.List;

import com.example.asquare.R;
import com.example.study_path.Advanced_Activity2;
import com.example.study_path.DataBaseTestAdapter;
import com.example.study_path.DataBaseUtility;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class Exam_countdown extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
		setContentView(R.layout.exam_main);
		
	    // TODO Auto-generated method stub
		 button1 = (Button)findViewById(R.id.Add);
		 button2 = (Button)findViewById(R.id.Delete);
		 
		 button1.setOnClickListener(new Button.OnClickListener(){ 
 	        @Override
 	        public void onClick(View v) {
 	            // TODO Auto-generated method stub
 	        	
 	        	
 	    		
 	    //		listView1.setAdapter(adapter);
 	    		}
 	    });
	}

	
	public void add_item(String Code, String Date) {
	    // TODO Auto-generated method stub
		DataBaseTestAdapter mDbHelper = new DataBaseTestAdapter(this);         
    	mDbHelper.createDatabase();       
    	mDbHelper.open(); 
    	 
    	mDbHelper.SaveData(Code, Date);
    	mDbHelper.close();
	}
	
	    		
	private Button button1;
	private Button button2;
}
