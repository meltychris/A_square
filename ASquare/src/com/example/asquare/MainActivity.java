package com.example.asquare;
//don't change the MainActivity and the layout of main !!

import com.example.chatroom.MainChat;
import com.example.chatroom.MentorMain;
import com.example.exam_count_down.Exam_countdown;
import com.example.schedule.CalendarAdapter;
import com.example.schedule.CalendarView;
import com.example.study_path.Study_Path;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
        button1 = (ImageButton)findViewById(R.id.imageButton1);
        button1.setOnClickListener(new ImageButton.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	Intent intent = new Intent();
                intent.setClass(MainActivity.this, com.example.gpa_calculator.MainActivity.class);
                startActivity(intent);
               
        }});
        
        button2 = (ImageButton)findViewById(R.id.imageButton2);
        button2.setOnClickListener(new ImageButton.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	Intent intent = new Intent();
                intent.setClass(MainActivity.this, Study_Path.class);
                startActivity(intent);      
            }
        });
        
        button3 = (ImageButton)findViewById(R.id.imageButton3);
        button3.setOnClickListener(new ImageButton.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	Intent intent = new Intent();
                intent.setClass(MainActivity.this, Exam_countdown.class);
                startActivity(intent);
               
        }});
        
        button4 = (ImageButton)findViewById(R.id.imageButton4);
        button4.setOnClickListener(new ImageButton.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	Intent intent = new Intent();
                intent.setClass(MainActivity.this, CalendarView.class);
                startActivity(intent);
               
        }});
        
        button5 = (ImageButton)findViewById(R.id.imageButton5);
        button5.setOnClickListener(new ImageButton.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
             	String usertype;
            	Intent intent = new Intent();
            	Bundle params = getIntent().getExtras();
            	
            	if (params!= null) {
            		usertype = params.getString ("type");
             	  
	             	if (usertype.equals("student")){
		                intent.setClass(MainActivity.this, MainChat.class);
		                startActivity(intent);
	             	}
	             	else
	             	{
		                intent.setClass(MainActivity.this, MentorMain.class);
		                startActivity(intent);
	             	}
            	}
               
        }});
   
        button6 = (ImageButton)findViewById(R.id.imageButton6);
        button6.setOnClickListener(new ImageButton.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	Intent intent = new Intent();
                intent.setClass(MainActivity.this, com.example.advising.advising_MainActivity.class);
                startActivity(intent);
               
        }});
        
        initAnimations();
		
	}
	
	private void initAnimations() {
		int startOffset = 500, counter = 0;
		int duration = 750;
		// TODO Auto-generated method stub
		Animation butAni1 = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
		button1.setAnimation(butAni1);
		butAni1.setStartOffset(startOffset + (counter++)*startOffset/2);
		butAni1.setDuration(duration);
		butAni1.start();
		Animation butAni3 = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
		button3.setAnimation(butAni3);
		butAni3.setStartOffset(startOffset + (counter++)*startOffset/2);
		butAni3.setDuration(duration);
		butAni3.start();
		Animation butAni5 = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
		button5.setAnimation(butAni5);
		butAni5.setStartOffset(startOffset + (counter++)*startOffset/2);
		butAni5.setDuration(duration);
		butAni5.start();
		Animation butAni2 = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
		button2.setAnimation(butAni2);
		butAni2.setStartOffset(startOffset + (counter++)*startOffset/2);
		butAni2.setDuration(duration);
		butAni2.start();
		Animation butAni4 = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
		button4.setAnimation(butAni4);
		butAni4.setStartOffset(startOffset + (counter++)*startOffset/2);
		butAni4.setDuration(duration);
		butAni4.start();
		Animation butAni6 = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
		button6.setAnimation(butAni6);
		butAni6.setStartOffset(startOffset + (counter++)*startOffset/2);
		butAni6.setDuration(duration);
		butAni6.start();
	}

	public AlertDialog Dialoghelper(){
		AlertDialog isExit = new AlertDialog.Builder(this).create();
		isExit.setTitle("A Square");
		isExit.setMessage("Really want to leave?");
		isExit.setButton("I'll be back!", listener);
		isExit.setButton2("No", listener);
		return isExit;
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if (keyCode == KeyEvent.KEYCODE_BACK )
		{
			isExit = Dialoghelper();
			isExit.show();
		}
		
		return false;
		
	}
	DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener()
	{
		public void onClick(DialogInterface dialog, int which)
		{
			switch (which)
			{
			case AlertDialog.BUTTON_POSITIVE:
				finish();
				break;
			case AlertDialog.BUTTON_NEGATIVE:
				break;
			default:
				break;
			}
		}
	};	
	

	
	private ImageButton button1;
	private ImageButton button2;
	private ImageButton button3;
	private ImageButton button4;
	private ImageButton button5;
	private ImageButton button6;
	public AlertDialog isExit;
}
