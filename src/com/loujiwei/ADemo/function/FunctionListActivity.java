package com.loujiwei.ADemo.function;

import java.util.ArrayList;

import com.loujiwei.ADemo.R;
import com.loujiwei.ADemo.Adapter.MainListAdapter;
import com.loujiwei.ADemo.basecontrol.SrollableTabHost.IntentObject;
import com.loujiwei.common.activity.LJWBaseActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * 
 * @author Lou Jiwei
 * @email kkooff114@gmail.com
 * @create 2013-10-5 下午4:18:42
 * 
 */
public class FunctionListActivity extends LJWBaseActivity {

	private ArrayList intentsArray;
	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.startdemo);

		listView = (ListView) findViewById(R.id.startdemo_listview);

		// 添加目录
		intentsArray = new ArrayList();
		// 获取图片,相机相册
		IntentObject PhotoActivity = new IntentObject();
		PhotoActivity.title = "相机相册";
		PhotoActivity.description = "从相机相册中获取图片";
		PhotoActivity.intent = new Intent(this, PhotoActivity.class);
		intentsArray.add(PhotoActivity);

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

}
