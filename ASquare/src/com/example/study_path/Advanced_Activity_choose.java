package com.example.study_path;
//http://stackoverflow.com/questions/12602426/listview-with-checkbox-radiobutton-textview-and-button-not-working-correctly-in

import java.util.ArrayList;
import java.util.List;

import com.example.asquare.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Advanced_Activity_choose extends Activity{

    ListView listView;
    ArrayAdapter<Model> adapter;
    List<Model> list = new ArrayList<Model>();
    Button btn;
    String major;

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.adv_path_choose);     	
        
        Bundle params = getIntent().getExtras();
 	    if (params!= null) {
 	    	Major1 = params.getBoolean ("Major1");
 	    	Major2 = params.getBoolean ("Major2");
			if (Major1) major = "COMP";
	    	else major = "CPEG";
 	    	
			Pure = params.getBoolean ("Pure");
 	    	Year1 = params.getBoolean ("Year1");
 	    	Year2 = params.getBoolean ("Year2");
 	    	Year3 = params.getBoolean ("Year3");         	    	
 	    	Sem1 = params.getBoolean ("Sem1");
 	    	Sem2 = params.getBoolean ("Sem2");
 	    	Credit = params.getString ("Credit");
 	    	SA = params.getBoolean ("SA");
 	    	S_T = params.getBoolean ("S_T");
 	    	A_H = params.getBoolean ("A_H");
 	    	Free = params.getBoolean ("Free");
 	    	SBM = params.getBoolean ("SBM");
 	    	ENGG = params.getBoolean ("ENGG");
 	    	FreeE = params.getBoolean ("FreeE");
 	    	compx1 = params.getBoolean ("compx1");
 	    	compx2 = params.getBoolean ("compx2");
 	    	compx3 = params.getBoolean ("compx3");
 	    	compx4 = params.getBoolean ("compx4");
 	    	compx5 = params.getBoolean ("compx5");
 	    	CEMx1 = params.getBoolean ("CEMx1");
 	    	CEMx2 = params.getBoolean ("CEMx2");
 	    }
        
        listView = (ListView) findViewById(R.id.my_list);
        btn = (Button) findViewById(R.id.submit);

        
        
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
            	
                //count = listView.getAdapter().getCount();
            	Intent intent = new Intent();
            	List<String> temp = new ArrayList<String>();
            	List<String> check = new ArrayList<String>();

            	
            	intent.putExtra ("Major1", Major1);
             	intent.putExtra ("Major2", Major2);
             	intent.putExtra ("Pure", Pure);
             	intent.putExtra ("Year1", Year1);
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
            	
             	SharedPreferences xMajor1 = getSharedPreferences("Major1", 0);
             	SharedPreferences xMajor2 = getSharedPreferences("Major2", 0);
             	SharedPreferences xPure = getSharedPreferences("Pure", 0);
             	SharedPreferences xYear1 = getSharedPreferences("Year1", 0);
             	SharedPreferences xYear2 = getSharedPreferences("Year2", 0);
             	SharedPreferences xYear3 = getSharedPreferences("Year3", 0);
             	SharedPreferences xSem1 = getSharedPreferences("Sem1", 0);
             	SharedPreferences xSem2 = getSharedPreferences("Sem2", 0);
             	SharedPreferences xCredit = getSharedPreferences("Credit", 0);
             	SharedPreferences xadvanced = getSharedPreferences("advanced", 0);
             	
             	xMajor1.edit().putBoolean("Major1", Major1).commit();
             	xMajor2.edit().putBoolean("Major2", Major2).commit();
             	xPure.edit().putBoolean("Pure", Pure).commit();
             	xYear1.edit().putBoolean("Year1", Year1).commit();
             	xYear2.edit().putBoolean("Year2", Year2).commit();
             	xYear3.edit().putBoolean("Year3", Year3).commit();
             	xSem1.edit().putBoolean("Sem1", Sem1).commit();
             	xSem2.edit().putBoolean("Sem2", Sem2).commit();
             	xCredit.edit().putString("Credit", Credit).commit();


            	
                for (Model a: list) {
                    // here i am not able to get the records as getting on onItemClick of the listview
                
                	temp.add(a.getName());
                	if (a.isSelected())
                		check.add("true");
                	else
                		check.add("false");
                }
                
                String[] temp1 = new String[temp.size()];
                temp.toArray(temp1);
                String[] check1 = new String[check.size()];
                check.toArray(check1);
                
              
                intent.putExtra ("Course", temp1);
                intent.putExtra ("Checked", check1);
                intent.setClass(Advanced_Activity_choose.this, Advanced_Activity2.class);
                startActivity(intent);
                finish();
                


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
   
    
    

    private List<Model> getModel() {			//get all course need to study
     
        DataBaseTestAdapter1 mDbHelper = new DataBaseTestAdapter1(this);         
	    	mDbHelper.createDatabase();       
	    	mDbHelper.open(); 
	    	 
 	    	pure = (Pure?"T":"F");

 	    	String sql ="SELECT Code FROM "+major+" WHERE (Pure='All' OR Pure='" + pure + "') ORDER BY Year,Code"; 
	    	Cursor testdata = mDbHelper.getTestData(sql); 
	    	String code = DataBaseUtility1.GetColumnValue(testdata, "Code");
	    	list.add(new Model(code));
	    	while (testdata.moveToNext()){
	    		 
	        	code = DataBaseUtility1.GetColumnValue(testdata, "Code");
	        	Model temp = new Model(code);
	        	
	        	if ((code.equals("CommonCore1") && SA) ||			//name conversion
	        			(code.equals("CommonCore2") && S_T) ||
	        			(code.equals("CommonCore3") && A_H) ||
	        			(code.equals("CommonCore4") && Free) ||
	        			(code.equals("SBM") && SBM) ||
	        			(code.equals("ENGG") && ENGG) ||
	        			(code.equals("FreeElective") && FreeE) ||
	        			(code.equals("COMPElective1") && compx1) ||
	        			((code.equals("COMPElective1")|| code.equals("COMPElective2")) && compx2) ||
	        			((code.equals("COMPElective1")|| code.equals("COMPElective2") || code.equals("COMPElective3")) && compx3) ||
	        			((code.equals("COMPElective1")|| code.equals("COMPElective2") || code.equals("COMPElective3") || code.equals("COMPElective4")) && compx4) ||
	        			((code.equals("COMPElective1")|| code.equals("COMPElective2") || code.equals("COMPElective3") || code.equals("COMPElective4") || code.equals("COMPElective5")) && compx5) ||
	        			(code.equals("COMP/ELEC/MATH1") && CEMx1) ||
	        			((code.equals("COMP/ELEC/MATH1") || code.equals("COMP/ELEC/MATH2")) && CEMx2) 
	        							){
	        		
	        		temp.setSelected(true);
	        	}
	        
	        	list.add(temp);
    	}

		testdata.close();
    	mDbHelper.close();

        return list;
    }

    String pure;
}

