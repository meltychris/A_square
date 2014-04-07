package com.example.asquare;
//don't change the MainActivity and the layout of main !!

import com.example.exam_count_down.Exam_countdown;
import com.example.study_path.Study_Path;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
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
                intent.setClass(MainActivity.this, GPA_Calculator.class);
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
                intent.setClass(MainActivity.this, MainActivity.class);
                startActivity(intent);
               
        }});
        
        button5 = (ImageButton)findViewById(R.id.imageButton5);
        button5.setOnClickListener(new ImageButton.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	Intent intent = new Intent();
                intent.setClass(MainActivity.this, MainActivity.class);
                startActivity(intent);
               
        }});
        
        button6 = (ImageButton)findViewById(R.id.imageButton6);
        button6.setOnClickListener(new ImageButton.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	Intent intent = new Intent();
                intent.setClass(MainActivity.this, MainActivity.class);
                startActivity(intent);
               
        }});
		
	}
	
	private ImageButton button1;
	private ImageButton button2;
	private ImageButton button3;
	private ImageButton button4;
	private ImageButton button5;
	private ImageButton button6;

}
