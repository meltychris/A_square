package com.example.advising;

import com.example.asquare.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class advising_MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.advising_main);

		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(advising_MainActivity.this, ustTeamActivity.class);
				startActivity(intent);
			}
		});
		
		button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(advising_MainActivity.this, otherActivity1.class);
				startActivity(intent);
			}
		});
		
		imageView1 = (ImageView) findViewById(R.id.imageView1);
		imageView1.setOnClickListener(new ImageView.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(advising_MainActivity.this, ustTeamActivity.class);
				startActivity(intent);
			}
		});
		
		imageView2 = (ImageView) findViewById(R.id.imageView2);
		imageView2.setOnClickListener(new ImageView.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(advising_MainActivity.this, otherActivity1.class);
				startActivity(intent);
			}
		});
	}

	
	private Button button1;
	private Button button2;
	private ImageView imageView1;
	private ImageView imageView2;

}
