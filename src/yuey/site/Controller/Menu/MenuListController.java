 package yuey.site.Controller.menu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import net.sf.json.JSONArray;
import org.json.JSONArray;
/**
 * net.sf.json
 * org.json
 * 的区别
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import yuey.site.Service.menu.MenuServiceImpl;

@Controller
public class MenuListController {
	@Autowired
	private MenuServiceImpl menuService;
	@RequestMapping("/menu")
	public void getMenuList(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setHeader("content-type", "text/html;charset=UTF-8");
//		menuService.selectList(Integer.parseInt(request.getParameter("level"))); /*变为整型*/
		String level = request.getParameter("level");
		PrintWriter pw = response.getWriter();	
		if (level == null) {
			pw.println("请携带参数level");
		} else {
			JSONArray me = new JSONArray();
			me =  menuService.selectList(level);
//			pw.write("返回的结果3："+me.toString());
//			pw.println("返回的结果1："+"\n"+me.toString());
//			pw.println("返回的结果2："+"\n"+me);
			pw.println(me);
//			return menuService.selectList(level) ;
		}
	}
	
	@RequestMapping("/testPage")
	public String testPage(HttpServletRequest req,HttpServletResponse rsp){
		return "testPage";
	}
	@RequestMapping("/testPage2")
	public String testPage2(HttpServletRequest req,HttpServletResponse rsp){
		return "MyJsp";
	}
}
