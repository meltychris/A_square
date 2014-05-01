package com.example.chatroom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.asquare.R;
import com.example.exam_count_down.DataBaseTestAdapter2;
import com.example.exam_count_down.DataBaseUtility2;
import com.example.exam_count_down.Exam_countdown;
import com.example.study_path.DataBaseTestAdapter1;
import com.example.study_path.DataBaseUtility1;

public class ChatroomActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
		setContentView(R.layout.chat_layout);
		
     	listView = (ListView)findViewById(R.id.msgbraod);
     	Send = (Button)findViewById(R.id.Send);
     	msg = (EditText)findViewById(R.id.msg);


	    Bundle params = getIntent().getExtras();
     	SharedPreferences preuser = getSharedPreferences("user", 0);
     	user = preuser.getString("user", "error");
	    //user = "STSK";
     	if (params!= null) {
	    	name = params.getString ("name");
     	}   	
	    setTitle("Chat with " + name);

	    update();

  		
  		
		Send.setOnClickListener(new Button.OnClickListener(){ 
			@Override
	 	    public void onClick(View v) {
				// TODO Auto-generated method stub
	 	        //add to database
	 	        add_item(msg.getText().toString());	
	 	        msg.setText("");
	 		    update();
	 	    }
		});
  		
	}
	
	public void add_item(String msg) {
	    // TODO Auto-generated method stub
		DataBaseTestAdapter3 mDbHelper = new DataBaseTestAdapter3(this);         
    	mDbHelper.createDatabase();       
    	mDbHelper.open(); 
    	
    	mDbHelper.SaveData(name, user, msg);
    	mDbHelper.close();
	}
	
	public List<String> get_list(){
		DataBaseTestAdapter3 mDbHelper = new DataBaseTestAdapter3(ChatroomActivity.this);         
    	mDbHelper.createDatabase();       
    	mDbHelper.open(); 
    	
		String sql ="SELECT Msg, Sender FROM chatroom WHERE (Sender='" + user + "' AND Receiver='" + name + "') OR (Sender='" + name + "' AND Receiver='" + user + "') ORDER BY _id"; 
		Cursor testdata = mDbHelper.getTestData(sql); 
		String Msg = DataBaseUtility3.GetColumnValue(testdata, "Msg");
		String Sender = DataBaseUtility3.GetColumnValue(testdata, "Sender");
		
    	List<String> list;
     	list = new ArrayList<String>();

		if (!Sender.equals("")){
			if (Sender.equals(user))
				list.add("<<<" + "\t\t"+ Msg);   
			else
				list.add(">>>" + "\t\t"+ Msg);   
			
	    	while (testdata.moveToNext()){
	    		Msg = DataBaseUtility3.GetColumnValue(testdata, "Msg");
	    		Sender = DataBaseUtility3.GetColumnValue(testdata, "Sender");
				if (Sender.equals(user))
					list.add("<<<" + "\t\t"+ Msg);   
				else
					list.add(">>>" + "\t\t"+ Msg);   				
				}
		}
		
		mDbHelper.close();
    	return list;		
	}
	
	private void update(){
		ArrayAdapter<String> adapter;
      	adapter = new ArrayAdapter<String>(ChatroomActivity.this, android.R.layout.simple_list_item_1);   
      	List<String> data = new ArrayList<String>();
      	data = get_list();									//get from database
      	for (String i : data)
      		adapter.add(i);
  		listView.setAdapter(adapter);
	}
	
	ListView listView;
	String name;
	String user;
	Button Send;
	EditText msg;
}
