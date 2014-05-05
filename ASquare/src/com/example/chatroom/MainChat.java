package com.example.chatroom;

import com.example.asquare.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainChat extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
		setContentView(R.layout.chat_main);

	    // TODO Auto-generated method stub
		PeterChat = (TextView)findViewById(R.id.PeterChat);
		PeterChat.setOnClickListener(new ImageButton.OnClickListener(){ 
	         @Override
	         public void onClick(View v) {
	             // TODO Auto-generated method stub
	        	 Intent intent = new Intent();
	        	 intent.putExtra ("name", "Peter");
	             intent.setClass(MainChat.this, ChatroomActivity.class);
	             startActivity(intent);
	         }
		});
		
		KenChat = (TextView)findViewById(R.id.KenChat);
		KenChat.setOnClickListener(new ImageButton.OnClickListener(){ 
	         @Override
	         public void onClick(View v) {
	             // TODO Auto-generated method stub
	        	 Intent intent = new Intent();
	        	 intent.putExtra ("name", "Ken");
	             intent.setClass(MainChat.this, ChatroomActivity.class);
	             startActivity(intent);
	         }
         });
		
		BrianChat = (TextView)findViewById(R.id.BrianChat);
		BrianChat.setOnClickListener(new ImageButton.OnClickListener(){ 
	         @Override
	         public void onClick(View v) {
	             // TODO Auto-generated method stub
	        	 Intent intent = new Intent();
	        	 intent.putExtra ("name", "Brian");
	             intent.setClass(MainChat.this, ChatroomActivity.class);
	             startActivity(intent);
	         }
         });
		
		MaryChat = (TextView)findViewById(R.id.MaryChat);
		MaryChat.setOnClickListener(new ImageButton.OnClickListener(){ 
	         @Override
	         public void onClick(View v) {
	             // TODO Auto-generated method stub
	        	 Intent intent = new Intent();
	        	 intent.putExtra ("name", "Mary");
	             intent.setClass(MainChat.this, ChatroomActivity.class);
	             startActivity(intent);
	         }
         });
		
		AlanChat = (TextView)findViewById(R.id.AlanChat);
		AlanChat.setOnClickListener(new ImageButton.OnClickListener(){ 
	         @Override
	         public void onClick(View v) {
	             // TODO Auto-generated method stub
	        	 Intent intent = new Intent();
	        	 intent.putExtra ("name", "Alan");
	             intent.setClass(MainChat.this, ChatroomActivity.class);
	             startActivity(intent);
	         }
         });
		
		ChrisChat = (TextView)findViewById(R.id.ChrisChat);
		ChrisChat.setOnClickListener(new ImageButton.OnClickListener(){ 
	         @Override
	         public void onClick(View v) {
	             // TODO Auto-generated method stub
	        	 Intent intent = new Intent();
	        	 intent.putExtra ("name", "Chris");
	             intent.setClass(MainChat.this, ChatroomActivity.class);
	             startActivity(intent);
	         }
         });
		
		
	
		PeterHelp = (TextView)findViewById(R.id.PeterHelp);
		PeterHelp.setOnClickListener(new ImageButton.OnClickListener(){ 
	         @Override
	         public void onClick(View v) {
	             // TODO Auto-generated method stub
	        	 Intent intent = new Intent();
	        	 intent.putExtra ("name", "Peter");
	             intent.setClass(MainChat.this, ChatHelpActivity.class);
	             startActivity(intent);
	         }
		});
		
		KenHelp = (TextView)findViewById(R.id.KenHelp);
		KenHelp.setOnClickListener(new ImageButton.OnClickListener(){ 
	         @Override
	         public void onClick(View v) {
	             // TODO Auto-generated method stub
	        	 Intent intent = new Intent();
	        	 intent.putExtra ("name", "Ken");
	             intent.setClass(MainChat.this, ChatHelpActivity.class);
	             startActivity(intent);
	         }
         });
		
		BrianHelp = (TextView)findViewById(R.id.BrianHelp);
		BrianHelp.setOnClickListener(new ImageButton.OnClickListener(){ 
	         @Override
	         public void onClick(View v) {
	             // TODO Auto-generated method stub
	        	 Intent intent = new Intent();
	        	 intent.putExtra ("name", "Brian");
	             intent.setClass(MainChat.this, ChatHelpActivity.class);
	             startActivity(intent);
	         }
         });
		
		MaryHelp = (TextView)findViewById(R.id.MaryHelp);
		MaryHelp.setOnClickListener(new ImageButton.OnClickListener(){ 
	         @Override
	         public void onClick(View v) {
	             // TODO Auto-generated method stub
	        	 Intent intent = new Intent();
	        	 intent.putExtra ("name", "Mary");
	             intent.setClass(MainChat.this, ChatHelpActivity.class);
	             startActivity(intent);
	         }
         });
		
		AlanHelp = (TextView)findViewById(R.id.AlanHelp);
		AlanHelp.setOnClickListener(new ImageButton.OnClickListener(){ 
	         @Override
	         public void onClick(View v) {
	             // TODO Auto-generated method stub
	        	 Intent intent = new Intent();
	        	 intent.putExtra ("name", "Alan");
	             intent.setClass(MainChat.this, ChatHelpActivity.class);
	             startActivity(intent);
	         }
         });
		
		ChrisHelp = (TextView)findViewById(R.id.ChrisHelp);
		ChrisHelp.setOnClickListener(new ImageButton.OnClickListener(){ 
	         @Override
	         public void onClick(View v) {
	             // TODO Auto-generated method stub
	        	 Intent intent = new Intent();
	        	 intent.putExtra ("name", "Chris");
	             intent.setClass(MainChat.this, ChatHelpActivity.class);
	             startActivity(intent);
	         }
         });
	}
	
		
	

	TextView PeterChat;
	TextView KenChat;
	TextView BrianChat;
	TextView MaryChat;
	TextView PeterHelp;
	TextView KenHelp;
	TextView BrianHelp;
	TextView MaryHelp;

	TextView AlanChat;
	TextView ChrisChat;
	TextView AlanHelp;
	TextView ChrisHelp;
}
