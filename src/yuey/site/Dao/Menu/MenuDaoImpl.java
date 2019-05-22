package yuey.site.Dao.Menu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.json.JSONArray;
//@Repository("menuDao")
public class MenuDaoImpl extends JdbcDaoSupport implements MenuDao{
	class MenuListRowmapper implements RowMapper<Menu>{
		@Override
		public Menu mapRow(ResultSet rs, int num) throws SQLException {
			// TODO Auto-generated method stub
			Menu me = new Menu();
			me.setCatalago(rs.getString("catalago"));
			me.setLevel(rs.getString("level"));
			me.setIcon(rs.getString("icon"));
			me.setUrl(rs.getString("url"));
			return me;/*自动生成返回语句，忘记更改返回数据为me*/
		}
		
	}
	
	/**
	 * 按照请求的目录级别进行查询
	 * @return 
	 */
	@Override
	public JSONArray selectList(String level) {
		// TODO Auto-generated method stub
//		String sql = "SELECT * FROM Catalago order by 'level'  DESC ";
		String sql = "SELECT * FROM Catalago where level = ? ";
//		List<Menu> menus = (List<Menu>) this.getJdbcTemplate().queryForObject(sql, new Object[]{level}, new menuListRowmapper());
//		Menu menus2 =(Menu)
//				this.getJdbcTemplate().queryForObject(sql,new menuListRowmapper(), level);
		List<Menu> menus = this.getJdbcTemplate().query(sql,new Object[] {level},new MenuListRowmapper());
		JSONArray json = new JSONArray();
		for (Menu me : menus) {
			JSONObject ijo = new JSONObject();
			ijo.put("catalago", me.getCatalago());
			ijo.put("level", me.getLevel());
			ijo.put("icon", me.getIcon());
			ijo.put("url",me.getUrl());
			json.put(ijo);
		}
//		System.out.println("持久层实现类："+json);
		return json;
	}
}
