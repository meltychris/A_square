package com.example.login;

import com.example.asquare.MainActivity;
import com.example.asquare.R;
import com.example.chatroom.DataBaseTestAdapter3;
import com.example.manual.ManualMainActivity;
import com.example.study_path.Advanced_Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LoginActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		View backgroundimage = findViewById(R.id.background);
		Drawable background = backgroundimage.getBackground();
		background.setAlpha(50);
		
		edit_password = (EditText) findViewById(R.id.edit_password);
		edit_username = (EditText) findViewById(R.id.edit_username);
		Login = (Button) findViewById(R.id.Login);
		Register = (Button) findViewById(R.id.Register);

		
		edit_password.setText("STSK");
		edit_username.setText("STSK");

		
		Login.setOnClickListener(new Button.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
        		user = edit_username.getText().toString();
        		password = edit_password.getText().toString();
        		
            	if (getInfo().equals(""))
            	{
            		new AlertDialog.Builder( LoginActivity.this )
                    .setTitle( "Warning" )
                    .setMessage( "Your Login Informaiton is Wrong!" )
                    //.setPositiveButton( "OK",                     )
                    .show();
            	}
            	else
            	{
                 	SharedPreferences usershared = getSharedPreferences("user", 0);
                 	usershared.edit().putString("user", user).commit();
                 	
	            	Intent intent = new Intent();
		        	intent.putExtra ("type", getInfo());
	                intent.setClass(LoginActivity.this, MainActivity.class);
	                startActivity(intent);
	                finish();
            	}
               
        }});
		
		Register.setOnClickListener(new Button.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
        		user = edit_username.getText().toString();
        		password = edit_password.getText().toString();
        		
            	if (checkUnique(user))
            	{
            		add_info();
            		
                 	SharedPreferences usershared = getSharedPreferences("user", 0);
                 	usershared.edit().putString("user", user).commit();
                 	
	            	Intent intent = new Intent();
		        	intent.putExtra ("type", getInfo());
	                intent.setClass(LoginActivity.this, MainActivity.class);
	                startActivity(intent);
	                finish();
            	}
            	else
            	{
            		new AlertDialog.Builder( LoginActivity.this )
                    .setTitle( "Warning" )
                    .setMessage( "This ITSC has already been registered!" )
                    //.setPositiveButton( "OK",                     )
                    .show();
            		
            	}
               
        }});
	}
	
	public void add_info() {
	    // TODO Auto-generated method stub
		DataBaseTestAdapter0 mDbHelper = new DataBaseTestAdapter0(this);         
    	mDbHelper.createDatabase();       
    	mDbHelper.open(); 
    	
    	mDbHelper.SaveData(user, password);
    	mDbHelper.close();
	}
	
	public String getInfo(){
		DataBaseTestAdapter0 mDbHelper = new DataBaseTestAdapter0(LoginActivity.this);         
    	mDbHelper.createDatabase();       
    	mDbHelper.open(); 
    	
		String sql ="SELECT Type FROM user WHERE Name='" + user + "' AND Password='" + password + "'"; 
		Cursor testdata = mDbHelper.getTestData(sql); 
		String Type = DataBaseUtility0.GetColumnValue(testdata, "Type");

		testdata.close();
		mDbHelper.close();
    	return Type;		
	}
	
	public Boolean checkUnique(String input){
		DataBaseTestAdapter0 mDbHelper = new DataBaseTestAdapter0(LoginActivity.this);         
    	mDbHelper.createDatabase();       
    	mDbHelper.open(); 
    	
		String sql ="SELECT Name FROM user WHERE Name='" + user + "'"; 
		Cursor testdata = mDbHelper.getTestData(sql); 
		String Name = DataBaseUtility0.GetColumnValue(testdata, "Name");

		testdata.close();
		mDbHelper.close();
    	return !Name.equals(input);		
	}
	
	public boolean onCreateOptionsMenu(Menu menu)
	{
	   getMenuInflater().inflate(R.menu.manual, menu);
	   return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.manual_help:
		    	

            	Intent intent = new Intent();
                intent.setClass(LoginActivity.this, ManualMainActivity.class);
                startActivity(intent);

		    	 return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	String user;
	String password;
	EditText edit_password;
	EditText edit_username;
	Button Login;
	Button Register;
}
