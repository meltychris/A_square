package com.example.study_path;

import com.example.asquare.R;
import com.example.asquare.R.id;
import com.example.asquare.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Study_Path extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
        setContentView(R.layout.path_main);       

	    // TODO Auto-generated method stub
	    button1 = (Button)findViewById(R.id.button1);
	    edittext1 = (EditText)findViewById(R.id.editText1);
	    textView2 = (TextView)findViewById(R.id.textView2);
	    textView3 = (TextView)findViewById(R.id.textView3);
	    textView4 = (TextView)findViewById(R.id.textView4);
        button1.setOnClickListener(new ImageButton.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	String A = data.get(edittext1.getText().toString(), 1);
            	textView2.setText(A);  
            	String B = data.get(edittext1.getText().toString(), 2);
            	textView3.setText(B);  
            	String C = data.get(edittext1.getText().toString(), 3);
            	textView4.setText(C);  
            	
            	if	(C.equals(" "))
            			Toast.makeText(Study_Path.this, "Wrong Major", Toast.LENGTH_LONG).show();
            }
        });
	}
    private Button button1;
    private EditText edittext1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
}