import org.junit.Test;
import org.springframework.test.context.TestExecutionListeners;

import yuey.isHostConnectable;


public class TestConn {
//	@TestExecutionListeners
	@Test
	public void test() {
		// TODO Auto-generated method stub
		String host="www.baidu.com";
		int[] a={8090,80,2567,8080,8090,4467,5946};
//		Connectable.isHostConn(host);
		
		int port = 80;
		for (int i : a) {
			System.out.println(i);
//			Connectable.isHostConnectable(host, i);
		}
		HostReachable.isHostReachable(host, 600);
		//		Connectable.isHostConnectable(host, port);
	}
}
