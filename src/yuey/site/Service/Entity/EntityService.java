package yuey.site.Service.entity;

import java.util.List;

import org.json.JSONArray;

import yuey.site.Dao.entity.Entity;

public interface EntityService {
	JSONArray testtoString();
	void addJobList(String title, String content, String extral, String timeliness);
	void addJobList(Entity e);
}
