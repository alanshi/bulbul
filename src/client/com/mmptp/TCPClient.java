package client.com.mmptp;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import java.io.*;

import java.net.*;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * TCP Socket Implementation
 */
public class TCPClient
{
		private Socket socket = null;
		
		
		public TCPClient(String host) {
			
			try {
				socket = new Socket(host, 9999);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//音量控制
		public void TestSoundControl(int value) throws Exception
		{
			 //Socket socket = new Socket(host, 9999);
             DataInputStream is = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
             DataOutputStream os = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

             // Create Client Request
             String request = "sound:"+value;

             // Send Client Request to Server
             send(os, request.getBytes());
             System.out.println(request);
		}
		//创建连接
		public String conn(String host){

			String responseData = "connect success!!!";
			try {
					DataInputStream is = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		            DataOutputStream os = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
		            String request = "conn:"+"1";
		            send(os, request.getBytes());
		            //byte[] byteData = receive(is);
		            //responseData = new String(byteData);
		            //String receiveString = send(os, request.getBytes());
		            return responseData;
		            
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return responseData;
		}
		
		//按键控制
		public void KeysControl(String keys) throws Exception
		{
			 //Socket socket = new Socket(host, 9999);
             DataInputStream is = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
             DataOutputStream os = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
             //发送数据
             send(os, keys.getBytes());
		}
		/*
        public static void main(String[] args) throws Exception
        {
        		
                System.out.println("Client Started...");

                Socket socket = new Socket("192.168.100.101", 9999);
                DataInputStream is = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream os = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

                // Create Client Request
                String request = "sound:0";

                // Send Client Request to Server
                send(os, request.getBytes());
                System.out.println(request);

                try
                {
                        while (true)
                        {
                                // Receive Server Response
                                byte[] byteData = receive(is);
                                String responseData = new String(byteData);
                                System.out.println("Server Response = " + responseData.trim());
                        }
                }
                catch (Exception e)
                {
                        System.out.println("Exception: " + e.getMessage());
                
        }
        }*/
        /**
         * Method receives the Server Response
         */
        public static byte[] receive(DataInputStream is) throws Exception
        {
                try
                {
                        byte[] inputData = new byte[1024];
                        is.read(inputData);
                        return inputData;
                }
                catch (Exception exception)
                {
                        throw exception;
                }
        }

        /**
         * Method used to Send Request to Server
         */
        public static void send(DataOutputStream os, byte[] byteData) throws Exception
        {
                try
                {
                        os.write(byteData);
                        os.flush();
                }
                catch (Exception exception)
                {
                        throw exception;
                }
        }

}