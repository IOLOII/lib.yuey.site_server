package yuey.site.Service;

import java.util.List;

import org.json.JSONArray;

import yuey.site.Dao.Entity;

public interface EntityService {
	JSONArray testtoString();
	void addJobList(String title, String content, String extral, String timeliness);
	void addJobList(Entity e);
}
