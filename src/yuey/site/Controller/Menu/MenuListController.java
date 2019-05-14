package yuey.site.Controller.Menu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import yuey.site.Service.Menu.MenuServiceImpl;

@Controller
public class MenuListController {
	@Autowired
	private MenuServiceImpl menuService;
	@RequestMapping("/menu")
	public void getMenuList(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setHeader("content-type", "text/html;charset=UTF-8");
//		menuService.selectList(Integer.parseInt(request.getParameter("level"))); /*变为整型*/
		menuService.selectList(request.getParameter("level"));
		System.out.println("请求来了");
		PrintWriter pw = response.getWriter();
		pw.println();
	}
}
