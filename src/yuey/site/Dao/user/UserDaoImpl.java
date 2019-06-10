package yuey.site.Dao.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
@Repository("userDao")
public class UserDaoImpl extends JdbcDaoSupport implements UserDao{
	class UserRowMapper implements RowMapper<User>{
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setUser_id(rs.getInt("user_id"));
			user.setUser_name(rs.getString("user_name"));
			user.setUser_institute(rs.getString("user_institute"));
			user.setUser_class(rs.getString("user_class"));
			user.setUser_grade(rs.getInt("user_grade"));
			user.setUser_password(rs.getString("user_password"));
			
			return user;
		}	
	}
	@Deprecated
	static Map<String, String> statusmap = new HashMap();
	@Deprecated
	public void checkUserBF(int user_id, String user_password) {
		
		System.out.println("here is userDaoImpl:"+user_id+user_password);
		try {
			String sql = "select * from user_student where user_id = ? and user_password = ?";
			this.getJdbcTemplate().queryForObject(sql, new Object[] {user_id,user_password}, new UserRowMapper());
//			Boolean BF = true;
//			this.setBF2("TRUE");		
			statusmap.put("BF", "登录成功");
//			System.out.println("登录成功");			
//			return BF;
		}catch (Exception e) {
//			Boolean BF = false;
//			this.setBF2("FALSE");
			statusmap.put("BF", "登录失败");
//			System.out.println("用户名或密码错误");
//			return BF;
		}		
	}
	@Deprecated
	public Map<String, String> loginStatus(){
		return statusmap;
	}
	/*先查询账号是否存在，如果有账号，那么一定有密码，再判断密码*/
//	public Boolean isExist(int id){
//		String sql = "select * from user_student where user_id = ? ";
//		String db_password = this.getJdbcTemplate().queryForObject(sql, new Object[] {id}, new UserRowMapper()).;
//		return null;		
//	}
	public Boolean login(int id, String paw) {
//		try {
			String sql = "select * from user_student where user_id = ? ";
			String db_password = this.getJdbcTemplate().queryForObject(sql, new Object[] {id}, new UserRowMapper()).getUser_password();
//			System.out.println("密码1："+paw);
//			System.out.println("密码："+db_password);
//			System.out.println(paw.equals(db_password));
			if(paw.equals(db_password)){
				return true;
			}else{
				return false;
			}
			
//		} catch (Exception e) { 
			//DataAccessException  会报空指针
			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return false;
			//一旦密码不正确，会报错，且无返回值
			//那么前台只能拿到正确密码的返回值，目前通过判断返回值中的login是存在且为true
//		}		
//		try {
//			String sql = "select * from user_library where user_id = ? and user_password = ?";
//			this.getJdbcTemplate().queryForObject(sql, new Object[] {user_id,user_password}, new UserRowMapper());
//		}catch (Exception e) {
//		}	
	}
//	@Test
	public JSONArray testsql(int id, String paw) {
//		Boolean bl = 	this.login(1203210105,"123456");
//		System.out.println(bl.toString());
		
//		this.checkUserBF(1203210105, "123456");
//		Map<String, String> statu = loginStatus();
//		System.out.println(statu.get("BF"));
		
		
//		System.out.println(":"+this.getJdbcTemplate().queryForObject(sql, new Object[] { id, paw}, new UserRowMapper()));
		Boolean login = login(id,paw);
//		System.out.println(login.toString());
		if(login){
			String sql = "select * from user_student where user_id = ?";
			User user = this.getJdbcTemplate().queryForObject(sql, new Object[] {id}, new UserRowMapper());
			return user.toString(login);
		}else{
			JSONArray jsonArr = new JSONArray();
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("login", login);
//			return jsonObj;//返回jsonOBject对象
			return jsonArr;
		}
		
	}
}
