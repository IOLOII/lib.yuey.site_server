package yuey.site.Controller.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.Format;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sun.text.resources.FormatData;

import yuey.servlet.OpenidSessionkeyServlet;
import yuey.site.Dao.user.User;
import yuey.site.Service.user.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// try {
		// OpenidSessionkeyServlet.doPost(req,rsp);
		// } catch (ServletException | IOException e) {
		// e.printStackTrace();
		// }
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("user");
		String password = request.getParameter("paw");
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
//		cookie为空的话应该为长时间未登录过期或者，首次登录，那么直接拿到账号密码进行登录。
			
		}

		Cookie cookie = new Cookie("userInfo", userInfo);
//		Cookie cookie2 = new Cookie("userInfo2", "test");
		cookie.setMaxAge(30);
//		cookie2.setMaxAge(60 * 24);
		
//		response.addCookie(cookie2);
		
		HttpSession session = request.getSession();
//		session.setMaxInactiveInterval(30*60*60*24);//session 保存30天
		session.setMaxInactiveInterval(30);
		String sessionID = session.getId();
		System.out.println(sessionID);
		if(session.isNew()){
			System.out.println("new session Comming!");
//			新用户登录授权使用功能；
//			已登录用户直接跳转分派权利
			out.write("new session Comming!");
			request.getRequestDispatcher("testLogin").forward(request,response);
			return "login";

		}else{
			System.out.println("old user");
			out.write("old user");
			return "location";
//			request.getRequestDispatcher("WEB-INF/HTML/location.html").forward(request,response);
		}
//		response.addCookie(cookie);
		

//		return sessionID;
	}
	@RequestMapping("/testLogin")
	public void testLogin(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String sid = request.getParameter("user");
		int id = Integer.parseInt(sid);
		String paw = request.getParameter("paw");
		/*更改返回值为JSONArray*/
		JSONArray jsARR = userService.login(id, paw);
		PrintWriter out = response.getWriter();
		out.write(jsARR.toString());
		out.close();
	}
	@RequestMapping("/loginOut")
	public void loginOut(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		session.invalidate();//注销session
	}

	@Deprecated
	@RequestMapping(value = "/wxLogin", method = RequestMethod.GET)/*微信小程序端登录*/
	 @ResponseBody
	public JSONObject wxLogin(HttpServletRequest request, HttpServletResponse response,@RequestBody String user_id,@RequestBody String user_password) throws ServletException, IOException{
		System.out.println(request.getParameter("user_id"));
//		request.getRequestDispatcher("wxLogin2").forward(request,response);
		wxLogin2(request, response, user_id, user_password);
		return null;
	}
	@RequestMapping(value = "/wxLogin2", method = RequestMethod.POST)/*微信小程序端登录*/
	 @ResponseBody 
	public void wxLogin2(HttpServletRequest request, HttpServletResponse response,@RequestBody String user_id,@RequestBody String user_password) throws IOException{
		PrintWriter out = response.getWriter();
//		User user = new User();
//		String sid = user_id;
//		int id = Integer.parseInt(sid);
//		System.out.println(id);
//		String paw = user_password;
//		System.out.println(paw);
//		System.out.println(user_id);
//		System.out.println(user_password);
		response.setContentType("application/json;charset=UTF-8");
		String suserLogin = user_id+user_password;
		System.out.println(suserLogin);
//		symbol_split.isStr(suserLogin,"'");
		JSONObject userLogin = JSONObject.fromObject(suserLogin);
		System.out.println(userLogin);
		System.out.println("用户访问："+userLogin.get("user_id"));
//		System.out.println("用户密码："+userLogin.get("user_password"));
		String sid = (String) userLogin.get("user_id");
		int id = Integer.parseInt(sid);
		String paw = (String) userLogin.get("user_password");
//		System.out.println("得到的值:"+id+","+paw);
		userService.login(id, paw);
//		System.out.println("用户密码："+userLogin.getJSONObject("user_password"));
//		System.out.println();
		out.write(userService.login(id, paw).toString());
	}

}
