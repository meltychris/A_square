package com.example.login;

import com.example.asquare.MainActivity;
import com.example.asquare.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
                    .setPositiveButton( "OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                       }
                    })
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
	}
	
	public String getInfo(){
		DataBaseTestAdapter0 mDbHelper = new DataBaseTestAdapter0(LoginActivity.this);         
    	mDbHelper.createDatabase();       
    	mDbHelper.open(); 
    	
		String sql ="SELECT Type FROM user WHERE Name='" + user + "' AND Password='" + password + "'"; 
		Cursor testdata = mDbHelper.getTestData(sql); 
		String Type = DataBaseUtility0.GetColumnValue(testdata, "Type");

		mDbHelper.close();
    	return Type;		
	}
	
	String user;
	String password;
	EditText edit_password;
	EditText edit_username;
	Button Login;
}
