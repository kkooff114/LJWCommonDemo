package com.loujiwei.ADemo;
import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.loujiwei.ADemo.basecontrol.BaseControlMainActivity;
import com.loujiwei.ADemo.basecontrol.SrollableTabHost.IntentObject;
import com.loujiwei.Adapter.MainListAdapter;
import com.loujiwei.common.activity.LJWBaseActivity;

/**
 * @author:	Lou Jiwei
 * @email:	kkooff114@gmail.com
 * @create: 2013-9-2
 */
public class StartDemo extends LJWBaseActivity{
	
	private ArrayList intentsArray;
	private ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.startdemo);
		
		listView=(ListView) findViewById(R.id.startdemo_listview);
		
		//添加目录
		intentsArray = new ArrayList();  
        // 基础控件
        IntentObject BaseControlMainActivity = new IntentObject();
        BaseControlMainActivity.title = "基础控件";
        BaseControlMainActivity.description = "基础布局控件";
        BaseControlMainActivity.intent = new Intent(this, BaseControlMainActivity.class);
        intentsArray.add(BaseControlMainActivity);
        
        listView.setAdapter(new MainListAdapter(this, intentsArray));
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent= ((IntentObject)intentsArray.get(arg2)).intent;
				startActivity(intent);
			}
		});
	}
	
	
}
