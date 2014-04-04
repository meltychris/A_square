package com.samir.multilist;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private static final String rssFeed = "https://dl.dropbox.com/s/ubezjbp553u750k/name.xml?dl=1";

	private ListView listView;
	private List<NameBean> items;
	private NamesAdapter objAdapter = null;

	private Button btnGetSelected;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		listView = (ListView) findViewById(R.id.listview);
		btnGetSelected = (Button) findViewById(R.id.btnget);
		btnGetSelected.setOnClickListener(this);

		// XML Parsing Using AsyncTask...
		if (isNetworkAvailable()) {
			new MyTask().execute();
		} else {
			showToast("No Netwrok Connection!!!");
			this.finish();
		}
	}

	// My AsyncTask start...

	class MyTask extends AsyncTask<Void, Void, Void> {

		ProgressDialog pDialog;

		@Override
		protected void onPreExecute() {
			pDialog = new ProgressDialog(MainActivity.this);
			pDialog.setMessage("Loading...");
			pDialog.show();
			super.onPreExecute();
		}

		@Override
		protected Void doInBackground(Void... params) {
			items = new NamesParser().getData(rssFeed);
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			if (null != pDialog && pDialog.isShowing()) {
				pDialog.dismiss();
			}

			if (null == items || items.size() == 0) {
				showToast("No data found from web!!!");
				MainActivity.this.finish();
			} else {
				setAdapterToListview();
			}

			super.onPostExecute(result);
		}
	}

	// setAdapter Here....

	public void setAdapterToListview() {

		// Sort Data Alphabatical order
		Collections.sort(items, new Comparator<NameBean>() {

			@Override
			public int compare(NameBean lhs, NameBean rhs) {
				return lhs.getName().compareTo(rhs.getName());
			}
		});

		objAdapter = new NamesAdapter(MainActivity.this, items);
		listView.setAdapter(objAdapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				CheckBox chk = (CheckBox) view.findViewById(R.id.checkbox);
				NameBean bean = items.get(position);
				if (bean.isSelected()) {
					bean.setSelected(false);
					chk.setChecked(false);
				} else {
					bean.setSelected(true);
					chk.setChecked(true);
				}

			}
		});

	}

	// Toast is here...
	private void showToast(String msg) {
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onClick(View v) {
		StringBuffer sb = new StringBuffer();

		// Retrive Data from list
		for (NameBean bean : items) {

			if (bean.isSelected()) {
				sb.append(bean.getName());
				sb.append(",");
			}
		}

		showAlertView(sb.toString().trim());

	}

	private void showAlertView(String str) {
		AlertDialog alert = new AlertDialog.Builder(this).create();
		if (TextUtils.isEmpty(str)) {
			alert.setTitle("Not Selected");
			alert.setMessage("No One is Seleceted!!!");
		} else {
			// Remove , end of the name
			String strContactList = str.substring(0, str.length() - 1);

			alert.setTitle("Selected");
			alert.setMessage(strContactList);
		}
		alert.setButton("Ok", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		alert.show();
	}

	// OnBackPressed...

	@Override
	public void onBackPressed() {
		AlertDialog alert_back = new AlertDialog.Builder(this).create();
		alert_back.setTitle("Quit?");
		alert_back.setMessage("Are you sure want to Quit?");

		alert_back.setButton("No", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});

		alert_back.setButton2("Yes", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				MainActivity.this.finish();
			}
		});
		alert_back.show();
	}

	// Check Internet Connection!!!

	public boolean isNetworkAvailable() {
		ConnectivityManager connectivity = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connectivity == null) {
			return false;
		} else {
			NetworkInfo[] info = connectivity.getAllNetworkInfo();
			if (info != null) {
				for (int i = 0; i < info.length; i++) {
					if (info[i].getState() == NetworkInfo.State.CONNECTED) {
						return true;
					}
				}
			}
		}
		return false;
	}
}