package com.example.exam_count_down;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.example.asquare.R;



public class Exam_countdown extends Activity {



	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
		setContentView(R.layout.exam_main);
		
	//	createScheduledNotification(1);

		
	    // TODO Auto-generated method stub
		 button1 = (Button)findViewById(R.id.Add);
		 button2 = (Button)findViewById(R.id.Delete);
		 button3 = (Button)findViewById(R.id.reset);
      	 listView1 = (ListView)findViewById(R.id.listView1);
      	 Code = (EditText)findViewById(R.id.Code);
      	 Date = (EditText)findViewById(R.id.Date);
      	 
      	Calendar rightNow = Calendar.getInstance();
     	String CurrentTime = Dateformat.format(rightNow.getTime());
     	
      	ArrayAdapter<String> adapter;
      	adapter = new ArrayAdapter<String>(Exam_countdown.this, android.R.layout.simple_list_item_1);   
      	List<String> data = new ArrayList<String>();
      	data = get_list();									//get from database
      	for (String i : data)
      		adapter.add(i);
      	
  		listView1.setAdapter(adapter);
  		Random testing = new Random(100);

		//notification bar
        int j = testing.nextInt();
 /*       if (!data.isEmpty()){
	        for (int i = 0; i< data.size(); i++){
				Intent intent = new Intent(this,MyBroadcastReceiver.class);
		        intent.putExtra ("Course", data.get(i));
		        intent.putExtra ("Num", j);
		
				PendingIntent pendingIntent = PendingIntent.getBroadcast(
						this.getApplicationContext(), 234324243+i, intent, PendingIntent.FLAG_UPDATE_CURRENT);
				AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
				alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+ (1 * 1000), pendingIntent);
				j++;
				
				
	        }
        }*/
		 
        
		 button1.setOnClickListener(new Button.OnClickListener(){ 
 	        @Override
 	        public void onClick(View v) {
 	            // TODO Auto-generated method stub
 	        	if (!Code.getText().toString().equals("") && !Date.getText().toString().equals("")){
	 	        	add_item(Code.getText().toString(), Date.getText().toString());	
	 	        	//add to database
	 	        	Calendar tmp = Calendar.getInstance();
	 	        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 	        	try {
						tmp.setTime(sdf.parse(Date.getText().toString()+" 12:00:00"));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	 	        	long Dateinmillisecond = tmp.getTimeInMillis();
	 	        	createScheduledNotification(Dateinmillisecond,Code.getText().toString(), Date.getText().toString());
	 	        	
	 	        	ArrayAdapter<String> adapter;
	 	        	adapter = new ArrayAdapter<String>(Exam_countdown.this, android.R.layout.simple_list_item_1);   
	 	        	List<String> data = new ArrayList<String>();
	 	        	data = get_list();									//get from database
	 	        	for (String i : data)
	 	        		adapter.add(i);
	 	        	
	
	 	    		listView1.setAdapter(adapter);
 	        	}
 	    	}
 	    });
		 
		 button2.setOnClickListener(new Button.OnClickListener(){ 
	 	        @Override
	 	        public void onClick(View v) {
	 	            // TODO Auto-generated method stub
	 	        	delete_item(Code.getText().toString()); 
	 	        	
	 	        	ArrayAdapter<String> adapter;
	 	        	adapter = new ArrayAdapter<String>(Exam_countdown.this, android.R.layout.simple_list_item_1);   
	 	        	List<String> data = new ArrayList<String>();
	 	        	data = get_list();									//get from database
	 	        	for (String i : data)
	 	        		adapter.add(i);
	 	        	
	 	    		listView1.setAdapter(adapter);
	 	    		}
	 	    });
		 
		 button3.setOnClickListener(new Button.OnClickListener(){ 
	 	        @Override
	 	        public void onClick(View v) {
	 	            // TODO Auto-generated method stub
	 	        	delete_table();
	 	        	
	 	        	ArrayAdapter<String> adapter;
	 	        	adapter = new ArrayAdapter<String>(Exam_countdown.this, android.R.layout.simple_list_item_1);   
	 	        	adapter.clear();
	 	        	//List<String> data = new ArrayList<String>();
	 	        	//data = get_list();									//get from database
	 	        	//for (String i : data)
	 	        	//	adapter.add(i);
	 	        	
	 	    		listView1.setAdapter(adapter);
	 	    		}
	 	    });
	}

	
	public void add_item(String Code, String Date) {
	    // TODO Auto-generated method stub
		DataBaseTestAdapter2 mDbHelper = new DataBaseTestAdapter2(this);         
    	mDbHelper.createDatabase();       
    	mDbHelper.open(); 
    	
    	mDbHelper.SaveData(Code, Date);
    	mDbHelper.close();
	}
	
	public void delete_item(String Code) {
	    // TODO Auto-generated method stub
		DataBaseTestAdapter2 mDbHelper = new DataBaseTestAdapter2(this);         
    	mDbHelper.createDatabase();       
    	mDbHelper.open(); 
    	
    	mDbHelper.delete_one(Code);
    	mDbHelper.close();
	}
	
	public void delete_table() {
	    // TODO Auto-generated method stub
		DataBaseTestAdapter2 mDbHelper = new DataBaseTestAdapter2(this);         
    	mDbHelper.createDatabase();       
    	mDbHelper.open(); 
    	
    	mDbHelper.delele_table();
    	mDbHelper.close();
	}
	
	public List<String> get_list(){
		DataBaseTestAdapter2 mDbHelper = new DataBaseTestAdapter2(Exam_countdown.this);         
    	mDbHelper.createDatabase();       
    	mDbHelper.open(); 
    	
		String sql ="SELECT Code, Date FROM Exam ORDER BY Date"; 
		Cursor testdata = mDbHelper.getTestData(sql); 
		String Code = DataBaseUtility2.GetColumnValue(testdata, "Code");
		String Date = DataBaseUtility2.GetColumnValue(testdata, "Date");
		
    	List<String> list;
     	list = new ArrayList<String>();

		if (!Code.equals("")){
	    	list.add(Code + "\t\t\t\t\t" + Date);
	    	while (testdata.moveToNext()){
	    		 
	    		Code = DataBaseUtility2.GetColumnValue(testdata, "Code");
	    		Date = DataBaseUtility2.GetColumnValue(testdata, "Date");
	        	list.add(Code + "\t\t\t\t\t" + Date);
	    	}
		}

		testdata.close();
		mDbHelper.close();
    	return list;		
	}
	
	public void createScheduledNotification(long millisecond, String Course, String Date)
	 {
	 // Get new calendar object and set the date to now
	 Calendar calendar = Calendar.getInstance();
	 calendar.setTimeInMillis(System.currentTimeMillis());
	 // Add defined amount of days to the date
	 //calendar.add(Calendar.MILLISECOND, millisecond);

	 // Retrieve alarm manager from the system
	 AlarmManager alarmManager = (AlarmManager) getApplicationContext().getSystemService(getBaseContext().ALARM_SERVICE);
	 // Every scheduled intent needs a different ID, else it is just executed once
	 int id = (int) System.currentTimeMillis();

	 
	 
	 // Prepare the intent which should be launched at the date
	 id = id +global_j;
	 Intent intent = new Intent(this, MyBroadcastReceiver.class);
	 intent.putExtra ("Course", Course);
	 intent.putExtra ("Num", global_j);
	 // Prepare the pending intent
	 PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 234324243+global_id, intent, PendingIntent.FLAG_UPDATE_CURRENT);
	 global_id++;
	 global_j++;
	 // Register the alert in the system. You have the option to define if the device has to wake up on the alert or not
	 alarmManager.set(AlarmManager.RTC_WAKEUP, millisecond, pendingIntent);
	 
	 
	 }


	
	Random testing = new Random(100);
    int global_j = testing.nextInt();
	int global_id = 1;
	private SimpleDateFormat Dateformat = new SimpleDateFormat("yyyy/MM/dd (E)");    		
	private Button button1;
	private Button button2;
	private Button button3;
	private ListView listView1;
	private EditText Code;
	private EditText Date;
}
