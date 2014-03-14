package com.existingsqlitedatabase;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
    public void SaveEmployee(View v)
    {
    	EditText txtName = (EditText)findViewById(R.id.txtName);
    	EditText txtEmail = (EditText)findViewById(R.id.txtEmail);
    	
    	String name = txtName.getText().toString();
    	String email = txtEmail.getText().toString();
    	
    	
    	TestAdapter mDbHelper = new TestAdapter(this);         
    	mDbHelper.createDatabase();       
    	mDbHelper.open(); 
    	
    	if(mDbHelper.SaveEmployee(name, email))
    	{
    		Utility.ShowMessageBox(this,"Data saved.");
    	}
    	else
    	{
    		Utility.ShowMessageBox(this,"OOPS try again!");
    	}
    }
    
    public void LoadEmployee(View v)
    {
    	TestAdapter mDbHelper = new TestAdapter(this);         
    	mDbHelper.createDatabase();       
    	mDbHelper.open(); 
    	 
    	Cursor testdata = mDbHelper.getTestData(); 
    	 
    	String name = Utility.GetColumnValue(testdata, "Name");
    	String email = Utility.GetColumnValue(testdata, "Email");
    	
    	Utility.ShowMessageBox(this, "Name: "+ name + " and Email: "+ email);
    	mDbHelper.close();
    }
}
