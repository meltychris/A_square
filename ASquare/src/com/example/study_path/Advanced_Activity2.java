package com.example.study_path;
//recalculate the formula
import java.util.ArrayList;
import java.util.List;

import com.example.asquare.R;
import com.example.asquare.R.id;
import com.example.asquare.R.layout;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Advanced_Activity2 extends Activity {

	public boolean onCreateOptionsMenu(Menu menu)
	{
	   getMenuInflater().inflate(R.menu.menu, menu);
	   return true;
	}
	
	/*public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.menu_delete:
		    	ResetTable("Studied");
		    	ResetTable("NotStudied");
		    	
		    	DataBaseTestAdapter mDbHelper = new DataBaseTestAdapter(this);         
		    	mDbHelper.createDatabase();       
		    	mDbHelper.open(); 
		    	mDbHelper.alter("0", "advanced");  
		    	mDbHelper.close();
		    	
	         	Intent intent = new Intent();
	            intent.setClass(this, Advanced_Activity.class);
	            startActivity(intent);  

		    	 return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}*/
	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	  	// TODO Auto-generated method stub  
		super.onCreate(savedInstanceState);
        setContentView(R.layout.adv_path_main2);  
        
    	ResetTable("Studied");
    	ResetTable("NotStudied");
        
	    button1 = (Button)findViewById(R.id.button1);
	    button2 = (Button)findViewById(R.id.button2);
 	          	
       	view1 = (View) findViewById(R.id.View1);
    	view2 = (View) findViewById(R.id.View2);
    	
    	view1.setVisibility(View.VISIBLE);
    	view2.setVisibility(View.INVISIBLE);
	
	    textView1 = (TextView)findViewById(R.id.textView1);
	    textView2 = (TextView)findViewById(R.id.textView2);
	    listView1 = (ListView)findViewById(R.id.listView1);

	    Bundle params = getIntent().getExtras();
	    if (params!= null) {
	    	Major1 = params.getBoolean ("Major1");
	    	Major2 = params.getBoolean ("Major2");
	    	Pure = params.getBoolean ("Pure");
	    	pure = (Pure?"T":"F");
	    	
	    	Year1 = params.getBoolean ("Year1");
	    	Year2 = params.getBoolean ("Year2");
	    	Year3 = params.getBoolean ("Year3");
	    	if (Year1) Year = 1;
	    	else if  (Year2) Year = 2;
	    	else Year = 3;
	    	
	    	Sem1 = params.getBoolean ("Sem1");
	    	Sem2 = params.getBoolean ("Sem2");
	    	Credit = params.getString ("Credit");
	    	SA = params.getBoolean ("SA");
	    	S_T = params.getBoolean ("S_T");
	    	A_H = params.getBoolean ("A_H");
	    	Free = params.getBoolean ("Free");
	    	SBM = params.getBoolean ("SBM");
	    	ENGG = params.getBoolean ("ENGG");
	    	FreeE = params.getBoolean ("FreeE");
	    	compx1 = params.getBoolean ("compx1");
	    	compx2 = params.getBoolean ("compx2");
	    	compx3 = params.getBoolean ("compx3");
	    	compx4 = params.getBoolean ("compx4");
	    	compx5 = params.getBoolean ("compx5");
	    	CEMx1 = params.getBoolean ("CEMx1");
	    	CEMx2 = params.getBoolean ("CEMx2");
	    	Credneed = 90 - Integer.parseInt(Credit);
	    	
	    	String[] Course = params.getStringArray("Course"); 
	    	String[] Checked = params.getStringArray ("Checked");
            
            /*Toast.makeText(view.getContext(),
                    [1].toString(),
                    Toast.LENGTH_SHORT).show();*/
	    	
	    	studied = new ArrayList<String>();
	    	notstudied = new ArrayList<String>();

	    	for (int i = 0; i< Course.length; i++){					//catagorize
	    		if (Checked[i].equals("true"))
	    			studied.add(Course[i]);
	    		else
	    			notstudied.add(Course[i]);
	    		
	    	}

	    	
	    	

	    	/*
	    	 * Bonus: helper : converter for course code(a better name show to user)
	    	 * Sem1 true : give result of fall sem!!
	    	 * 
	    	 * Instruction:
	    	 * 		for (year 1 fall to next sem):
	    	 * 			for (course 1 to course n of SEM):
	    	 * 				if (a course should have studied but not studied):
	    	 * 					if (prerequisite ok(pre_check) && next sem open(check_next)):
	    	 * 						put to List<String> required
	    	 * 					else:
	    	 * 						dun put it
	    	 * 
	    	 * 		for (next next sem to year 3 spring):
	    	 * 			for (course 1 to course n of SEM):
	    	 * 				if (the course not yet studied):
	    	 * 					if (prerequisite ok && next sem open):
	    	 * 						put to List<String> suggested
	    	 * 					else:
	    	 * 						dun put it
	    	 */


	    	SaveRecord(this.findViewById(android.R.id.content));		//insert data to database
	    	
	    	List<String> required = find_reqcourse(Year, (Sem1?"Fall":"Spring"));		//find the required course
	    	ArrayAdapter<String> adapter;
			adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
			for (String i : required)				//put course code to adapter for listview
				adapter.add(i + "(" + getCredit(i) + ")" + "\n" + getName(i));
    		listView1.setAdapter(adapter);
	    }
	    

	    		if (Sem1)
	    			{
	    				if((Credneed/(2*(3-Year)+1))>=21) textView1.setText("You need to DEFER");
	    				else textView1.setText("No need defer Graduation");
	    				SemtoGrad= 2*(3-Year)+1;
	    			}
	    		else 
	    			{
	    				if ( (Year==3 && Credneed!=0) || (Year!=3 && Credneed/(2*(3-Year))>=21))
	    						textView1.setText("NEED to DEFER Graduation");
	    					else
		    					textView1.setText("No need defer Graduation");

		    			SemtoGrad= 2*(3-Year);

	    			}
	    		
	    	
	    		if (SemtoGrad == 0)
					textView2.setText("Study all from the following list:");		//last sem
				else
					textView2.setText("Study at least " + Credneed/SemtoGrad + " credit from the following list:");

	    		
	    		
	    		
	    		button1.setOnClickListener(new Button.OnClickListener(){ 
	    	        @Override
	    	        public void onClick(View v) {
	    	            // TODO Auto-generated method stub
	    	        	
	    	        	view1.setVisibility(View.VISIBLE);
	    	        	view2.setVisibility(View.INVISIBLE);
	    	     
	    		    	List<String> required = find_reqcourse(Year, (Sem1?"Fall":"Spring"));		//find the required course

	    		    	ArrayAdapter<String> adapter;
	    				adapter = new ArrayAdapter<String>(Advanced_Activity2.this, android.R.layout.simple_list_item_1);

	    				for (String i : required)				//put course code to adapter for listview
	    					adapter.add(i + "(" + getCredit(i) + ")" + "\n" + getName(i));
	    	    		
	    	    		listView1.setAdapter(adapter);
	    	    		}
	    	    });
	    	    
	    	    button2.setOnClickListener(new Button.OnClickListener(){ 
	    	        @Override
	    	        public void onClick(View v) {
	    	            // TODO Auto-generated method stub
	    	   	
	    	        	view1.setVisibility(View.INVISIBLE);
	    	        	view2.setVisibility(View.VISIBLE);
	    	        
	    		    	List<String> addition = find_addcourse(Year, (Sem1?"Fall":"Spring"));	//find the addition course

	    		    	ArrayAdapter<String> adapter;
	    				adapter = new ArrayAdapter<String>(Advanced_Activity2.this, android.R.layout.simple_list_item_1);

	    				for (String i : addition)				//put course code to adapter for listview
	    					adapter.add(i + "(" + getCredit(i) + ")" + "\n" + getName(i));
	    	    		
	    	    		listView1.setAdapter(adapter);
	    	    		}
	    	    });
	    	    
	    	    listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	    			@Override
	    			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) { 
	    				// TODO Auto-generated method stub
	    				ListView listView = (ListView) arg0;
	    				Toast.makeText(
	    				Advanced_Activity2.this, listView.getItemAtPosition(arg2).toString(), Toast.LENGTH_SHORT).show();

	    			}
	    		});
	}

	  
	    
	    public void SaveRecord(View v)
	    {
	    	DataBaseTestAdapter1 mDbHelper = new DataBaseTestAdapter1(this);         
	    	mDbHelper.createDatabase();       
	    	mDbHelper.open(); 
	    	
	    	for (String temp : studied)
		    	if(mDbHelper.SaveData(temp, "Studied"))
		    	{
		    		//Utility.ShowMessageBox(this,"Data saved. :" + temp);
		    	}
		    	else
		    	{
		    		DataBaseUtility1.ShowMessageBox(this,"OOPS try again!");
		    	}
	    	for (String temp : notstudied)
		    	if(mDbHelper.SaveData(temp, "NotStudied"))
		    	{
		    		//Utility.ShowMessageBox(this,"Data saved. :" + temp);
		    	}
		    	else
		    	{
		    		DataBaseUtility1.ShowMessageBox(this,"OOPS try again!");
		    	}
	    }
	
	    public void ResetTable(String name) 
	 	{
	 		try
	 		{
				DataBaseTestAdapter1 mDbHelper = new DataBaseTestAdapter1(this);         
		    	mDbHelper.createDatabase();       
		    	mDbHelper.open(); 
		    	
	 			mDbHelper.del(name);
	    		//DataBaseUtility.ShowMessageBox(this,"Deleted " + name);

	 			
	 			mDbHelper.close();
	 		}
	 		catch(Exception ex)
	 		{
	 			Log.d("fail", ex.toString());
	 		}
	 	}
	    
    	public List<String> find_reqcourse(int year, String Sem) {
	    	    // TODO Auto-generated method stub
	    		DataBaseTestAdapter1 mDbHelper = new DataBaseTestAdapter1(this);         
	        	mDbHelper.createDatabase();       
	        	mDbHelper.open(); 
	        	 
	        	//Utility.ShowMessageBox(this, "hi");
	        	List<String> reqcourse = new ArrayList<String>();

	    		//Check for required course
	    		if (Sem.equals("Fall")){
	    			String sql;
	    			Cursor testdata;
	    			String code;
	    			for (int yearloop = 1; yearloop < year; yearloop++){
		    			sql ="SELECT Course.Code from Course, COMP WHERE Course.Code = COMP.Code AND (Pure='All' OR Pure='" + pure + "') AND Year='" + Integer.toString(yearloop) + "' AND Sem='Fall' AND FALL='TRUE' AND COMP.Code NOT IN (SELECT Code FROM Studied)"; 
		    			testdata = mDbHelper.getTestData(sql); 
		    			code = DataBaseUtility1.GetColumnValue(testdata, "Code");
			    		if (!code.equals(""))								//meaning no result
			    			reqcourse.add(code);
			    		while (testdata.moveToNext()){ 
			    			code = DataBaseUtility1.GetColumnValue(testdata, "Code");
			    			reqcourse.add(code);
			    			}
		    			
		    			
		    			sql ="SELECT Course.Code from Course, COMP WHERE Course.Code = COMP.Code AND (Pure='All' OR Pure='" + pure + "') AND  Year='" + Integer.toString(yearloop) + "' AND Sem='Spring' AND FALL='TRUE' AND COMP.Code NOT IN (SELECT Code FROM Studied)"; 
		    			testdata = mDbHelper.getTestData(sql); 
		    			code = DataBaseUtility1.GetColumnValue(testdata, "Code");
			    		if (!code.equals(""))								//meaning no result
			    			reqcourse.add(code);
			    		while (testdata.moveToNext()){ 
			    			code = DataBaseUtility1.GetColumnValue(testdata, "Code");
			    			reqcourse.add(code);
			   			}
		    		}
		    		
	    			sql ="SELECT Course.Code from Course, COMP WHERE Course.Code = COMP.Code AND (Pure='All' OR Pure='" + pure + "') AND  Year='" + year + "' AND Sem='Fall'  AND FALL='TRUE' AND Course.Code NOT IN (SELECT Code FROM Studied)"; 
	    			testdata = mDbHelper.getTestData(sql); 
	    			code = DataBaseUtility1.GetColumnValue(testdata, "Code");
		    		if (!code.equals(""))								//meaning no result
		    			reqcourse.add(code);
	    			while (testdata.moveToNext()){ 
	    				code = DataBaseUtility1.GetColumnValue(testdata, "Code");
	    				reqcourse.add(code);
		    		
	    			}
	    			
		        	//Utility.ShowMessageBox(this, result);
		        	
	    		}
	    		else{
	      			String sql;
	    			Cursor testdata;
	    			String code;
	    			for (int yearloop = 1; yearloop <= year ; yearloop++){
		    			sql ="SELECT Course.Code from Course, COMP WHERE Course.Code = COMP.Code AND (Pure='All' OR Pure='" + pure + "') AND  Year='" + Integer.toString(yearloop) + "' AND Sem='Fall' AND SPRING='TRUE' AND COMP.Code NOT IN (SELECT Code FROM Studied)"; 
		    			testdata = mDbHelper.getTestData(sql); 
	    				code = DataBaseUtility1.GetColumnValue(testdata, "Code");
			    		if (!code.equals(""))								//meaning no result
			    			reqcourse.add(code);
			    		while (testdata.moveToNext()){ 
			    			code = DataBaseUtility1.GetColumnValue(testdata, "Code");
			    			reqcourse.add(code);
			    		}
		    			
		    			sql ="SELECT Course.Code from Course, COMP WHERE Course.Code = COMP.Code AND (Pure='All' OR Pure='" + pure + "') AND  Year='" + Integer.toString(yearloop) + "' AND Sem='Spring' AND SPRING='TRUE' AND COMP.Code NOT IN (SELECT Code FROM Studied)"; 
		    			testdata = mDbHelper.getTestData(sql); 
		    			code = DataBaseUtility1.GetColumnValue(testdata, "Code");
		    			if (!code.equals(""))
		    				reqcourse.add(code);
			    		while (testdata.moveToNext()){ 
			    			code = DataBaseUtility1.GetColumnValue(testdata, "Code");
			    			reqcourse.add(code);
			    		}
		    		}
	    			
		        	//Utility.ShowMessageBox(this, result);
	    		}

	    		//check prereq
	    		List<String> result = new ArrayList<String>();
	    		for (String i : reqcourse){
	    			String sql ="SELECT Prerequisite.Code from Prerequisite, NotStudied WHERE Prerequisite.Precourse = NotStudied.Code AND Prerequisite.Code='" + i +"'"; 
	    			Cursor testdata = mDbHelper.getTestData(sql); 
	    			String code = DataBaseUtility1.GetColumnValue(testdata, "Code");
	    			if (code.equals(""))		//insert to result if at least one precourse remains
	    				 result.add(i);
	    		}
	    		
	        	mDbHelper.close();
	        	

				/*for (String i : reqcourse)		
				{	
	            Toast.makeText(this.findViewById(android.R.id.content).getContext(),i,
	            Toast.LENGTH_SHORT).show();
				}*/
				
	    		return result;
	    	}
    	
    	public List<String> find_addcourse(int year, String Sem) {
    	    // TODO Auto-generated method stub
    		DataBaseTestAdapter1 mDbHelper = new DataBaseTestAdapter1(this);         
        	mDbHelper.createDatabase();       
        	mDbHelper.open(); 
        	 
        	List<String> addcourse = new ArrayList<String>();

    		//Check for required course
    		if (Sem.equals("Fall")){
    			String sql;
    			Cursor testdata;
    			String code;
    			
	    		
    			sql ="SELECT Course.Code from Course, COMP WHERE Course.Code = COMP.Code AND (Pure='All' OR Pure='" + pure + "') AND  Year='" + year + "' AND Sem='Spring'  AND FALL='TRUE' AND Course.Code NOT IN (SELECT Code FROM Studied)"; 
    			testdata = mDbHelper.getTestData(sql); 
    			code = DataBaseUtility1.GetColumnValue(testdata, "Code");
	    		if (!code.equals(""))								//meaning no result
	    			addcourse.add(code);
    			while (testdata.moveToNext()){ 
    				code = DataBaseUtility1.GetColumnValue(testdata, "Code");
    				addcourse.add(code);
	    		
    			}
    			
    			for (int yearloop = year+1; yearloop <= 3; yearloop++){
	    			sql ="SELECT Course.Code from Course, COMP WHERE Course.Code = COMP.Code AND (Pure='All' OR Pure='" + pure + "') AND Year='" + Integer.toString(yearloop) + "' AND Sem='Fall' AND FALL='TRUE' AND COMP.Code NOT IN (SELECT Code FROM Studied)"; 
	    			testdata = mDbHelper.getTestData(sql); 
	    			code = DataBaseUtility1.GetColumnValue(testdata, "Code");
		    		if (!code.equals(""))								//meaning no result
		    			addcourse.add(code);
		    		while (testdata.moveToNext()){ 
		    			code = DataBaseUtility1.GetColumnValue(testdata, "Code");
		    			addcourse.add(code);
		    			}
	    			
	    			
	    			sql ="SELECT Course.Code from Course, COMP WHERE Course.Code = COMP.Code AND (Pure='All' OR Pure='" + pure + "') AND  Year='" + Integer.toString(yearloop) + "' AND Sem='Spring' AND FALL='TRUE' AND COMP.Code NOT IN (SELECT Code FROM Studied)"; 
	    			testdata = mDbHelper.getTestData(sql); 
	    			code = DataBaseUtility1.GetColumnValue(testdata, "Code");
		    		if (!code.equals(""))								//meaning no result
		    			addcourse.add(code);
		    		while (testdata.moveToNext()){ 
		    			code = DataBaseUtility1.GetColumnValue(testdata, "Code");
		    			addcourse.add(code);
		   			}
	    		}

    			
	        	//Utility.ShowMessageBox(this, result);
	        	
    		}
    		else{
      			String sql;
    			Cursor testdata;
    			String code;
    			for (int yearloop = year+1; yearloop <= 3 ; yearloop++){
	    			sql ="SELECT Course.Code from Course, COMP WHERE Course.Code = COMP.Code AND (Pure='All' OR Pure='" + pure + "') AND  Year='" + Integer.toString(yearloop) + "' AND Sem='Fall' AND SPRING='TRUE' AND COMP.Code NOT IN (SELECT Code FROM Studied)"; 
	    			testdata = mDbHelper.getTestData(sql); 
    				code = DataBaseUtility1.GetColumnValue(testdata, "Code");
		    		if (!code.equals(""))								//meaning no result
		    			addcourse.add(code);
		    		while (testdata.moveToNext()){ 
		    			code = DataBaseUtility1.GetColumnValue(testdata, "Code");
		    			addcourse.add(code);
		    		}
	    			
	    			sql ="SELECT Course.Code from Course, COMP WHERE Course.Code = COMP.Code AND (Pure='All' OR Pure='" + pure + "') AND  Year='" + Integer.toString(yearloop) + "' AND Sem='Spring' AND SPRING='TRUE' AND COMP.Code NOT IN (SELECT Code FROM Studied)"; 
	    			testdata = mDbHelper.getTestData(sql); 
	    			code = DataBaseUtility1.GetColumnValue(testdata, "Code");
	    			if (!code.equals(""))
	    				addcourse.add(code);
		    		while (testdata.moveToNext()){ 
		    			code = DataBaseUtility1.GetColumnValue(testdata, "Code");
		    			addcourse.add(code);
		    		}
	    		}
    			
	        	//Utility.ShowMessageBox(this, result);
    		}

    		//check prereq
    		List<String> result = new ArrayList<String>();
    		for (String i : addcourse){
    			String sql ="SELECT Prerequisite.Code from Prerequisite, NotStudied WHERE Prerequisite.Precourse = NotStudied.Code AND Prerequisite.Code='" + i +"'"; 
    			Cursor testdata = mDbHelper.getTestData(sql); 
    			String code = DataBaseUtility1.GetColumnValue(testdata, "Code");
    			if (code.equals(""))		//insert to result if at least one precourse remains
    				 result.add(i);
    		}
    		
        	mDbHelper.close();
        			
    		return result;
    	}
    	
    	
    	//return Credit of course
        public String getCredit(String Code) {
		    // TODO Auto-generated method stub
			DataBaseTestAdapter1 mDbHelper = new DataBaseTestAdapter1(this);         
	    	mDbHelper.createDatabase();       
	    	mDbHelper.open(); 
	    	 
	    	String sql ="SELECT Credit from Course WHERE Code='" + Code + "'"; 
			Cursor testdata = mDbHelper.getTestData(sql); 
	    	String Credit = DataBaseUtility1.GetColumnValue(testdata, "Credit");
	    
	    	mDbHelper.close();
					
			return Credit;
		}
      
    	//return Name of course
        public String getName(String Code) {
		    // TODO Auto-generated method stub
			DataBaseTestAdapter1 mDbHelper = new DataBaseTestAdapter1(this);         
	    	mDbHelper.createDatabase();       
	    	mDbHelper.open(); 
	    	 
	    	String sql ="SELECT Name from Course WHERE Code='" + Code + "'"; 
			Cursor testdata = mDbHelper.getTestData(sql); 
	    	String Name = DataBaseUtility1.GetColumnValue(testdata, "Name");
	    
	    	mDbHelper.close();
					
			return Name;
		}
        
        
	TextView textView1;
	TextView textView2;
	ListView listView1;
	private Button button1;
	private Button button2;
	private View view1;
	private View view2;

	
	Boolean Major1;
	Boolean Major2;
	Boolean Pure;
	Boolean Year1;
	Boolean Year2;
	Boolean Year3;
	Boolean Sem1;
	Boolean Sem2;
	String Credit;
	Boolean SA;
	Boolean S_T;
	Boolean A_H;
	Boolean Free;
	Boolean SBM;
	Boolean ENGG;
	Boolean FreeE;
	Boolean compx1;
	Boolean compx2;
	Boolean compx3;
	Boolean compx4;
	Boolean compx5;
	Boolean CEMx1;
	Boolean CEMx2;
	List<String> studied;
	List<String> notstudied;
	
	int Credneed; 
	int Year;
	int SemtoGrad;
	String pure;
	
	
}
