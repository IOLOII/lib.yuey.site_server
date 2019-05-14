package yuey.site.Service.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import yuey.site.Dao.Menu.MenuDao;

@Service("menuService")
public class MenuServiceImpl implements MenuService{
	@Autowired
	private MenuDao menuDao;
	
	@Override
	public void selectList(String level) {
		// TODO Auto-generated method stub
		menuDao.selectList(level);
	}

}
