package com.example.study_path;

import com.example.asquare.R;
import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class Study_Path extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
        setContentView(R.layout.path_main);       
	    // TODO Auto-generated method stub
	    button1 = (Button)findViewById(R.id.button1);
	    button2 = (Button)findViewById(R.id.button2);
	    button3 = (Button)findViewById(R.id.button3);
	    button4 = (Button)findViewById(R.id.button4);
	    
	    listView1 = (ListView) findViewById(R.id.listView1);
       	edittext1 = (EditText) findViewById(R.id.editText1);

        button1.setOnClickListener(new Button.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	listView1.setAdapter(get(edittext1.getText().toString(), "1"));
            	
            	/*String A = data.get(edittext1.getText().toString(), 1);
            	textView2.setText(A);  
            	String B = data.get(edittext1.getText().toString(), 2);
            	textView3.setText(B);  
            	String C = data.get(edittext1.getText().toString(), 3);
            	textView4.setText(C);  
            	
            	
            	if	(C.equals(" "))
            			Toast.makeText(Study_Path.this, "Wrong Major", Toast.LENGTH_LONG).show();
            */
        		}
        });
        
        button2.setOnClickListener(new Button.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	listView1.setAdapter(get(edittext1.getText().toString(), "1"));
            	/*String A = data.get(edittext1.getText().toString(), 1);
            	textView2.setText(A);  
            	String B = data.get(edittext1.getText().toString(), 2);
            	textView3.setText(B);  
            	String C = data.get(edittext1.getText().toString(), 3);
            	textView4.setText(C);  
            	
            	
            	if	(C.equals(" "))
            			Toast.makeText(Study_Path.this, "Wrong Major", Toast.LENGTH_LONG).show();
            */
        		}
        });
        
        button3.setOnClickListener(new Button.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	listView1.setAdapter(get(edittext1.getText().toString(), "2"));
            	
            	/*String A = data.get(edittext1.getText().toString(), 1);
            	textView2.setText(A);  
            	String B = data.get(edittext1.getText().toString(), 2);
            	textView3.setText(B);  
            	String C = data.get(edittext1.getText().toString(), 3);
            	textView4.setText(C);  
            	
            	
            	if	(C.equals(" "))
            			Toast.makeText(Study_Path.this, "Wrong Major", Toast.LENGTH_LONG).show();
            */
        		}
        });
        
        button4.setOnClickListener(new Button.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	listView1.setAdapter(get(edittext1.getText().toString(), "3"));
            	
            	/*String A = data.get(edittext1.getText().toString(), 1);
            	textView2.setText(A);  
            	String B = data.get(edittext1.getText().toString(), 2);
            	textView3.setText(B);  
            	String C = data.get(edittext1.getText().toString(), 3);
            	textView4.setText(C);  
            	
            	
            	if	(C.equals(" "))
            			Toast.makeText(Study_Path.this, "Wrong Major", Toast.LENGTH_LONG).show();
            */
        		}
        });
        
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) { 
				// TODO Auto-generated method stub
				ListView listView = (ListView) arg0;
				Toast.makeText(
				Study_Path.this, listView.getItemAtPosition(arg2).toString(), Toast.LENGTH_SHORT).show();

			}
		});
	}
	
	
	public ArrayAdapter<String> get(String major, String year) {
	    // TODO Auto-generated method stub
		TestAdapter mDbHelper = new TestAdapter(this);         
    	mDbHelper.createDatabase();       
    	mDbHelper.open(); 
    	 
    	ArrayAdapter<String> adapter;
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
    	//Utility.ShowMessageBox(this, "hi");
		
        String sql ="SELECT Course.Code, Name, Sem from Course, " + major + " WHERE Course.Code = " + major +".Code AND Year=" + year +" ORDER BY Sem"; 
    	Cursor testdata = mDbHelper.getTestData(sql); 
    	String code = Utility.GetColumnValue(testdata, "Code");
    	String name = Utility.GetColumnValue(testdata, "Name");
    	String sem = Utility.GetColumnValue(testdata, "Sem");
    	adapter.add(code + " (" + sem + ")" + "\n"+ name);
    	while (testdata.moveToNext()){
    		 
        	code = Utility.GetColumnValue(testdata, "Code");
        	name = Utility.GetColumnValue(testdata, "Name");
        	sem = Utility.GetColumnValue(testdata, "Sem");
        	adapter.add(code + " (" + sem + ")" + "\n"+ name);
    	}
    	
    	//Utility.ShowMessageBox(this, result);
    	mDbHelper.close();
				
		return adapter;
	}
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private EditText edittext1;
    private ListView listView1;
}