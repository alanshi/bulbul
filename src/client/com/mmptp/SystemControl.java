package client.com.mmptp;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;


public class SystemControl extends Activity {
	/** Called when the activity is first created. */

	//定义图片按钮

	
	ImageButton ButtonLogoff;
	ImageButton ButtonReboot;
	ImageButton ButtonShutdown;
	

	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.system_control);
		Intent intent=getIntent(); 
		setTitle("ImageButton");
		//初始化UI
		
		
		ButtonLogoff = (ImageButton) this.findViewById(R.id.ButtonLogoff);
		ButtonReboot = (ImageButton) this.findViewById(R.id.ButtonReboot);
		ButtonShutdown = (ImageButton) this.findViewById(R.id.ButtonShutdown);
		
		
		ButtonLogoff.setBackgroundResource(R.drawable.logoff);
		ButtonReboot.setBackgroundResource(R.drawable.reboot);
		ButtonShutdown.setBackgroundResource(R.drawable.shutdown);
		
	
        
		//设置按钮事件监听
	
		ButtonLogoffListener();
		ButtonRebootListener();
		ButtonShutdownListener();

		
		//鼠标按键监听
		//SetButtonMouseListener();


	}

	
	
	/**
	 * 注销
	 */
	private void ButtonLogoffListener() {
		ButtonLogoff.setOnTouchListener(new OnTouchListener(){
			
			public boolean onTouch(View v, MotionEvent event) 
	        {
				 switch (event.getAction())
			        {
				        case MotionEvent.ACTION_DOWN: // gets called
				        {
				        	ButtonLogoff.setBackgroundResource(R.drawable.logoff_press);
				        	SystemControl("logoff");
				        	break;
				        }
				        case MotionEvent.ACTION_UP: // doesnt seem to do anything
				        {
				        	ButtonLogoff.setBackgroundResource(R.drawable.logoff);
	
				        	break;
				        }

			        }
				return true;
				
	        }

			
		});
	}
	/**
	 * 重启
	 */
	private void ButtonRebootListener() {
		ButtonReboot.setOnTouchListener(new OnTouchListener(){
			
			public boolean onTouch(View v, MotionEvent event) 
	        {
				 switch (event.getAction())
			        {
				        case MotionEvent.ACTION_DOWN: // gets called
				        {
				        	ButtonReboot.setBackgroundResource(R.drawable.reboot_press);
				        	SystemControl("reboot");
				        	break;
				        }
				        case MotionEvent.ACTION_UP: // doesnt seem to do anything
				        {
				        	ButtonReboot.setBackgroundResource(R.drawable.reboot);
	
				        	break;
				        }
				       

			        }
				return true;
				
	        }

			
		});
	}
	/**
	 * 关机
	 */
	private void ButtonShutdownListener() {
		ButtonShutdown.setOnTouchListener(new OnTouchListener(){
			
			public boolean onTouch(View v, MotionEvent event) 
	        {
				 switch (event.getAction())
			        {
				        case MotionEvent.ACTION_DOWN: // gets called
				        {
				        	ButtonShutdown.setBackgroundResource(R.drawable.shutdown_press);
				        	SystemControl("shutdown");
				        	break;
				        }
				        case MotionEvent.ACTION_UP: // doesnt seem to do anything
				        {
				        	ButtonShutdown.setBackgroundResource(R.drawable.shutdown);
	
				        	break;
				        }
				       

			        }
				return true;
				
	        }

			
		});
	}
	

	/** 系统控制函数 **/
	public void SystemControl(String commandValue)
	{
		String sendData = "systemControl:"+commandValue;
		Message.Send(sendData);
	}
	
}