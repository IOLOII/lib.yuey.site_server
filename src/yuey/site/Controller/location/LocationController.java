package yuey.site.Controller.location;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LocationController {
	@RequestMapping("/location")
	public String getLocation() {
		// TODO Auto-generated method stub
		return "location";
	}
}
