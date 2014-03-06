package com.example.yyyyyy;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);      

        button01 = (ImageView)findViewById(R.id.imageView01);
        textView1 = (TextView)findViewById(R.id.textView1);       
        button01.setOnClickListener(new ImageView.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                textView1.setText("Change text view");
            }
        });   
        
        button03 = (ImageView)findViewById(R.id.imageView03);
        button03.setOnClickListener(new ImageView.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	Toast.makeText(getApplicationContext(), "I am a toast" , Toast.LENGTH_SHORT).show();
            }
        }); 
        
        button05 = (ImageView)findViewById(R.id.imageView05);
        button05.setOnClickListener(new ImageView.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	new AlertDialog.Builder( MainActivity.this )
                .setTitle( "Message box" )
                .setMessage( "Go to newActivity" )
                .setPositiveButton( "OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, newActivity.class);
                        startActivity(intent);
                   }
                })
                .setNegativeButton( "Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d( "AlertDialog", "Negative" );
                    }
                })
                .show();
            }
        }); 
        
        button06 = (ImageView)findViewById(R.id.imageView06);
        button06.setOnClickListener(new ImageView.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	new AlertDialog.Builder( MainActivity.this )
                .setTitle( "Close app" )
                .setMessage( "Click ok" )
                .setPositiveButton( "OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    	System.exit(0);
                    }
                })
                .setNegativeButton( "Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d( "AlertDialog", "Negative" );
                    }
                })
                .show();
            }
        }); 
        
        button04 = (ImageView)findViewById(R.id.imageView04);
        button04.setOnClickListener(new ImageView.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	System.exit(0);
            }
        }); 
        
        button02 = (ImageView)findViewById(R.id.imageView02);
        button02.setOnClickListener(new ImageView.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
            	int orientaion = display.getRotation();
            	if ( orientaion == 0)
            		 setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            	else
            		 setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            	}
        }); 
        
        
}

        
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/** Called when the activity is first created. */ 
	    private ImageView button01;
	    private TextView textView1; 
	    private ImageView button03;
	    private ImageView button05;
	    private ImageView button06;
	    private ImageView button04;
	    private ImageView button02;
}


