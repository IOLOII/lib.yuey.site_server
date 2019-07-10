package yuey.site.Controller.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.Format;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

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
import yuey.site.Controller.testController_cookie;
import yuey.site.Dao.user.User;
import yuey.site.Service.user.UserService;
/**
 * function	wxlogin4(微信小程序登录接口)
 * param	user_id,user_password
 * @author yuey
 *
 */
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
		
//		System.out.println(suserLogin);
//		symbol_split.isStr(suserLogin,"'");
		
//		System.out.println(userLogin);
		
//		System.out.println("用户密码："+userLogin.get("user_password"));

//		System.out.println("得到的值:"+id+","+paw);
		
//		System.out.println("用户密码："+userLogin.getJSONObject("user_password"));
//		System.out.println();
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				
				String cookieName = cookie.getName();
				
				String cookieValue = cookie.getValue();
				if(cookieName == "cookie_na"){
					out.write("已登录用户:"+cookieValue+"访问");
				}
				cookieValue = URLDecoder.decode(cookieValue);
				System.out.println("cookieName:" + cookieName+";" + "cookieValue:" + cookieValue);
			}
		}else{
//		cookie为空的话应该为长时间未登录过期或者，首次登录，那么直接拿到账号密码进行登录。
//			跳转登录界面
		}
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(60);
		JSONArray userArr = null;
		
		if (session.isNew()) {
			String suserLogin = user_id+user_password;
			JSONObject userLogin = JSONObject.fromObject(suserLogin);
			String sid = (String) userLogin.get("user_id");
			int id = Integer.parseInt(sid);
			String paw = (String) userLogin.get("user_password");
			
			userArr = userService.login(id, paw);
			JSONObject userObj =userArr.getJSONObject(0);
			String user_na = (String) userObj.get("user_name");
//			String user_id =  (String) userObj.get("user_id"); user_id 传入的值有
			Cookie cookie_na = new Cookie("user_name", user_na);
			cookie_na.setMaxAge(60);
			Cookie cookie_id = new Cookie("user_id", user_id);
			cookie_id.setMaxAge(60);
			response.addCookie(cookie_na);
			response.addCookie(cookie_id);
			System.out.println("新用户访问："+userLogin.get("user_id"));
		} else {
//			out.write("已登录用户:"+cookie_na.getValue()+"访问");
//			跳转登录界面
			testController_cookie.testConn2(request, response);
		}
	}
	User user = new User();
	@RequestMapping(value = "/wxLogin3")//微信小程序端登录 	, method = RequestMethod.POST
//	@ResponseBody 
	public void wxLogin3(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		
		/**
		 * 小程序端请求参数
		 *  data: {
			     user: {
			      user_id: "123",
			      user_password: "456"
			    }
		  	}
		 *	method:POST
		 * return：[{"login":true,"user_id":123,"user_name":"yueytest","user_institute":"信工","user_class":"16富媒体","user_grade":2016}]
		 */
		/*
		String suserLogin = user_id+user_password;
		JSONObject userLogin = JSONObject.fromObject(suserLogin);
		String sid = (String) userLogin.get("user_id");
		int id = Integer.parseInt(sid);
		String paw = (String) userLogin.get("user_password");
		JSONArray userArr = userService.login(id, paw);
		JSONObject userObj =userArr.getJSONObject(0);
		String user_na = (String) userObj.get("user_name");
		System.out.println(userArr);
		out.write(userArr.toString());*/
		
//		String suserLogin = request.getParameter("user_id")+request.getParameter("user_password");
		String sid =request.getParameter("user_id");
				String paw =request.getParameter("user_password");
				System.out.println(sid+paw);
				int id = Integer.parseInt(sid);
		/*String suserLogin = user_id+user_password;
		System.out.println(suserLogin);
		JSONObject userLogin = JSONObject.fromObject(suserLogin);
		String sid = (String) userLogin.get("user_id");
		int id = Integer.parseInt(sid);
		String paw = (String) userLogin.get("user_password");*/
		
		JSONArray userArr = userService.login(id, paw);
		JSONObject userObj = userArr.getJSONObject(0);
		// System.out.println(userObj.toString());
		boolean loginStatu = userObj.getBoolean("login");
		if (loginStatu) {
			// Cookie cookie_na = new Cookie("user_id",
						// userObj.getString("user_id"));
			
//			Cookie cookie_id = new Cookie("user_id",userObj.getString("user_id"));
//			Cookie cookie_na = new Cookie("user_name",userObj.getString("user_name"));

			Cookie cookie_id = new Cookie("user_id",sid);
			Cookie cookie_na = new Cookie("user_name",userObj.getString("user_name"));
			
			cookie_id.setMaxAge(30 * 60 * 60);
			cookie_na.setMaxAge(30 * 60 * 60);
			response.addCookie(cookie_id); // add 只能传 cookie
			response.addCookie(cookie_na);
			out.write(userArr.toString());
			System.out.println("返回值："+userArr.toString());
			System.out.println("返回值："+userArr);
		}
	}
	@RequestMapping("/wxlogin4")
	public void wxlogin4(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String sid =request.getParameter("user_id");
		int id =Integer.parseInt(sid); 
		String paw =request.getParameter("user_password");
		JSONArray userArr = userService.login(id, paw);
		PrintWriter out = response.getWriter();
		out.write(userArr.toString());
	}
}
