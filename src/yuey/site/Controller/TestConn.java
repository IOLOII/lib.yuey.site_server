package yuey.site.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestConn {
	@SuppressWarnings("unchecked")
	public static void test(HttpServletRequest request,HttpServletResponse rp) throws IOException{
		request.setCharacterEncoding("UTF-8");
		rp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = rp.getWriter();
		Enumeration<String> paraNames=request.getParameterNames();
		pw.println("<div><h1>here is test conn result:</h1></ br>");
		for(Enumeration<String> e=paraNames;e.hasMoreElements();){
		      String thisName=e.nextElement().toString();
		      String thisValue=request.getParameter(thisName);
		      pw.println("param_key:"+thisName+"--------------value:  "+thisValue);
		      pw.println("<br />");
		}
		//获取所有的头部参数
		Enumeration<String> headerNames=request.getHeaderNames();
		for(Enumeration<String> e=headerNames;e.hasMoreElements();){
		      String thisName=e.nextElement().toString();
		      String thisValue=request.getHeader(thisName);
		      pw.println("header_key:"+thisName+"--------------value:  "+thisValue);
		      pw.println("<br />");
		}
		pw.println("</div>");
		pw.close();
	}
}
