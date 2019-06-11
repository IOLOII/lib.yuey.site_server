package yuey.site.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;
import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import yuey.site.Service.user.UserService;

@Controller
public class testController {
	@Autowired
	UserService userService;

	@RequestMapping("/test")
	public String testConn(HttpServletRequest rq, HttpServletResponse rp)
			throws IOException {
		PrintWriter out = rp.getWriter();
		int id = Integer.parseInt(rq.getParameter("user_id"));
		String paw = rq.getParameter("user_password");
		JSONArray userArr = userService.login(id, paw);
		JSONObject userObj = userArr.getJSONObject(0);
		// System.out.println(userObj.toString());
		boolean loginStatu = userObj.getBoolean("login");
		if (loginStatu) {
			Cookie cookie_id = new Cookie("user_id",
					userObj.getString("user_id"));
			// Cookie cookie_na = new Cookie("user_id",
			// userObj.getString("user_id"));
			Cookie cookie_na = new Cookie("user_name",
					userObj.getString("user_name"));
			cookie_id.setMaxAge(30 * 60 * 60);
			cookie_na.setMaxAge(30 * 60 * 60);
			rp.addCookie(cookie_id); // add 只能传 cookie
			rp.addCookie(cookie_na);
		}
		return testConn2(rq, rp);
	}

	@RequestMapping("/cookie")
	public String testCook(HttpServletRequest rq, HttpServletResponse rp)
			throws IOException {
		rq.setCharacterEncoding("utf-8");
		rp.setContentType("text/html;charset=utf-8");
		boolean flag = false;
		PrintWriter out = rp.getWriter();
		Cookie[] cookies = rq.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				// System.out.println(URLDecoder.decode(cookie.getName(),
				// "utf-8"));
				if (cookie.getName().equals("user_id")) { // 表明已经登陆过了，就直接跳转了
					flag = true;
				}
			}
		}
		if (flag) {
			return testConn2(rq, rp);
		} else {
			out.println("<html>"
					+ "<head><script type='text/javascript'> alert('没有登陆过，请登录!');location='login.html';</script></head>"
					+ "<body></body></html>");
		}
		return null;
	}

	@RequestMapping("/testLoginout")
	public void testLoginout(HttpServletRequest rq, HttpServletResponse rp)
			throws IOException {
		rq.setCharacterEncoding("utf-8");
		rp.setContentType("text/html;charset=utf-8");

		int meth = Integer.parseInt(rq.getParameter("method"));
		Cookie[] cookies = rq.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println(URLDecoder.decode(cookie.getName(), "utf-8"));
                if (URLDecoder.decode(cookie.getName(), "utf-8").equals("username")) { // 表明已经登陆过了，就直接跳转了
                    cookie.setMaxAge(0);
                    rp.addCookie(cookie);
                }
            }
        
		}
	}

	public static String testConn2(HttpServletRequest rq, HttpServletResponse rp)
			throws IOException {
		System.out.println("这是controller才可以调用的方法");
		return "MyHtml";
	}
}
