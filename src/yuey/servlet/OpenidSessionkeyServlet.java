package yuey.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import yuey.newPro.URLConnection_http_request;
//@WebServlet("/OpenidSessionkeyServlet")
public class OpenidSessionkeyServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	public static void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String code = request.getParameter("code");
		/* out.write("获取Sessionkey与openid"); */
		try {
			URLConnection_http_request
					.sendGet(
							"https://api.weixin.qq.com/sns/jscode2session",
							"appid=wx7f6934cacff583c0&secret=73e353cb3c9ffeae8b402e84a68a8d84&grant_type=authorization_code&js_code="
									+ code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.write(URLConnection_http_request.getResult());

		out.flush();
		out.close();

	}


}
