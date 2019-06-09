package yuey.site.Dao.user;

import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public interface UserDao {
	@Deprecated
	void checkUserBF(int user_id, String user_password) ;//抽象方法
	@Deprecated
	Map<String,String> loginStatus();
	
	Boolean login(int id,String paw);//登录
	JSONObject testsql(int id, String paw);
}
 