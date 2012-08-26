package client.com.mmptp;

import android.app.Activity;

public class Message{ 

	//发送消息
    public static void Send(String sendData)
    {
    	try 
		{
    		String host;
    		host = Settings.GetHost();
			UDPClient udpClient = new UDPClient();
    		udpClient.Init(host, 2588);
			udpClient.send(sendData);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}