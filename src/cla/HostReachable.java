package cla;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class HostReachable {
	public static boolean isHostReachable(String host, Integer timeOut) {
        try {
        	System.out.println("success");
            return InetAddress.getByName(host).isReachable(timeOut);
            
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
