package yuey.site.Dao.Menu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

//@Repository("menuDao")
public class MenuDaoImpl extends JdbcDaoSupport implements MenuDao{
	class menuListRowmapper implements RowMapper<Menu>{
		@Override
		public Menu mapRow(ResultSet rs, int num) throws SQLException {
			// TODO Auto-generated method stub
			Menu me = new Menu();
			me.setCatalago(rs.getString("catalago"));
			me.setLevel(rs.getString("level"));
			return null;
		}
		
	}
	
	/**
	 * 按照请求的目录级别进行查询
	 */
	@Override
	public void selectList(String level) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Catalago where level = '1' ;";
		List<Menu> menus = (List<Menu>) this.getJdbcTemplate().queryForObject(sql, new Object[]{level}, new menuListRowmapper());
		for(Menu menu : menus){
			System.out.println(menu);
		}
	}

}
