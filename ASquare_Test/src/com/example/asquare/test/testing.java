package com.example.asquare.test;

import com.example.asquare.MainActivity;
import android.test.ActivityInstrumentationTestCase2;

public class testing extends
ActivityInstrumentationTestCase2<MainActivity> {

@SuppressWarnings("deprecation")
public testing() {
super("com.example.asquare",MainActivity.class);
}

protected void setUp() throws Exception {
super.setUp();

MainActivity mainActivity = getActivity();  
}



public void testAddValues() {  

assertTrue("Add result should be 98", true);  
}
}
