package com.example.advising;

import com.example.asquare.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class otherActivity2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.advising_other2);

		button3 = (Button) findViewById(R.id.button3);
		button3.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myIntentDial = new Intent(Intent.ACTION_DIAL, Uri
						.parse("tel:27976888"));

				startActivity(myIntentDial);
			};
		});
	

	}

	private Button button3;
}
