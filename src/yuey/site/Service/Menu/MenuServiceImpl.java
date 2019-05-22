package yuey.site.Service.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yuey.site.Dao.Menu.MenuDao;
import org.json.JSONArray;
@Service("menuService")
public class MenuServiceImpl implements MenuService{
	@Autowired
	private MenuDao menuDao;
	
	@Override
	public JSONArray selectList(String level) {
		// TODO Auto-generated method stub
		
		/*需要处理传入参数level的有效性*/
		return menuDao.selectList(level);
	}

}
