package client.com.mmptp;

import java.net.Socket;
import java.util.Properties;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Connect extends Activity {
    /** Called when the activity is first created. */
	private TextView  textViewConnectState;
	private String connectState;
	private EditText  ipAddress;
	private Button buttonConnect;

	private String host;;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connect);
        
        textViewConnectState = (TextView) findViewById(R.id.textViewConnectState);
        ipAddress = (EditText) findViewById(R.id.ipAddress);
        buttonConnect = (Button) findViewById(R.id.buttonConnect);
        
        //连接状态文字初始化
        textViewConnectState.setText("");
        //连接按钮监听
        SetButtonConnectListener();
        //设置初始IP地址--便于开发
        ipAddress.setText("192.168.100.101");
 
    }
    /**
     * 用Handler来更新UI
     */
     private Handler handler = new Handler(){
    
		  @Override
		  public void handleMessage(Message msg) {
			textViewConnectState.setText("连接成功!");
		  }
     };
    
    //连接按钮监听
    public void SetButtonConnectListener()
    {
    	buttonConnect.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				host = ipAddress.getText().toString();
				//设置IP地址
				Settings.SetHost(host);
				Message message =  new Message();
				//发送消息
				String sendData = "conn:1";

			}  
    		
    	}); 
    }
    
    public void ChaeckConnectState()
    {
    	
    	// 新建线程
		new Thread() {

			@Override
			public void run() {
				// 向handler发消息
				handler.sendEmptyMessage(0);
			}
		}.start();
    }
 

	/** 显示触发事件的信息  **/
	public void ShowMessage(String str) {
		Toast toast = Toast.makeText(this, str, Toast.LENGTH_SHORT);
		toast.show();
	}
	
	
}