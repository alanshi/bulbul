package client.com.mmptp;



import java.text.SimpleDateFormat;

import android.app.Activity; 
import android.content.Intent; 
import android.os.AsyncTask;
import android.os.Bundle; 
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView; 
 
public class MouseEvent extends Activity{ 
	View view1;
	Button btnLeft;
	Button btnMiddle;
	Button btnRight;
	//Button btnReturn;
	private float xHistory;
	private float yHistory;
	private float currentXPosition;
	private float currentYPosition;
	private int screenWidth;
	private int screenHeight;
	private String hostStr;
	private String sendData;
	float cx;
	float cy;
	float x;
    float y;   
    int px;
    int py;
    private Object object;  
    private final int TIME = 20;//备注1  
    @Override 
    public void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.mouseevent); 
        Intent intent=getIntent(); 
        //定义视图
        view1 = (View) findViewById(R.id.view1);
        //定义按钮
        btnLeft = (Button)findViewById(R.id.btnLeft);
        btnMiddle = (Button)findViewById(R.id.btnMiddle);
        btnRight = (Button)findViewById(R.id.btnRight);
        //btnReturn = (Button)findViewById(R.id.btnReturn);
        //定义监听事件
        SetButtonLeftListener();
        SetButtonRightListener();
        SetButtonMiddleListener();
        //SetButtonReturnListener();
        //鼠标移动事件
        initTouchpad();
        //获取屏幕尺寸
        screenWidth = getScreenWidth();
        screenHeight = getScreenHeight();
        object = new Object(); 

        
       
    } 

//    /** 返回键事件监听 **/
// 	public void SetButtonReturnListener() {
// 		btnReturn.setOnClickListener(new View.OnClickListener() {
//
// 			@Override
// 			public void onClick(View arg0) {
// 				// TODO Auto-generated method stub
// 				try {
// 					Intent intent=new Intent(); 
// 		            //
// 		            intent.setClass(MouseEvent.this,MediaControl.class); 
// 		            //
// 		            MouseEvent.this.startActivity(intent);
// 				} catch (Exception e) {
// 					// TODO Auto-generated catch block
// 					e.printStackTrace();
// 				}
// 			}
// 		});
// 	}
    /** 左键事件监听 **/
	public void SetButtonLeftListener() {
		btnLeft.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				try {
					MouseClickControl("Left");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	/** 右键事件监听 **/
	public void SetButtonRightListener() {
		btnRight.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				try {
					MouseClickControl("Right");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	/**中键事件监听**/
	public void SetButtonMiddleListener() {
		btnMiddle.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				try {
					MouseClickControl("Middle");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	/**鼠标点击事件控制**/
	private void MouseClickControl(String key)
	{
		String sendStr = "mouseClick:"+key;
		SnedData task = new SnedData();
		task.execute(sendStr);
	}
	
    //获取屏幕宽度
    private int getScreenWidth()
    {
    	Display display = getWindowManager().getDefaultDisplay();
    	return  display.getWidth();
    }
    //获取屏幕高度
    private int getScreenHeight()
    {
    	Display display = getWindowManager().getDefaultDisplay();
    	return  display.getHeight();
    }
    
    //发送数据
    private class SnedData extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... str) {
			
			
			Message.Send(str[0]);

            return null;
	        	

		}

		@Override
		protected void onPostExecute(String result) {
			//textView.setText(result);
		}
    }
    
	  //执行鼠标移动
    private class DoMouseMove extends AsyncTask<Integer, Void, String> {

		@Override
		protected void onPostExecute(String result) {
			//textView.setText(result);
		}

		@Override
		protected String doInBackground(Integer... params) {
			// TODO Auto-generated method stub
			int x = params[0];
			int y = params[1];
			String sendStr = GetMouseMoveOffset(x,y);	
			SnedData task = new SnedData();
			task.execute(sendStr);
			return null;
		}
    }
    
    //计算鼠标移动移动偏移值
    private String GetMouseMoveOffset(float x,float y)
    {
    	//输出日志
    	//SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss:SS");
    	//Log.v(TAG, "[currTime:"+sdf.format(System.currentTimeMillis())+"]x=" + x+"__y="+y);

    	//计算移动偏移值.
    	
    	
    	
    	if (x<currentXPosition&&y<currentYPosition)
        {
        	//readUrl = "";
        	cx = currentXPosition-x;
        	cy = currentYPosition-y;
        	//readUrl ="http://192.168.100.101:2588/mouseMove:LeftUp-"+cx+"-"+cy;
        	sendData ="mouseMove:LeftUp/"+cx+"/"+cy;

        }
        
        //鼠标左移或者下移
        if (x<currentXPosition&&y>currentYPosition)
        {

        	cx = currentXPosition-x;
        	cy = y-currentYPosition;
        	//readUrl ="http://192.168.100.101:2588/mouseMove:LeftDown-"+cx+"-"+cy;
        	sendData ="mouseMove:LeftDown/"+cx+"/"+cy;
        	//SendDataThread(readUrl);
        }
        //鼠标右移或上移
        if (x>currentXPosition&&y<currentYPosition)
        {

        	cx = x-currentXPosition;
        	cy = currentYPosition-y;
    
        	//readUrl ="http://192.168.100.101:2588/mouseMove:RightUp-"+cx+"-"+cy;
        	sendData ="mouseMove:RightUp/"+cx+"/"+cy;
        	//SendDataThread(readUrl);
        	
        }
        //鼠标右移或下移
        if (x>currentXPosition&&y>currentYPosition)
        {

        	cx = x-currentXPosition;
        	cy = y-currentYPosition;
        	
        	//readUrl ="http://192.168.100.101:2588/mouseMove:RightDown-"+cx+"-"+cy;
        	sendData ="mouseMove:RightDown/"+cx+"/"+cy;
        	//SendDataThread(readUrl);
        }
        
        return sendData;
        
    }
    
    //初始化鼠标移动事件监听
	private void initTouchpad() {
		
		view1 = (View) this.findViewById(R.id.view1);
		// let's set up a touch listener
		view1.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent ev) {
				return onMouseMove(ev);
			}
		});
	}
	

	
    //鼠标移动事件
    private boolean onMouseMove(MotionEvent ev) {
    	int type = 0;
		float xMove = 0f;
		float yMove = 0f;

		int pointerCount = 1;


		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			xMove = 0;
			yMove = 0;
			this.xHistory = ev.getX();
			this.yHistory = ev.getY();
			break;
		case MotionEvent.ACTION_UP:
			xMove = 0;
			yMove = 0;
			break;
		case MotionEvent.ACTION_MOVE:
			
            
            xMove = ev.getX() - this.xHistory;
			yMove = ev.getY() - this.yHistory;
			px = (int)xMove;
            py = (int)yMove;
			this.xHistory = ev.getX();
			this.yHistory = ev.getY();
            DoMouseMove dmm =  new DoMouseMove();
            dmm.execute(px,py);
			break;		
		}
        synchronized (object) {//备注2  
            try {  
                object.wait(TIME);  
            } catch (InterruptedException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        } 
		return true;
    }
} 