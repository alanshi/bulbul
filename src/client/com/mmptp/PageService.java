package client.com.mmptp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 读取URL的文本
 * 
 * 
 */
public class PageService {
    /**
     * 读取文本。默认使用UTF-8编码
     * 
     * @param page
     *            页面的URL,比如 http://www.java2000.net
     * @return 读取到的文本字符串
     */
    public static String getPage(String page) {
        return getPage(page, "UTF-8");
    }

    /**
     * 读取文本
     * 
     * @param page
     *            页面的URL,比如 http://www.java2000.net
     * @param charset
     *            页面的编码
     * @return 读取到的文本字符串
     */
    public static String getPage(String page, String charset) {
        String str = null;
        str = _getPage(page, charset);
        return str;
        /*
        int count = 0;
        do {
            str = _getPage(page, charset);
            if (str == null || str.length() == 0) {
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } while (str == null && count-- > 0);
        */
        
    }

    private static String _getPage(String page, String charset) {
        try {
            URL url = new URL(page);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    con.getInputStream(), charset));
            StringBuilder b = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                b.append(line);
                // b.append("\r\n"); // 默认这里没有保存换行，而是让所有的字符出现在一行里面。如果需要，请去掉前面的注释
            }
            return b.toString();
        } catch (FileNotFoundException ex) {
            System.out.println("NOT FOUND:" + page);
            return null;
        } catch (ConnectException ex) {
            System.out.println("Timeout:" + page);
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}