package com.example.yyyyyy;
//don't change
import android.app.Activity;
import android.os.Bundle;


public class button1 extends Activity{
	public void onCreate(Bundle savedInstanceState) {
        //call the create fct. Of the base class
        super.onCreate(savedInstanceState);
        //load the layout specified in the layout.xml
        setContentView(R.layout.activity_main);
    }
}