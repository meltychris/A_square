package com.example.manual;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.asquare.R;


public class ManualMainActivity extends Activity {
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.manual_layout);
			
			String myURL = "file:///android_asset/web/index.htm";       
	        WebView myBrowser=(WebView)findViewById(R.id.mybrowser);

	        WebSettings websettings = myBrowser.getSettings();
	        websettings.setSupportZoom(true);
	        websettings.setJavaScriptEnabled(true);
	       
	        myBrowser.setWebViewClient(new WebViewClient());

	        myBrowser.loadUrl(myURL);
		}
}
