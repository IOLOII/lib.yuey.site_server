package yuey.site.Service.user;

//import java.util.Map;

import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yuey.site.Dao.user.UserDao;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;


	@Override
	public JSONArray login(int id, String paw) {
		return userDao.testsql(id, paw);
	}
}