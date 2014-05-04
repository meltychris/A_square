package com.example.gpa_calculator;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.asquare.R;








import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.app.Activity;
import android.app.ListActivity;


//ref: http://blog.joomla.org.tw/android/178-ListView%E4%B9%8B%E4%B8%80%EF%BC%9AAdapter%E4%BB%8B%E7%B4%B9%E8%88%87%E4%BD%BF%E7%94%A8.html

//changed to extends ListActivity!!
public class print_course_record extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gpa_print_course_record);
		
		ListView listViewGPAprint1 = (ListView) findViewById(R.id.listViewGPAprint1);
			
		
		listViewGPAprint1.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, MainActivity.student1.printAllCourse()));
		
	}


}