package client.com.mmptp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.os.Environment;
import android.util.Log;


public class Settings {

		// 创建配置文件
		public static void SetHost(String host) {
			try {

				String name = "mmptp_settings";

				FileOutputStream outStream = new FileOutputStream("/sdcard/" + name
						+ ".txt", false);
				OutputStreamWriter writer = new OutputStreamWriter(outStream,
						"utf-8");

				writer.write(host);
				writer.flush();
				writer.close();

				outStream.close();
			} catch (Exception e) {
				Log.e("m", "file write error");
			}

		}

		// 读取配置文件
		public static String GetHost() 
		{
			
			File sdcard = Environment.getExternalStorageDirectory();

			// 取得文本文件
			File file = new File(sdcard,"mmptp_settings.txt");

			// 存储内容的文本对象
			StringBuilder text = new StringBuilder();
			
			//
			String hostIp = "";
			try {
			    FileInputStream fileIS = new FileInputStream(file);
			    BufferedReader br = new BufferedReader(new InputStreamReader(fileIS));
			    String line;
			    while ((line = br.readLine()) != null) {
			        text.append(line);
			    }
			    hostIp = text.toString();
				//String m [] = host.split(",");
				
				//hostIp =  m[m.length-1];
			    return hostIp;
			}
			catch (IOException e) {
			    // 增加异常处理
			}

			return hostIp;
			
		}

	
}