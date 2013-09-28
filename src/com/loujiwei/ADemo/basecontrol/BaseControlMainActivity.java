package com.loujiwei.ADemo.basecontrol;

import java.util.ArrayList;

import com.loujiwei.ADemo.R;
import com.loujiwei.ADemo.basecontrol.SrollableTabHost.IntentObject;
import com.loujiwei.ADemo.basecontrol.SrollableTabHost.ProjectList;
import com.loujiwei.Adapter.MainListAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class BaseControlMainActivity extends Activity {

	private ArrayList intentsArray;
	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.startdemo);

		listView = (ListView) findViewById(R.id.startdemo_listview);

		// 添加目录
		intentsArray = new ArrayList();
		// 基础控件
		IntentObject BaseControlMainActivity = new IntentObject();
		BaseControlMainActivity.title = "基础控件";
		BaseControlMainActivity.description = "基础布局控件";
		BaseControlMainActivity.intent = new Intent(this,
				ProjectList.class);
		intentsArray.add(BaseControlMainActivity);

		listView.setAdapter(new MainListAdapter(this, intentsArray));
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent = ((IntentObject) intentsArray.get(arg2)).intent;
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
