package yuey.site.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

//@Repository("menuDao")
public class MenuDaoImpl extends JdbcDaoSupport implements MenuDao{
	class menuListRowmapper implements RowMapper<Menu>{

		@Override
		public Menu mapRow(ResultSet arg0, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

	@Override
	public void selectList(int level) {
		// TODO Auto-generated method stub
		System.out.println("这里是menuDaoimpl"+level);
	}

}
