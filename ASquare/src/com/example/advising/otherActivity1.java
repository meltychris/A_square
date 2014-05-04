package com.example.advising;

import com.example.asquare.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class otherActivity1 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.advising_other1);

		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myIntentDial = new Intent(Intent.ACTION_DIAL, Uri
						.parse("tel:27720047"));

				startActivity(myIntentDial);
			};
		});

		button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(otherActivity1.this,
						otherActivity2.class);
				startActivity(intent);
			}
		});

	}

	private Button button1;
	private Button button2;
}
