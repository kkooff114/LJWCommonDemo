package com.loujiwei.Adapter;

import java.util.ArrayList;
import java.util.List;

import com.loujiwei.ADemo.R;
import com.loujiwei.ADemo.basecontrol.SrollableTabHost.IntentObject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * 
 * @author:	Lou Jiwei
 * @email:	kkooff114@gmail.com
 * @create: 2013-9-2
 *
 */
public class MainListAdapter extends BaseAdapter{
	private ArrayList intentsArray;
	private LayoutInflater mInflater;
	
	public MainListAdapter(Context c, ArrayList intents){
		intentsArray=new ArrayList();
		intentsArray=intents;
		mInflater = LayoutInflater.from(c);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return intentsArray.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(convertView==null){
			convertView = mInflater.inflate(R.layout.item_startdemo, null);
			holder = new ViewHolder();
            holder.text = (TextView) convertView.findViewById(R.id.title_tiem_startdemo);
            holder.description = (TextView) convertView.findViewById(R.id.description_tiem_startdemo);
            convertView.setTag(holder);
		}else{
			 holder = (ViewHolder) convertView.getTag();
		}
		 holder.text.setText(((IntentObject)intentsArray.get(position)).title);
         holder.description.setText(((IntentObject)intentsArray.get(position)).description);
         return convertView;
	}
	
	static class ViewHolder {
        TextView text;
        TextView description;
    }

}
