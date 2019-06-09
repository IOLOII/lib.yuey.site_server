package yuey.site.Dao.menu;

import org.json.JSONArray;

public interface MenuDao {
	JSONArray selectList(String level);
}
