package yuey.site.Service.user;

import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public interface UserService {
	JSONArray login(int id,String paw);
}
