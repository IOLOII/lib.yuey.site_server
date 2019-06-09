package yuey.site.Controller.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yuey.servlet.OpenidSessionkeyServlet;
import yuey.site.Service.user.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public static void login(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// try {
		// OpenidSessionkeyServlet.doPost(req,rsp);
		// } catch (ServletException | IOException e) {
		// e.printStackTrace();
		// }
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String username = "tom";
		String password = "123";
		String userInfo = username + ";" + password;
		userInfo = URLEncoder.encode(userInfo);

		// 1、先获取cookie的值，不然回报空指针，以及cookie存在各自的servlet中(设值和获取 应放在同一个servlet中)
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				String key = cookie.getName();
				String value = cookie.getValue();
				value = URLDecoder.decode(value);
				System.out.println("key:" + key+";" + "value:" + value);
			}
		}else{
//		cookie为空的话应该为长时间未登录或者，首次登录，那么直接拿到账号密码进行登录。
			
		}

		Cookie cookie = new Cookie("userInfo", userInfo);
		Cookie cookie2 = new Cookie("userInfo2", "test");
		cookie.setMaxAge(60 * 60 * 24);
		cookie2.setMaxAge(60 * 24);
		response.addCookie(cookie);
		response.addCookie(cookie2);
		
		request.getSession();

	}
	@RequestMapping("/testLogin")
	public void testLogin(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String sid = request.getParameter("user");
		int id = Integer.parseInt(sid);
		String paw = request.getParameter("paw");
		JSONObject jsOBJ = userService.login(id, paw);
		PrintWriter out = response.getWriter();
		out.write(jsOBJ.toString());
		out.close();
	}
}
