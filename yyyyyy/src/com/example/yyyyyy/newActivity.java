package com.example.yyyyyy;
//don't change
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class newActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
		setContentView(R.layout.newactivity);    
	
	    // TODO Auto-generated method stub
	    button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new ImageView.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	new AlertDialog.Builder( newActivity.this )
                .setTitle( "Message box" )
                .setMessage( "Return?" )
                .setPositiveButton( "Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    	finish();    
                    }
                })
                .setNegativeButton( "No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d( "AlertDialog", "Negative" );
                    }
                })
                .show();
            }
        }); 
	}
	
    private Button button1;

}