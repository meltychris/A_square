package com.example.gpa_calculator;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.asquare.R;









import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;


//ref: http://blog.joomla.org.tw/android/178-ListView%E4%B9%8B%E4%B8%80%EF%BC%9AAdapter%E4%BB%8B%E7%B4%B9%E8%88%87%E4%BD%BF%E7%94%A8.html

public class printTGA extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gpa_print_tga);
		
		
		//print all sem TGA if inputed
		ListView listViewGPAprint1 = (ListView) findViewById(R.id.listViewGPAprintTGA1);
			
		
		listViewGPAprint1.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, MainActivity.student1.printTGA()));
		
		
		
		
		//if there is a condition that needs warning, 
		//Print warning as a pop-up window, separated function with print TGA
		if (MainActivity.student1.printWarningTGA() != null && !MainActivity.student1.printWarningTGA().isEmpty())
		{
			
			String message = "The TGA of semester below is/are < 1.7: \n";
			
			//loop whole arraylist
			for (int i = 0 ; i < MainActivity.student1.printWarningTGA().size(); i++)
			{
				//in araylist, the no. is eg.
				//0+1 0+1 = no. 11 = year1 sem1
				int year_sem = Integer.parseInt(MainActivity.student1.printWarningTGA().get(i));
				int year = year_sem / 10;
				int sem = year_sem % 10;
				
				message = message + ("Year " + (year) + " " + MainActivity.student1.SemIntToWords(sem-1) + "\n");
			}
			
			message = message + ("According to UST ACADEMIC REGULATIONS for student, Academic Probation & Dismissal," + "\n" +
								"You are now placed on Academic Warning and required to seek academic advice." + "\n" +
								"Please work hard! :) "
								);
		
			
			Builder MyAlertDialog = new AlertDialog.Builder(printTGA.this);
			MyAlertDialog.setTitle("Warning about your TGA!");
			MyAlertDialog.setMessage(message);
			DialogInterface.OnClickListener OkClick = new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialog, int which) {
					//如果不做任何事情 就會直接關閉 對話方塊
					//Nothing to do 
				}
			};;
	   	 
			MyAlertDialog.setNeutralButton("OK",OkClick );
			MyAlertDialog.show();
		}

		
	}


}