package client.com.mmptp;

import java.io.DataInputStream;
import java.net.*;

/**
 * @author Administrator
 *
 */
public class UDPClient {
	//定义发送接收数据字节数组
	byte[] sendData = new byte[256];
	byte[] receiveData = new byte[1024]; 
	//定义主机地址和端口地址
	String host = null;
	int port;
	//申明DatagramSocket对象
	DatagramSocket clientSocket;
	
	/*接受数据*/
	public boolean receive() throws Exception
    {	
		
		//创建接收数据packet
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 
		//接受数据
		clientSocket.receive(receivePacket); 
		String modifiedSentence =  new String(receivePacket.getData()); 
		//打印接受数据 
        //System.out.println("接受数据: " + modifiedSentence); 
		return true;
	
    }
	/*发送数据*/
	public boolean send(String buffer) throws Exception
    {
		
		//构建发送数据buff
		sendData = buffer.getBytes();
		//远程主机转换为address对象
		InetAddress address = InetAddress.getByName(host);
		//创建发送数据Packet
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, 
		                                           address, port);
		//发送数据
		clientSocket.send(sendPacket);
		//System.out.println("发送数据: " + buffer); 
		return true;
	
    }
	
	/*初始化创建DatagramSocket对象*/
	public boolean Init(String hostStr,int portStr)
	{
		try {
			//创建DatagramSocket
			clientSocket = new DatagramSocket();
			//设置主机地址和端口地址
			host = hostStr;
			port = portStr;
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	/*主函数*/
	public static void main(String[] args) throws Exception {
		
			System.out.println("server start......");
			UDPClient u = new UDPClient();
			u.Init("192.168.100.101",2588);
			u.send("conn:1");
			u.clientSocket.setSoTimeout(1000);
			u.receive();
			System.out.println("server end......");
			
	}
}