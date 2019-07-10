package yuey.site.Controller.job;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import yuey.site.Controller.TestConn;
import yuey.site.Dao.entity.Entity;
import yuey.site.Service.entity.EntityService;
import yuey.site.Service.menu.MenuService;
import yuey.site.Service.menu.MenuServiceImpl;
/**
 * 兼职发布功能controller
 * @author yuey
 *
 */
@Controller
// @RequestMapping("getC")
public class JobIndexController {
	@Autowired
	private EntityService entityService;

	/**
	 * 获取兼职信息条目
	 * param request	getC.site
	 * param response	entity实例
	 * 
	 */
	@RequestMapping("/getC")
	public void getConn(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// List<Entity> entity = null;
		// entity = entityService.testtoString();
		response.setHeader("content-type", "text/html;charset=UTF-8");
		Map<String, Object> req = new HashMap<String, Object>();
		req.put("请求rul", request.getReader());
		req.put("ip", request.getLocalAddr());
		JSONArray entity = new JSONArray();
		entity = entityService.testtoString();

		System.out.println(req + "sql Success!");
		// System.out.println(entity.toString());
		PrintWriter pw = response.getWriter();
		// OutputStream outputStream = response.getOutputStream();
		// response.setHeader("content-type", "text/html;charset=UTF-8");
		pw.write(entity.toString());
//		pw.write(entity);
		// return entity;
	}
	/**
	 * 增加兼职 5_14
	 * param request	pubUnit,pubContent,salary,pubTime,timeLiness
	 * param response
	 * 
	 */
	@RequestMapping(value = "/addJob")
	public void addJobLIst2(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
//		request.setCharacterEncoding("UTF-8");
		Entity e = new Entity();
		e.setPubUnit(request.getParameter("pubUnit"));
		String pubUnit=new String(e.getPubUnit().getBytes("ISO-8859-1"),"utf-8");
		e.setPubUnit(pubUnit);
		
		e.setPubContent(request.getParameter("pubContent"));
		String pubContent=new String(e.getPubContent().getBytes("ISO-8859-1"),"utf-8");
		e.setPubContent(pubContent);
		
		e.setSalary(request.getParameter("salary"));
		String salary=new String(e.getSalary().getBytes("ISO-8859-1"),"utf-8");
		e.setSalary(salary);
		
		e.setPubTime(request.getParameter("pubTime"));
		String pubTime=new String(e.getPubTime().getBytes("ISO-8859-1"),"utf-8");
		e.setPubTime(pubTime);
		
		e.setTimeLiness(request.getParameter("timeLiness"));
		String timeLiness=new String(e.getTimeLiness().getBytes("ISO-8859-1"),"utf-8");
		e.setTimeLiness(timeLiness);
		/*存入截止时间的话，怎样将解决？ 1、截止日期固定，先写入 2、是否过期无效：数据取出的时候判断，现在更改数据库中timeLiness为String*/
		entityService.addJobList(e);/*问题：解决写入日期 中文 符号*/
		
		System.out.println("resquest coming!");
//		System.out.println("methoud 2----------------------------------");
//		Enumeration pNames = request.getParameterNames();
//		while (pNames.hasMoreElements()) {
//			String name = (String) pNames.nextElement();
//			String value = request.getParameter(name);
//			System.out.print(name + "=" + value);
//		}
	}
	@RequestMapping(value = "/addJob", method = RequestMethod.POST)
	public void addJobLIst(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String pubUnit = request.getParameter("pubUnit");
		System.out.println(pubUnit);
		System.out.println("methoud 2----------------------------------");
		Enumeration pNames = request.getParameterNames();
		while (pNames.hasMoreElements()) {
			String name = (String) pNames.nextElement();
			String value = request.getParameter(name);
			System.out.print(name + "=" + value);
		}
		
		/**
		 * 处理前台post请求：{"pubUnit":"www","pubContent":"qqq","salary":"eee","timeLiness":"2019-04-27","pubTime":"2019-04-27 22:3:46"}
		 */
					System.out.println("methoud 3----------------------------------");
					StringBuilder sb = new StringBuilder();
					try (BufferedReader reader = request.getReader();) {
						char[] buff = new char[1024];
						int len;
						while ((len = reader.read(buff)) != -1) {
							sb.append(buff, 0, len);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					// return sb.toString();
					System.out.println(sb.toString());
	}
//	static void test(HttpServletResponse rp) throws IOException{
//		PrintWriter pw = rp.getWriter();
//		pw.write("test conn");
//	}
}
