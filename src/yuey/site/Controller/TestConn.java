package yuey.site.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class TestConn {
	static void test(HttpServletResponse rp) throws IOException{
		PrintWriter pw = rp.getWriter();
		pw.println("test conn");
		pw.close();
		System.out.println("test conn");
	}
}
