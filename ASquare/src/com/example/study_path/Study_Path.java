package com.example.study_path;

import com.example.asquare.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
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
	    button111 = (Button)findViewById(R.id.button111);
	    
	    checkbox1 = (CheckBox)findViewById(R.id.checkBox1);
	    
	    listView1 = (ListView) findViewById(R.id.listView1);
       	
       	view1 = (View) findViewById(R.id.View1);
    	view2 = (View) findViewById(R.id.View2);
    	view3 = (View) findViewById(R.id.View3);
    	
    	view1.setVisibility(View.INVISIBLE);
    	view2.setVisibility(View.INVISIBLE);
    	view3.setVisibility(View.INVISIBLE);
    	
    	radioButton1 = (RadioButton) findViewById(R.id.radioButton10);
    	radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
    	
    	setMajor("COMP");		//initial
    	setYear("1");			//initial
    	setPure("T");			//initialize to NOT studied Pure


        radioButton1.setOnClickListener(new Button.OnClickListener(){ 
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
				setMajor("COMP");
            	
            	listView1.setAdapter(get(getMajor(), getYear(), getPure()));

            	view1.setVisibility(View.INVISIBLE);
            	view2.setVisibility(View.INVISIBLE);
            	view3.setVisibility(View.INVISIBLE);
            	
            	if (getYear().equals("1"))
                	view1.setVisibility(View.VISIBLE);
            	else if (getYear().equals("2"))
                	view2.setVisibility(View.VISIBLE);
            	else
                	view3.setVisibility(View.VISIBLE);
            	
            	
			}
        });
        
        radioButton2.setOnClickListener(new Button.OnClickListener(){ 
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
				setMajor("CPEG");

            	listView1.setAdapter(get(getMajor(), getYear(), getPure()));

            	view1.setVisibility(View.INVISIBLE);
            	view2.setVisibility(View.INVISIBLE);
            	view3.setVisibility(View.INVISIBLE);
            	
            	if (getYear().equals("1"))
                	view1.setVisibility(View.VISIBLE);
            	else if (getYear().equals("2"))
                	view2.setVisibility(View.VISIBLE);
            	else
                	view3.setVisibility(View.VISIBLE);
            		
			}
        });
        
        
        checkbox1.setOnClickListener(new Button.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	setPure((getPure().equals("T")?"F":"T")); 
            	listView1.setAdapter(get(getMajor(), getYear(), getPure()));
            	
        	}
        });
        
        button1.setOnClickListener(new Button.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	setYear("1");
            	listView1.setAdapter(get(getMajor(), getYear(), getPure()));
            	
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
            	setYear("2");
            	listView1.setAdapter(get(getMajor(), getYear(), getPure()));
            	
            	
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
            	setYear("3");
            	listView1.setAdapter(get(getMajor(), getYear(), getPure()));
            	
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
        
        button111.setOnClickListener(new Button.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	/*if (get().equals("1")){			//have history
                   	Intent intent = new Intent();
                    intent.setClass(Study_Path.this, Advanced_Activity2.class);
                    startActivity(intent);   
            	}
            	else{
    		    	DataBaseTestAdapter mDbHelper = new DataBaseTestAdapter(Study_Path.this);         
    		    	mDbHelper.createDatabase();       
    		    	mDbHelper.open(); 
    		    	mDbHelper.alter("1", "advanced");  
    		    	mDbHelper.close();*/
            	
             	SharedPreferences xadvanced = getSharedPreferences("advanced", 0);
             	if (xadvanced.getBoolean("advanced", false)){
                   	Intent intent = new Intent();
                    intent.setClass(Study_Path.this, Advanced_Activity2.class);
                    startActivity(intent);   
                    finish();

             	}
             	else
             	{	
            		Intent intent = new Intent();
                    intent.setClass(Study_Path.this, Advanced_Activity.class);
                    startActivity(intent);
                    finish();

                    
             	}
            	//}
            	
            	

		    	
            	
        		}
        });
        
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) { 
				// TODO Auto-generated method stub
				ListView listView = (ListView) arg0;
				Toast.makeText(Study_Path.this, listView.getItemAtPosition(arg2).toString(), Toast.LENGTH_SHORT).show();
				setToastshown(true);
			}
		});
	}
	
	
	public ArrayAdapter<String> get(String major, String year, String Pure) {
	    // TODO Auto-generated method stub
		DataBaseTestAdapter1 mDbHelper = new DataBaseTestAdapter1(this);         
    	mDbHelper.createDatabase();       
    	mDbHelper.open(); 
    	 
    	ArrayAdapter<String> adapter;
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
    	//Utility.ShowMessageBox(this, "hi");
		
        String sql ="SELECT Course.Code, Name, Sem from Course, " + major + " WHERE Course.Code = " + major +".Code AND Year=" + year +" AND Pure != '" + Pure + "' ORDER BY Sem"; 
    	Cursor testdata = mDbHelper.getTestData(sql); 
    	String code = DataBaseUtility1.GetColumnValue(testdata, "Code");
    	String name = DataBaseUtility1.GetColumnValue(testdata, "Name");
    	String sem = DataBaseUtility1.GetColumnValue(testdata, "Sem");
    	adapter.add(code + " (" + sem + ")" + "\n"+ name);
    	while (testdata.moveToNext()){
    		 
        	code = DataBaseUtility1.GetColumnValue(testdata, "Code");
        	name = DataBaseUtility1.GetColumnValue(testdata, "Name");
        	sem = DataBaseUtility1.GetColumnValue(testdata, "Sem");
        	adapter.add(code + " (" + sem + ")" + "\n"+ name);
    	}
    	
    	//Utility.ShowMessageBox(this, result);
    	mDbHelper.close();
				
		return adapter;
	}
	
    public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}


	/**
	 * @param major the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}

	/**
	 * @return the pure
	 */
	public String getPure() {
		return pure;
	}


	/**
	 * @param pure the pure to set
	 */
	public void setPure(String pure) {
		this.pure = pure;
	}

	/**
	 * @return the toastshown
	 */
	public Boolean getToastshown() {
		return toastshown;
	}


	/**
	 * @param toastshown the toastshown to set
	 */
	public void setToastshown(Boolean toastshown) {
		this.toastshown = toastshown;
	}

	private Button button1;
    private Button button2;
    private Button button3;
    private Button button111;
    private ListView listView1;
    private View view1;
    private View view2;
    private View view3;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private String major;
    private String year;
    private String pure;
    private CheckBox checkbox1;
    private Boolean toastshown = false;
}