package com.example.asquare;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.view.View;
import android.widget.*;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
public class DataList extends Activity implements View.OnClickListener {
    private Button sample1;
    private Button viewcode1;
    private mydatabase DH = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datalist);
        findControl();
        setClick();
        openDB();
    }
    private void add(String Title,String Content,String Kind){
        SQLiteDatabase db = DH.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("_TITLE", Title.toString());
        values.put("_CONTENT", Content.toString());
        values.put("_KIND", Kind.toString());
        db.insert("MySample", null, values);
    }
    private void openDB(){
    	DH = new mydatabase(this);  
    }
    private void closeDB(){
    	DH.close();    	
    }
    
    private void findControl() {
    	sample1 = (Button)findViewById(R.id.sample1);
    	viewcode1 = (Button)findViewById(R.id.viewcode1);
    }
    
    private void setClick() {
        sample1.setOnClickListener(this);
    	viewcode1.setOnClickListener(this);
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        closeDB();
    }
    
	@Override
	public void onClick(View v) {
		
		//Toast popup = Toast.makeText(this, "hello", Toast.LENGTH_SHORT);
		//popup.show();
		if (v.getId() == R.id.sample1) {			
			add("A","test","1");
			openDialog("test","1");					
		} else if (v.getId() == R.id.viewcode1) {			
			add("B","test","2");
			openDialog("","2");			
		}
	}
	
	private void openDialog(String Msg,String Mode) {
		if (Mode =="1") {
		   TextView AlertMsg = new TextView(this);
	       AlertMsg.setText(Msg);	
		   new AlertDialog.Builder(this).setTitle("Observation").setView(AlertMsg).show();	       
		} else if (Mode == "2") {
		   String url = "file:///android_asset/Sample.html";
		   WebView AlertMsg = new WebView(this);
		   WebSettings websettings = AlertMsg.getSettings();  
	       websettings.setSupportZoom(true);  
	       websettings.setJavaScriptEnabled(true);  
		   AlertMsg.setWebViewClient(new WebViewClient());  
		   AlertMsg.loadUrl("file:///android_asset/Sample.html");
		   new AlertDialog.Builder(this).setTitle("Code")
		   .setView(AlertMsg).show();				
			
		}

	}
	
}

