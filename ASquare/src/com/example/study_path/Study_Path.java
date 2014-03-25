package com.example.study_path;

import com.example.asquare.MainActivity;
import com.example.asquare.R;

import android.app.Activity;
import android.app.AliasActivity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

public class Study_Path extends Activity {

	protected static final Drawable FFFFFF = null;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
        setContentView(R.layout.path_main);       
	    // TODO Auto-generated method stub
	    button1 = (Button)findViewById(R.id.button1);
	    button2 = (Button)findViewById(R.id.button2);
	    button3 = (Button)findViewById(R.id.button3);
	    button4 = (Button)findViewById(R.id.button3);
	    
	    
	    listView1 = (ListView) findViewById(R.id.listView1);
       	
       	view1 = (View) findViewById(R.id.View1);
    	view2 = (View) findViewById(R.id.View2);
    	view3 = (View) findViewById(R.id.View3);
    	
    	view1.setVisibility(View.INVISIBLE);
    	view2.setVisibility(View.INVISIBLE);
    	view3.setVisibility(View.INVISIBLE);
    	
    	radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
    	radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
    	
    	major = "COMP";		//initial
    	year = "1";			//initial


        radioButton1.setOnClickListener(new RadioButton.OnClickListener(){ 
          /*   public void onRadioButtonClicked(View v) {
                // TODO Auto-generated method stub
            	
           	switch(v.getId()){
	            	case R.id.radioButton1:
	            		if (radioButton1.isChecked())
	                    	major = "COMP";
	            		break;
	            	
	        		case R.id.radioButton2:
		        		if (radioButton2.isChecked())
		        			//major = "CPEG";
		        		break;
        		}*/
            	
   
            	
            	
            	/*String A = data.get(edittext1.getText().toString(), 1);
            	textView2.setText(A);  
            	String B = data.get(edittext1.getText().toString(), 2);
            	textView3.setText(B);  
            	String C = data.get(edittext1.getText().toString(), 3);
            	textView4.setText(C);  
            	
            	
            	if	(C.equals(" "))
            			Toast.makeText(Study_Path.this, "Wrong Major", Toast.LENGTH_LONG).show();
            
        		}
*/
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				major = "COMP";
            	
            	listView1.setAdapter(get(major, year));

            	view1.setVisibility(View.INVISIBLE);
            	view2.setVisibility(View.INVISIBLE);
            	view3.setVisibility(View.INVISIBLE);
            	
            	if (year.equals("1"))
                	view1.setVisibility(View.VISIBLE);
            	else if (year.equals("2"))
                	view2.setVisibility(View.VISIBLE);
            	else
                	view3.setVisibility(View.VISIBLE);
            	
            	
			}
        });
        
        radioButton2.setOnClickListener(new RadioButton.OnClickListener(){ 
           // public void onRadioButtonClicked(View v) {
                // TODO Auto-generated method stub
            /*	
            	switch(v.getId()){
	            	case R.id.radioButton1:
	            		if (radioButton1.isChecked())
	                    	//major = "COMP";
	            		break;
	            	
	        		case R.id.radioButton2:
		        		if (radioButton2.isChecked())
		        			major = "CPEG";
		        		break;
        		}
            	*/
            	
            	
            	/*String A = data.get(edittext1.getText().toString(), 1);
            	textView2.setText(A);  
            	String B = data.get(edittext1.getText().toString(), 2);
            	textView3.setText(B);  
            	String C = data.get(edittext1.getText().toString(), 3);
            	textView4.setText(C);  
            	
            	
            	if	(C.equals(" "))
            			Toast.makeText(Study_Path.this, "Wrong Major", Toast.LENGTH_LONG).show();
            */
        		//}

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				major = "CPEG";

            	listView1.setAdapter(get(major, year));

            	view1.setVisibility(View.INVISIBLE);
            	view2.setVisibility(View.INVISIBLE);
            	view3.setVisibility(View.INVISIBLE);
            	
            	if (year.equals("1"))
                	view1.setVisibility(View.VISIBLE);
            	else if (year.equals("2"))
                	view2.setVisibility(View.VISIBLE);
            	else
                	view3.setVisibility(View.VISIBLE);
            		
			}
        });
        
        button1.setOnClickListener(new Button.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	year = "1";
            	listView1.setAdapter(get(major, year));
            	
            	view1.setVisibility(View.VISIBLE);
            	view2.setVisibility(View.INVISIBLE);
            	view3.setVisibility(View.INVISIBLE);
            	
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
            	year = "2";
            	listView1.setAdapter(get(major, year));
            	
            	
            	view1.setVisibility(View.INVISIBLE);
            	view2.setVisibility(View.VISIBLE);
            	view3.setVisibility(View.INVISIBLE);
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
            	year = "3";
            	listView1.setAdapter(get(major, year));
            	
            	view1.setVisibility(View.INVISIBLE);
            	view2.setVisibility(View.INVISIBLE);
            	view3.setVisibility(View.VISIBLE);
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
            	Intent intent = new Intent();
                intent.setClass(Study_Path.this, Advanced_Activity.class);
                startActivity(intent);      
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
    private ListView listView1;
    private View view1;
    private View view2;
    private View view3;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private String major;
    private String year;


}