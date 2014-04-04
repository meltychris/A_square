package com.samir.multilist;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class NamesAdapter extends ArrayAdapter<NameBean> {

	private List<NameBean> list;
	private LayoutInflater inflator;

	public NamesAdapter(Activity context, List<NameBean> list) {
		super(context, R.layout.row, list);
		this.list = list;
		inflator = context.getLayoutInflater();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder = null;
		if (convertView == null) {
			convertView = inflator.inflate(R.layout.row, null);
			holder = new ViewHolder();
			holder.title = (TextView) convertView.findViewById(R.id.title);
			holder.chk = (CheckBox) convertView.findViewById(R.id.checkbox);
			holder.chk
					.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

						@Override
						public void onCheckedChanged(CompoundButton view,
								boolean isChecked) {
							int getPosition = (Integer) view.getTag();
							list.get(getPosition).setSelected(view.isChecked());

						}
					});
			convertView.setTag(holder);
			convertView.setTag(R.id.title, holder.title);
			convertView.setTag(R.id.checkbox, holder.chk);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.chk.setTag(position);

		holder.title.setText(list.get(position).getName());
		holder.chk.setChecked(list.get(position).isSelected());

		return convertView;
	}

	static class ViewHolder {
		protected TextView title;
		protected CheckBox chk;
	}
}