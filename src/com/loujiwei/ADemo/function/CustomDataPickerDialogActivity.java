package com.loujiwei.ADemo.function;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.loujiwei.ADemo.R;
import com.loujiwei.common.activity.LJWBaseActivity;
import com.loujiwei.common.customfunction.CustomerDataPickerDialog;

/**
 *
 * @author Lou Jiwei 
 * @email  kkooff114@gmail.com
 * @create 2013-10-6 上午8:58:47
 * 
 */
public class CustomDataPickerDialogActivity extends LJWBaseActivity{
	
	private Integer mYear;
	private int mMonth;
	private int mDay;
	
	private static final int SHOW_DATAPICK = 0;
	private static final int DATE_DIALOG_ID = 1;
	private static final int SHOW_TIMEPICK = 2;
	private static final int TIME_DIALOG_ID = 3;
	private static final int SHOW_DATAPICK_YEAR_DAY=4;
	//定制显示的时候,在这边添加需要组合显示的static final int的值,并添加到对应的dateandtimeHandler与onCreateDialog()中
	
	private boolean hasYear=false;
	private boolean hasMonth=false;
	private boolean hasDay=false;
	private StringBuffer sbTitle = null;
	
	private EditText select_year;
	private Button select_pickDateStart;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.custom_datapickerdialog);
		init();
	}
	
	private void init(){
		select_year=(EditText) findViewById(R.id.select_year);
		select_pickDateStart=(Button) findViewById(R.id.select_pickDateStart);
		select_pickDateStart.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Message msg = new Message();
				if (select_pickDateStart.equals((Button) v)) {
					msg.what = CustomDataPickerDialogActivity.SHOW_DATAPICK_YEAR_DAY;
				}
				CustomDataPickerDialogActivity.this.dateandtimeHandler.sendMessage(msg);
			}
		});
		setDateTime();// 初始化时间为今天
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_DIALOG_ID:
			hasYear=true;
			hasMonth=false;
			hasDay=false;
			return new CustomerDataPickerDialog(this, mDateSetListener,true,false,false, mYear,
					mMonth,mDay);
		case SHOW_DATAPICK_YEAR_DAY:
			hasYear=true;
			hasMonth=false;
			hasDay=true;
			return new CustomerDataPickerDialog(this, mDateSetListener,true,false,true, mYear,
					mMonth,mDay);
		case TIME_DIALOG_ID:
			// return new DatePickerDialog(this, mDateSetListener2, mYear1,
			// mMonth1,mDay1);
		}

		return null;
	}
	
	/**
	 * 处理日期和时间控件的Handler
	 */
	Handler dateandtimeHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case CustomDataPickerDialogActivity.SHOW_DATAPICK:
				showDialog(DATE_DIALOG_ID);
				break;
			case CustomDataPickerDialogActivity.SHOW_TIMEPICK:
				showDialog(TIME_DIALOG_ID);
				break;
			case CustomDataPickerDialogActivity.SHOW_DATAPICK_YEAR_DAY:
				showDialog(SHOW_DATAPICK_YEAR_DAY);
				break;
			}
		}
	};
	

	/**
	 * 日期控件的事件
	 */
	private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {

		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			mYear = year;
			mMonth = monthOfYear;
			mDay = dayOfMonth;

			updateDateDisplay();
		}
	};
	/**
	 * 更新日期显示
	 */
	private void updateDateDisplay() {
		//select_year.setText(new StringBuilder().append(mYear));
		
		// .append("-")
		// .append((mMonth + 1) < 10 ? "0" + (mMonth + 1) : (mMonth + 1))
		// .append("-").append((mDay < 10) ? "0" + mDay : mDay));
		sbTitle=new StringBuffer();
		if (hasYear) {
			sbTitle.append(mYear + "年");
		}
		if (hasMonth) {
			sbTitle.append((mMonth + 1) + "月");
		}
		if (hasDay) {
			sbTitle.append(mDay + "日");
		}
		select_year.setText(sbTitle);
		
	}
	
	/**
	 * 设置日期
	 */
	private void setDateTime() {
		final Calendar c = Calendar.getInstance();

		mYear = c.get(Calendar.YEAR);
		mMonth = c.get(Calendar.MONTH);
		mDay = c.get(Calendar.DAY_OF_MONTH);

		// updateDateDisplay();
	}


}
