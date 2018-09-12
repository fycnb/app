package com.example.school.activity;

import com.example.school.R;
import com.example.school.R.id;
import com.example.school.R.layout;
import com.example.school.R.menu;
import com.example.school.activity.first.FirstActivity;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends TabActivity {

//	private RadioButton guide_home, guide_store, guide_cart,guide_ww;
    private Intent intent1;
    private Intent intent2;
    private Intent intent3;
    private Intent intent4;
    private String tab="tab0";
//    private int currIndex = 0;
    private TabHost tabHost;
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        //初始化四个Activity
        intent1 = new Intent(this, FirstActivity.class);
        intent2 = new Intent(this, FirstActivity.class);
        intent3 = new Intent(this, FirstActivity.class);
        intent4 = new Intent(this, FirstActivity.class);
//        init();
        inittAB();
	}
    //填充TabHost
	  private void inittAB() {
	        tabHost = getTabHost();
	        //这里tab0是第一个，tab1是第二个窗口，以此类推
	        tabHost.addTab(tabHost.newTabSpec("首页")
	                .setIndicator(createTabIcon(R.color.selector_home, "首页"))
	                .setContent(intent1));
	        tabHost.addTab(tabHost.newTabSpec("交友")
	                .setIndicator(createTabIcon(R.color.selector_friend, "交友"))
	                .setContent(intent2));
	        tabHost.addTab(tabHost.newTabSpec("课程表")
	                .setIndicator(createTabIcon(R.color.selector_lesson, "课程表"))
	                .setContent(intent3));
	        tabHost.addTab(tabHost.newTabSpec("我的")
	                .setIndicator(createTabIcon(R.color.selector_my, "我的"))
	                .setContent(intent4));
	        if(tab.equalsIgnoreCase("tab0")){
	            tabHost.setCurrentTabByTag("tab0");
	        }
	    }

    
	public View createTabIcon(int resId,String title){
		
		View view = null;
		
		view = LayoutInflater.from(this).inflate(R.layout.tab_icon, null);

		ImageView iv = (ImageView)view.findViewById(R.id.iv_icon);
		iv.setImageResource(resId);
		
		TextView tv = (TextView)view.findViewById(R.id.tv_title);
		tv.setText(title);
		tv.setGravity(Gravity.CENTER);
			
		return view;
	}



}