package client.com.mmptp;

import java.lang.reflect.Field;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.TabHost.OnTabChangeListener;

public class MmptpActivity extends TabActivity {
    /** Called when the activity is first created. */
	private MmptpActivity th;
	private TabHost tabHost;
	private TabWidget tabWidget;
	Field mBottomLeftStrip;
	Field mBottomRightStrip;


    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_content);
		 th = this;
		 tabHost = (TabHost) findViewById(android.R.id.tabhost);
		 LayoutInflater.from(this).inflate(R.layout.main,tabHost.getTabContentView(),true);
		 tabWidget = tabHost.getTabWidget();
		 tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("连接",th.getResources().getDrawable(R.drawable.connect))
				  .setContent(new Intent(this, Connect.class)));
		 tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("媒体控制",th.getResources().getDrawable(R.drawable.media))
				 .setContent(new Intent(this, MediaControl.class)));
		 tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("系统控制",th.getResources().getDrawable(R.drawable.system))
				 .setContent(new Intent(this, SystemControl.class)));
		 tabHost.addTab(tabHost.newTabSpec("tab4").setIndicator("鼠标键盘",th.getResources().getDrawable(R.drawable.mouse))
				 .setContent(new Intent(this, MouseEvent.class)));
//		 tabHost.addTab(tabHost.newTabSpec("tab5").setIndicator("设置",th.getResources().getDrawable(R.drawable.ic_menu_preferences_tab))
//				 .setContent(new Intent(this, Tab5.class)));
		  tabHost.setCurrentTab(0);
	
		  tabWidget.setBackgroundResource(R.drawable.bg);
		  

		if (Integer.valueOf(Build.VERSION.SDK) <= 7) {
			try {
				mBottomLeftStrip = tabWidget.getClass().getDeclaredField ("mBottomLeftStrip");
				mBottomRightStrip = tabWidget.getClass().getDeclaredField ("mBottomRightStrip");
				if(!mBottomLeftStrip.isAccessible()) {
					mBottomLeftStrip.setAccessible(true);
				}
				if(!mBottomRightStrip.isAccessible()){
					mBottomRightStrip.setAccessible(true);
				}
				//mBottomLeftStrip.set(tabWidget, getResources().getDrawable (R.drawable.focus));
				//mBottomRightStrip.set(tabWidget, getResources().getDrawable (R.drawable.focus));

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				mBottomLeftStrip = tabWidget.getClass().getDeclaredField("mLeftStrip");
				mBottomRightStrip = tabWidget.getClass().getDeclaredField("mRightStrip");
				if (!mBottomLeftStrip.isAccessible()) {
					mBottomLeftStrip.setAccessible(true);
				}
				if (!mBottomRightStrip.isAccessible()) {
					mBottomRightStrip.setAccessible(true);
				}
				//mBottomLeftStrip.set(tabWidget, getResources().getDrawable(R.drawable.focus));
				//mBottomRightStrip.set(tabWidget, getResources().getDrawable(R.drawable.focus));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for (int i =0; i <tabWidget.getChildCount(); i++) {

			final TextView tv = (TextView) tabWidget.getChildAt(i).findViewById(android.R.id.title);
			tv.setTextColor(Color.WHITE);
			View vvv = tabWidget.getChildAt(i);
			if(tabHost.getCurrentTab()==i){
				//vvv.setBackgroundDrawable(getResources().getDrawable(R.drawable.focus));
				//vvv.setBackgroundResource(R.drawable.focus);
			}
			else {
				//vvv.setBackgroundDrawable(getResources().getDrawable(R.drawable.unfocus));
				//vvv.setBackgroundResource(R.drawable.unfocus);
			}
		}
 
		tabHost.setOnTabChangedListener(new OnTabChangeListener() {
			public void onTabChanged(String tabId) {
				
			}
		});
	}
    
}