package yuey.servlet;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

//import java.io.IOException;
//import java.io.InputStream;
//import java.util.List;
//import java.util.Map;
//import java.util.Scanner;
//import net.sf.json.JSONObject;

public class URLConnection_http_request {
	/**
	 * 向指定URL发送GET方法的请求，请求参数可有可无	 * 
	 * @ url 发送请求的url	 * 
	 * @ param1/2 请求参数,可有可无，格式必须是name1=value1&name2=value2 @ return 请求响应内容
	 */
	public static String result = "";
	public static String getResult() {
		return result;
	}

	public static String sendGet(String url, String param) throws Exception {
		BufferedReader in = null;
		String request = url + "?" + param;
		// 打开和URL之间的连接
		URLConnection connection = new URL(request).openConnection();
		/* begin获取响应码 */
		HttpURLConnection httpUrlConnection = (HttpURLConnection) connection;
		httpUrlConnection.setConnectTimeout(300000);
		httpUrlConnection.setReadTimeout(300000);
		httpUrlConnection.connect();
		in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            String inputLine;
//		System.out.println("in readLine:" + in.readLine() + "\n");
		/*readLine()对数据不能读取多次，程序中每运行一次就是读取一行*/
		result = in.readLine();
		System.out.println("result:" + result + "\n");
		in.close();
		return result;
	}
}
