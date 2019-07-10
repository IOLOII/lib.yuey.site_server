package cla;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class Connectable {
	public static boolean isHostConnectable(String host, int port) {
		Socket socket = new Socket();
		try {
			socket.connect(new InetSocketAddress(host, port));
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("success");
		return true;
	}

	@Deprecated
	static void isHostConn(String host) {
		Socket socket = new Socket();
		int[] port={8090,80,2567,8080,8090,4467,5946};
		for (int p : port) {
			try {
				socket.connect(new InetSocketAddress(host, p));
				System.out.println("连接成功： " + host + "： " + p);
//				socket.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("连接失败： " + host + "： " + p);
				// return false;
			} 
		}
	}
}
