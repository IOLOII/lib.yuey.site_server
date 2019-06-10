package yuey.site.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {
	@RequestMapping("/test")
	public void testConn(HttpServletRequest rq,HttpServletResponse rp) throws IOException{
//		PrintWriter pw = rp.getWriter();
//		pw.write("test conn");
//		test(rp);
		TestConn.test(rq,rp);
//		Test t = new Test();
//		t.test2(rp);		
	}
}
