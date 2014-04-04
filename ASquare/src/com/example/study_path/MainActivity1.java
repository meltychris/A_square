package com.example.study_path;
//http://stackoverflow.com/questions/12602426/listview-with-checkbox-radiobutton-textview-and-button-not-working-correctly-in

import java.util.ArrayList;
import java.util.List;

import com.example.asquare.R;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity1 extends Activity{

    ListView listView;
    ArrayAdapter<Model> adapter;
    List<Model> list = new ArrayList<Model>();

       private Button btn;

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.choose);
        Intent intent = new Intent();
     	
     
     	
        
        listView = (ListView) findViewById(R.id.my_list);

        btn = (Button) findViewById(R.id.submit);

        btn.setOnClickListener(new View.OnClickListener() {
            int count = 0;

            @Override
            public void onClick(View view) {


                //count = listView.getAdapter().getCount();
            	Intent intent = new Intent();
            	String [] temp = new String [50];
            	Boolean [] check = new Boolean [50];
            	int Year;

            	
            	intent.putExtra ("Major1", Major1);
             	intent.putExtra ("Major2", Major2);
             	intent.putExtra ("Pure", Pure);
             	intent.putExtra ("Year1", Year);
             	intent.putExtra ("Year2", Year2);
             	intent.putExtra ("Year3", Year3);
             	intent.putExtra ("Sem1", Sem1);
             	intent.putExtra ("Sem2", Sem2);
             	intent.putExtra ("Credit", Credit);
             	intent.putExtra ("SA", SA);
             	intent.putExtra ("S_T", S_T);
             	intent.putExtra ("A_H", A_H);
             	intent.putExtra ("Free", Free);
             	intent.putExtra ("SBM", SBM);
             	intent.putExtra ("ENGG", ENGG);
             	intent.putExtra ("FreeE", FreeE);
             	intent.putExtra ("compx1", compx1);
             	intent.putExtra ("compx2", compx2);
             	intent.putExtra ("compx3", compx3);
             	intent.putExtra ("compx4", compx4);
             	intent.putExtra ("compx5", compx5);
             	intent.putExtra ("CEMx1", CEMx1);
             	intent.putExtra ("CEMx2", CEMx2);
             	intent.putExtra ("Fail", Fail);
            	
            	
            	
            	
            	int i = 0;
                for (Model a: list) {
                    // here i am not able to get the records as getting on onItemClick of the listview
                	/*Toast.makeText(view.getContext(),
                			a.getName() + "\n" + a.isSelected(),
                            Toast.LENGTH_SHORT).show();*/
                	temp[0] = a.getName();
                	check[0] = (a.isSelected());
                	i++;
                 	
                }
                intent.
                intent.putExtra ("Course", temp);
                intent.putExtra ("Course", check);
                intent.setClass(MainActivity1.this, Advanced_Activity2.class);


            }
        });

        adapter = new MyAdapter(this, getModel());
        listView.setAdapter(adapter);
        //listView.setOnItemClickListener(this);
    }

   /* @Override
    public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
        TextView label = (TextView) v.getTag(R.id.label);
        CheckBox checkbox = (CheckBox) v.getTag(R.id.check);
        Toast.makeText(v.getContext(),
                label.getText().toString() + " " + isCheckedOrNot(checkbox),
                Toast.LENGTH_LONG).show();
*/
	Boolean Major1;
	Boolean Major2;
	Boolean Pure;
	Boolean Year1;
	Boolean Year2;
	Boolean Year3;
	Boolean Sem1;
	Boolean Sem2;
	String Credit;
	Boolean SA;
	Boolean S_T;
	Boolean A_H;
	Boolean Free;
	Boolean SBM;
	Boolean ENGG;
	Boolean FreeE;
	Boolean compx1;
	Boolean compx2;
	Boolean compx3;
	Boolean compx4;
	Boolean compx5;
	Boolean CEMx1;
	Boolean CEMx2;
	String Fail;
   
    
    }

    private List<Model> getModel() {			//get all course need to study
     
        TestAdapter mDbHelper = new TestAdapter(this);         
	    	mDbHelper.createDatabase();       
	    	mDbHelper.open(); 
	    	 
			
	        String sql ="SELECT Code FROM COMP"; 
	    	Cursor testdata = mDbHelper.getTestData(sql); 
	    	String code = Utility.GetColumnValue(testdata, "Code");
	    	list.add(new Model(code));
	    	while (testdata.moveToNext()){
	    		 
	        	code = Utility.GetColumnValue(testdata, "Code");
	        	list.add(new Model(code));
    	}
    	
    	mDbHelper.close();

        return list;
    }

}

