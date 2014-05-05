package com.example.chatroom;

import java.util.ArrayList;
import java.util.List;

import com.example.asquare.R;
import com.example.study_path.Advanced_Activity2;

import android.app.Activity;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MentorMain extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
		setContentView(R.layout.chat_mentor_main);
		
	    button1 = (Button)findViewById(R.id.button1);
	    button2 = (Button)findViewById(R.id.button2);
	    Send = (Button)findViewById(R.id.Send);
       	view1 = (View) findViewById(R.id.View1);
    	view2 = (View) findViewById(R.id.View2);
	    listView = (ListView)findViewById(R.id.msgbraod);
	    msg = (EditText)findViewById(R.id.msg);

	    SharedPreferences shareduser = getSharedPreferences("user", 0);
 		user = shareduser.getString("user", "Ken");
 		
    	view1.setVisibility(View.VISIBLE);
    	view2.setVisibility(View.INVISIBLE);
    	type = 0;
    	
	    setTitle(user + "'s room");
 		update(); 		
 		
 		
 		button1.setOnClickListener(new Button.OnClickListener(){ 
	        @Override
	        public void onClick(View v) {
	            // TODO Auto-generated method stub
	        	view1.setVisibility(View.VISIBLE);
	        	view2.setVisibility(View.INVISIBLE);
	        	
	        	name = "";			//initialize
	        	type = 0;
	     		update(); 		
	        }
	    });
 		
 		button2.setOnClickListener(new Button.OnClickListener(){ 
	        @Override
	        public void onClick(View v) {
	            // TODO Auto-generated method stub	
	        	view1.setVisibility(View.INVISIBLE);
	        	view2.setVisibility(View.VISIBLE);
	        	type = 1;
	     		update(); 		
	    	}
	    });
 		
 		Send.setOnClickListener(new Button.OnClickListener(){ 
	        @Override
	        public void onClick(View v) {
	            // TODO Auto-generated method stub	
	        	if (type == 0)
		        	if (name.equals(""))
						Toast.makeText(MentorMain.this, "Please choose a receiver first!", Toast.LENGTH_SHORT).show();
		        	else if (name.equals(user))
						Toast.makeText(MentorMain.this, "Please choose a right receiver first!", Toast.LENGTH_SHORT).show();
		        	else{
		        		add_msg(msg.getText().toString());
			        	msg.setText("");
			     		update(); 
		        	}
	        	else{
	        		add_info(msg.getText().toString());
		        	msg.setText("");
		     		update(); 
	        	}


	    	}
	    });
 		
 		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) { 
				// TODO Auto-generated method stub
				ListView listView = (ListView) arg0;
				
	        	if (type == 0){
					name = listView.getItemAtPosition(arg2).toString().substring(0, listView.getItemAtPosition(arg2).toString().indexOf(" sent"));
					Toast.makeText(MentorMain.this, "Send to " + name, Toast.LENGTH_SHORT).show();
	        	}
	        	else
					Toast.makeText(MentorMain.this, listView.getItemAtPosition(arg2).toString(), Toast.LENGTH_SHORT).show();

			}
		});


 		
	}
	
	public void add_msg(String msg) {
	    // TODO Auto-generated method stub
		DataBaseTestAdapter3 mDbHelper = new DataBaseTestAdapter3(this);         
    	mDbHelper.createDatabase();       
    	mDbHelper.open(); 
    	
    	mDbHelper.SaveData(name, user, msg);
    	mDbHelper.close();
	}
	
	public void add_info(String msg) {
	    // TODO Auto-generated method stub
		DataBaseTestAdapter3 mDbHelper = new DataBaseTestAdapter3(this);         
    	mDbHelper.createDatabase();       
    	mDbHelper.open(); 
    	
    	mDbHelper.SaveInfo(user, msg);
    	mDbHelper.close();
	}
	
	public List<String> get_msg(){
		DataBaseTestAdapter3 mDbHelper = new DataBaseTestAdapter3(MentorMain.this);         
    	mDbHelper.createDatabase();       
    	mDbHelper.open(); 
    	
		String sql ="SELECT Msg, Sender, Receiver FROM chatroom WHERE Sender='" + user + "' OR Receiver='" + user + "' ORDER BY _id"; 
		Cursor testdata = mDbHelper.getTestData(sql); 
		String Msg = DataBaseUtility3.GetColumnValue(testdata, "Msg");
		String Sender = DataBaseUtility3.GetColumnValue(testdata, "Sender");
		String Receiver = DataBaseUtility3.GetColumnValue(testdata, "Receiver");

		
    	List<String> list;
     	list = new ArrayList<String>();

		if (!Sender.equals("")){
			list.add(Sender + " sent to " +  Receiver + ":\n>>>> "+ Msg);   
	    	while (testdata.moveToNext()){
	    		Msg = DataBaseUtility3.GetColumnValue(testdata, "Msg");
	    		Sender = DataBaseUtility3.GetColumnValue(testdata, "Sender");
	    		Receiver = DataBaseUtility3.GetColumnValue(testdata, "Receiver");
				list.add(Sender + " sent to " +  Receiver + ":\n>>>> "+ Msg);   
	    	}
		}
		
		mDbHelper.close();
	    return list;		
	}
	
	public List<String> get_info(){
		DataBaseTestAdapter3 mDbHelper = new DataBaseTestAdapter3(MentorMain.this);         
    	mDbHelper.createDatabase();       
    	mDbHelper.open(); 
    	
		String sql ="SELECT Msg, Author FROM help WHERE Author='" + user + "' ORDER BY _id"; 
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
      	adapter = new ArrayAdapter<String>(MentorMain.this, android.R.layout.simple_list_item_1);   
      	List<String> data = new ArrayList<String>();
      	data = (type==0)?get_msg():get_info();									//get from database
      	for (String i : data)
      		adapter.add(i);
  		listView.setAdapter(adapter);
	}
	
	Button Send;
	ListView listView;
	View view1;
	View view2;
	Button button1;
	Button button2;
	String user;
	public String name = "";
	Integer type;
	EditText msg;
}
