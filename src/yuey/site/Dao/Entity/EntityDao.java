package yuey.site.Dao.entity;

import java.util.List;

import org.json.JSONArray;

public interface EntityDao {
	JSONArray testtoString();
	void addJobList(String title, String content, String extral, String timeLiness);
	void addJobList (Entity e);
}
