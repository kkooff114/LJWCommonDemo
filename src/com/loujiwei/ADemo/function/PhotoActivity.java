package com.loujiwei.ADemo.function;

import com.loujiwei.ADemo.R;
import com.loujiwei.common.activity.LJWBaseActivity;
import com.loujiwei.common.activity.TakePhotoActivity;
import com.loujiwei.common.application.Content;
import com.loujiwei.common.application.LJWApplication;
import com.loujiwei.common.utils.ImageUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 *
 * @author Lou Jiwei 
 * @email  kkooff114@gmail.com
 * @create 2013-10-5 下午4:30:19
 * 
 */
public class PhotoActivity extends LJWBaseActivity{
	
	private Button takePhotoButton;
	private ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photo);
		init();
	}
	private void init(){
		
		takePhotoButton=(Button) findViewById(R.id.photo_photo);
		imageView=(ImageView) findViewById(R.id.photo_imageview);
	}
	
	public void onClick(View view){
		switch (view.getId()) {
		case R.id.photo_photo:
			openActivity(TakePhotoActivity.class);
			break;
		default:
			break;
		}
	}
	@Override
	protected void onResume() {
		super.onResume();
		try {
			imageView.setImageBitmap(ImageUtils.getPictureFromSDCard(Content.getTakePhoto_Path()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
