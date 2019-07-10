package yuey.site.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class TestConn {
	@RequestMapping(value="testconn",method = RequestMethod.POST)
	@SuppressWarnings("unchecked")
	public static void getTest(HttpServletRequest request,HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		Enumeration<String> paraNames=request.getParameterNames();
		
		pw.println("<div><h1>here is test conn result:</h1></ br>");
		System.out.println("----------------------------------------------------------------------");
		for(Enumeration<String> e=paraNames;e.hasMoreElements();){
		      String thisName=e.nextElement().toString();
		      String thisValue=request.getParameter(thisName);
		      pw.println("|"+"&nbsp;"+"&nbsp;"+"param_key:"+thisName+"--------------value:  "+thisValue);
		      pw.println("<br />");
		      System.out.println("param_key:"+thisName+"--------------value:  "+thisValue);
		}
		//获取所有的头部参数
		Enumeration<String> headerNames=request.getHeaderNames();
		for(Enumeration<String> e=headerNames;e.hasMoreElements();){
		      String thisName=e.nextElement().toString();
		      String thisValue=request.getHeader(thisName);
		      pw.println("|"+"&nbsp;"+"&nbsp;"+"header_key:"+thisName+"--------------value:  "+thisValue);
		      pw.println("<br />");
		      
		      System.out.println("header_key:"+thisName+"--------------value:  "+thisValue);
		}
		pw.println("-------------------------------------------------------------------------------------------------------");
		pw.println("</div>");
		System.out.println("----------------------------------------------------------------------");
		pw.close();
	}
	
	@RequestMapping(value="testconn",method = RequestMethod.GET)
	public static void postTest(HttpServletRequest request,HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write("服务器功能代码维护中");
		pw.close();	
		TestConn.getTest(request, response);
	}
}
