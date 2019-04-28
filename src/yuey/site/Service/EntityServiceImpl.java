package yuey.site.Service;

import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yuey.site.Dao.Entity;
import yuey.site.Dao.EntityDao;

@Service("entityService")
public class EntityServiceImpl implements EntityService {
	@Autowired
	private EntityDao entityDao;

	public JSONArray testtoString() {
		return entityDao.testtoString();
	}

	public void addJobList(String title, String content, String extral, String timeliness) {
		// TODO Auto-generated method stub
		entityDao.addJobList(title, content, extral, timeliness);
	}

	public void addJobList(Entity e) {
		// TODO Auto-generated method stub
		entityDao.addJobList(e);
	}

}
