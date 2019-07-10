package yuey.site.Controller.location;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;

import yuey.servlet.URLConnection_http_request;
import yuey.site.Controller.TestConn;

/**
 * function location(返回地图页面的接口) function checkLocation(打卡校验的接口) param loc
 * 
 * @author yuey
 * 
 */
@Controller
public class LocationController {
	@RequestMapping("/location")
	public String getLocation() {
		// TODO Auto-generated method stub
		return "location";
	}

	@Test
	@RequestMapping(value = "checkLocation", method = RequestMethod.POST)
	public void checkLocation(/*
							 * HttpServletRequest request,HttpServletResponse
							 * response
							 */) throws Exception {
		String key = "key=5cb4f298bd87f8a5b9da3f6f80a96a9f&diu=863081030701227&locations=";
		String location = "113.30945,22.904906,1559577106";
		// String loc = request.getParameter("locations");
		String url = "https://restapi.amap.com/v4/geofence/status";
		URLConnection_http_request.sendGet(url, key + location);
		System.out.println(URLConnection_http_request.getResult());
		JSONObject fencingReq = (JSONObject) JSONObject
				.parseObject(URLConnection_http_request.getResult());
		System.out.println(fencingReq.getString("data"));
		JSONObject fencingInfo = (JSONObject) JSONObject.parseObject(fencingReq
				.getString("data"));
		int sta = Integer.parseInt(fencingInfo.getString("status"));
		if (sta == 0) {// 是否请求成功
			JSONArray mapEvent = JSONArray.fromObject(fencingInfo
					.getString("fencing_event_list"));// 获取围栏事件信息
			if (mapEvent.size()>0) {
				 System.out.println("mapEvent不为空"+ mapEvent.toString());
					 Iterator it  = mapEvent.iterator();
					 while (it.hasNext()) {
						 JSONObject jsonobj = JSONObject.parseObject((String) it.next());
								 System.out.println(jsonobj.getString("fence_info"));
					}
					 JSONObject jsonobj = JSONObject.parseObject((String) it.next());
					 System.out.println(jsonobj.getString("fence_info"));
			}
//			[
//			 	{
//			 		"client_action":"enter",
//					"client_status":"in",
//					"fence_info":{"fence_name":"图书馆","fence_center":"113.30949,22.904469","fence_gid":"4b625735-9bcd-4c93-ba59-02bd1f5d8529"},
//					"enter_time":"2019-06-03 23:51:46"
//				}
//			];	//数组里面就一个json对象

		} else {
			System.out.println(fencingInfo.getString("status"));
		}

	}

	@RequestMapping(value = "checkLocation", method = RequestMethod.GET)
	public void checkLocationUp(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		TestConn.postTest(request, response);
	}
}
