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


public class MediaControl extends Activity {
	/** Called when the activity is first created. */
	//定义TextView
	TextView textViewMediaControl;
	TextView textViewVolume;
	SeekBar SeekBarVolumeControl;
	//定义图片按钮
	ImageButton ButtonPlayPause;
	ImageButton ButtonPrevious;
	ImageButton ButtonNext;
	ImageButton ButtonFullStandScreen;
	ImageButton ButtonFallBack;
	ImageButton ButtonFastForward;

	
	private Button buttonMouse;
	
	//音量大小
	int volume;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.media_control);
		Intent intent=getIntent(); 
		setTitle("ImageButton");
		//初始化UI
		textViewMediaControl = (TextView) this.findViewById(R.id.textViewMediaControl);
		textViewVolume = (TextView) this.findViewById(R.id.textViewVolume);
		SeekBarVolumeControl = (SeekBar) this.findViewById(R.id.SeekBarVolumeControl);
		//初始化图片按钮
		ButtonPlayPause = (ImageButton) this.findViewById(R.id.ButtonPlayPause);
		ButtonPrevious = (ImageButton) this.findViewById(R.id.ButtonPrevious);
		ButtonNext = (ImageButton) this.findViewById(R.id.ButtonNext);
		ButtonFullStandScreen = (ImageButton) this.findViewById(R.id.ButtonFullStandScreen);
		ButtonFallBack = (ImageButton) this.findViewById(R.id.ButtonFallBack);
		ButtonFastForward = (ImageButton) this.findViewById(R.id.ButtonFastForward);
		

		
		// 设置图片按钮的背景
		ButtonPlayPause.setBackgroundResource(R.drawable.play);
		ButtonPrevious.setBackgroundResource(R.drawable.previous);
		ButtonNext.setBackgroundResource(R.drawable.next);
		ButtonFullStandScreen.setBackgroundResource(R.drawable.fullscreen);
		ButtonFallBack.setBackgroundResource(R.drawable.fallback);
		ButtonFastForward.setBackgroundResource(R.drawable.fastforward);
	
		
		//鼠标模拟
        buttonMouse = (Button) findViewById(R.id.buttonMouse);
        
		//设置按钮事件监听
		ButtonPlayPauseListener();
		ButtonPreviousListener();
		ButtonNextListener();
		ButtonFullStandScreenListener();
		ButtonFallBackListener();
		ButtonFastForwardListener();

		
		//音量控制监听
		SetVolumeListener();
		
		//鼠标按键监听
		//SetButtonMouseListener();


	}

	//鼠标按键监听
    public void SetButtonMouseListener()
    {
    	buttonMouse.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
	          //跳转界面
				Intent intent=new Intent(); 
	            //设置传递的参数 
				intent.setClass(MediaControl.this,MouseEvent.class); 
	            //启动intent的Activity 
				MediaControl.this.startActivity(intent); 
			}  
    		
    	}); 
    }
	
	/**
	 * 播放/暂停
	 */
	private void ButtonPlayPauseListener() {
		ButtonPlayPause.setOnTouchListener(new OnTouchListener(){
			
			public boolean onTouch(View v, MotionEvent event) 
	        {
				 switch (event.getAction())
			        {
				        case MotionEvent.ACTION_DOWN: // gets called
				        {
				        	ButtonPlayPause.setBackgroundResource(R.drawable.play_press);
				        	MediaControl("PausePlay");
				        	break;
				        }
				        case MotionEvent.ACTION_UP: // doesnt seem to do anything
				        {
				        	ButtonPlayPause.setBackgroundResource(R.drawable.play);
	
				        	break;
				        }

			        }
				return true;
				
	        }

			
		});
	}
	
	/**
	 * 上一曲
	 */
	private void ButtonPreviousListener() {
		ButtonPrevious.setOnTouchListener(new OnTouchListener(){
			
			public boolean onTouch(View v, MotionEvent event) 
	        {
				 switch (event.getAction())
			        {
				        case MotionEvent.ACTION_DOWN: // gets called
				        {
				        	ButtonPrevious.setBackgroundResource(R.drawable.previous_press);
				        	MediaControl("Previous");
				        	break;
				        }
				        case MotionEvent.ACTION_UP: // doesnt seem to do anything
				        {
				        	ButtonPrevious.setBackgroundResource(R.drawable.previous);
	
				        	break;
				        }

			        }
				return true;
				
	        }

			
		});
	}
	
	/**
	 * 下一曲
	 */
	private void ButtonNextListener() {
		ButtonNext.setOnTouchListener(new OnTouchListener(){
			
			public boolean onTouch(View v, MotionEvent event) 
	        {
				 switch (event.getAction())
			        {
				        case MotionEvent.ACTION_DOWN: // gets called
				        {
				        	ButtonNext.setBackgroundResource(R.drawable.next_press);
				        	MediaControl("Next");
				        	break;
				        }
				        case MotionEvent.ACTION_UP: // doesnt seem to do anything
				        {
				        	ButtonNext.setBackgroundResource(R.drawable.next);
	
				        	break;
				        }

			        }
				return true;
				
	        }

		});
	}
	
	/**
	 * 全屏/标准
	 */
	private void ButtonFullStandScreenListener() {
		ButtonFullStandScreen.setOnTouchListener(new OnTouchListener(){
			
			public boolean onTouch(View v, MotionEvent event) 
	        {
				 switch (event.getAction())
			        {
				        case MotionEvent.ACTION_DOWN: // gets called
				        {
				        	ButtonFullStandScreen.setBackgroundResource(R.drawable.fullscreen_press);
				        	MediaControl("StandardScreen");
				        	break;
				        }
				        case MotionEvent.ACTION_UP: // doesnt seem to do anything
				        {
				        	ButtonFullStandScreen.setBackgroundResource(R.drawable.fullscreen);
	
				        	break;
				        }

			        }
				return true;
				
	        }

		});
	}
	
	/**
	 * 倒退
	 */
	private void ButtonFallBackListener() {
		ButtonFallBack.setOnTouchListener(new OnTouchListener(){
			
			public boolean onTouch(View v, MotionEvent event) 
	        {
				 switch (event.getAction())
			        {
				        case MotionEvent.ACTION_DOWN: // gets called
				        {
				        	ButtonFallBack.setBackgroundResource(R.drawable.fallback_press);
				        	MediaControl("FallBack");
				        	break;
				        }
				        case MotionEvent.ACTION_UP: // doesnt seem to do anything
				        {
				        	ButtonFallBack.setBackgroundResource(R.drawable.fallback);
	
				        	break;
				        }

			        }
				return true;
				
	        }

		});
	}
	
	/**
	 * 快进
	 */
	private void ButtonFastForwardListener() {
		ButtonFastForward.setOnTouchListener(new OnTouchListener(){
			
			public boolean onTouch(View v, MotionEvent event) 
	        {
				 switch (event.getAction())
			        {
				        case MotionEvent.ACTION_DOWN: // gets called
				        {
				        	ButtonFastForward.setBackgroundResource(R.drawable.fastforward_press);
				        	MediaControl("FastForward");
				        	break;
				        }
				        case MotionEvent.ACTION_UP: // doesnt seem to do anything
				        {
				        	ButtonFastForward.setBackgroundResource(R.drawable.fastforward);
	
				        	break;
				        }

			        }
				return true;
				
	        }

		});
	}
	
	
	// 音量滑条监听
	public void SetVolumeListener() {
		SeekBarVolumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				// textView.setText("stop");
				textViewVolume.setText("当前音量:" + volume);
				String sendData = "setVolume:"+volume;
				Message.Send(sendData);
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				textViewVolume.setText("调节音量中" + volume);

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				volume = progress;
			}
		});
	}
	
   
    
	/** 媒体控制函数 **/
	public void MediaControl(String commandValue)
	{
		String sendData = "mediaControl:"+commandValue;
		Message.Send(sendData);
	}
	/** 系统控制函数 **/
	public void SystemControl(String commandValue)
	{
		String sendData = "systemControl:"+commandValue;
		Message.Send(sendData);
	}
	
}