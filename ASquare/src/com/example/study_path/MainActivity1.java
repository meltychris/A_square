package com.example.study_path;
//http://stackoverflow.com/questions/12602426/listview-with-checkbox-radiobutton-textview-and-button-not-working-correctly-in

import java.util.ArrayList;
import java.util.List;

import com.example.asquare.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity1 extends Activity implements OnItemClickListener {

    ListView listView;
    ArrayAdapter<Model> adapter;
    List<Model> list = new ArrayList<Model>();

       private Button btn;

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.choose);

        listView = (ListView) findViewById(R.id.my_list);

        btn = (Button) findViewById(R.id.submit);

        btn.setOnClickListener(new View.OnClickListener() {
            int count = 0;

            @Override
            public void onClick(View view) {


                count = listView.getAdapter().getCount();
                for (int i = 0; i < count; i++) {
                    // here i am not able to get the records as getting on onItemClick of the listview
                }
            }
        });

        adapter = new MyAdapter(this, getModel());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
        TextView label = (TextView) v.getTag(R.id.label);
        CheckBox checkbox = (CheckBox) v.getTag(R.id.check);
        Toast.makeText(v.getContext(),
                label.getText().toString() + " " + isCheckedOrNot(checkbox),
                Toast.LENGTH_LONG).show();

    }

    private String isCheckedOrNot(CheckBox checkbox) {
        if (checkbox.isChecked())
            return "is checked";
        else
            return "is not checked";
    }

    private List<Model> getModel() {
        list.add(new Model("Linux"));
        list.add(new Model("Windows7"));
        list.add(new Model("Suse"));
        list.add(new Model("Eclipse"));
        list.add(new Model("Ubuntu"));
        list.add(new Model("Solaris"));
        list.add(new Model("Android"));
        list.add(new Model("iPhone"));
        list.add(new Model("Java"));
        list.add(new Model(".Net"));
        list.add(new Model("PHP"));
        return list;
    }
}

