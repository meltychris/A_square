package com.example.chatroom;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.asquare.R;

public class ChatHelpActivity  extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
		setContentView(R.layout.chat_help);
		
     	listView = (ListView)findViewById(R.id.helplist);

	    Bundle params = getIntent().getExtras();
     	if (params!= null) {
	    	name = params.getString ("name");
     	}   	
	    setTitle("Helps from " + name);

	    update();

	}
	
	public List<String> get_list(){
		DataBaseTestAdapter3 mDbHelper = new DataBaseTestAdapter3(ChatHelpActivity.this);         
	    mDbHelper.createDatabase();       
	    mDbHelper.open(); 
	    	
		String sql ="SELECT Msg, Author FROM help WHERE Author='" + name + "' ORDER BY _id"; 
		Cursor testdata = mDbHelper.getTestData(sql); 
		String Msg = DataBaseUtility3.GetColumnValue(testdata, "Msg");
		String Author = DataBaseUtility3.GetColumnValue(testdata, "Author");

	    List<String> list;
	    list = new ArrayList<String>();

		if (!Author.equals("")){
			list.add(Msg);   
		    while (testdata.moveToNext()){
		    	Msg = DataBaseUtility3.GetColumnValue(testdata, "Msg");
				list.add(Msg);   
			}
		}
			
		mDbHelper.close();

	    return list;		
	}
		
	private void update(){
		ArrayAdapter<String> adapter;
	    adapter = new ArrayAdapter<String>(ChatHelpActivity.this, android.R.layout.simple_list_item_1);   
	    List<String> data = new ArrayList<String>();
	    data = get_list();									//get from database

	    for (String i : data)
	    	adapter.add(i);

	  	listView.setAdapter(adapter);
	}
		
	ListView listView;
	String name;
}


