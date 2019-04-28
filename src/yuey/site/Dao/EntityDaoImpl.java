package yuey.site.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;

import net.sf.json.JSONObject;

import org.json.JSONArray;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * jdk 1.7 spring 3.1
 * 
 * @author yuey
 * 
 */
@Repository("entityDao")
public class EntityDaoImpl extends JdbcDaoSupport implements EntityDao {
	class EntityRowMapper implements RowMapper<Entity> {
		public Entity mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Entity entity = new Entity();
			entity.setPubUnit(rs.getString("pubUnit"));
			entity.setPubTime(rs.getString("pubTime"));
			entity.setPubContent(rs.getString("pubContent"));
			entity.setSalary(rs.getString("salary"));
			entity.setTimeLiness(rs.getString("timeLiness"));
			return entity;
		}
	}

	public JSONArray testtoString() {
		List<Entity> entity = null;
		JSONArray json = new JSONArray();
		String sql = "select * from parttimejob order by`pubTime` DESC ";/*
																	 * order by
																	 * `时效性`
																	 * DESC
																	 * ,`发布时间`
																	 */
		try {
			// TODO Auto-generated method stub
			entity = this.getJdbcTemplate().query(sql, new EntityRowMapper());
			// System.out.println("sql success"+"\n"+entity);
			/*
			 * 集合转json JsonObject 对象放入的是键值对 JsonArray 放入的是一个值
			 */
			for (Entity et : entity) {
				JSONObject ijo = new JSONObject();
				// ijo.put("发布单位", et.getPubUnit());
				// ijo.put("发布时间", et.getPubTime());
				// ijo.put("发布内容", et.getPubContent());
				// ijo.put("资薪", et.getSalary());
				// ijo.put("时效性", et.isTimeliness());

				ijo.put("pubUnit", et.getPubUnit());
				ijo.put("pubContent", et.getPubContent());
				ijo.put("salary", et.getSalary());
				ijo.put("pubTime", et.getPubTime());
				ijo.put("timeLiness", et.getTimeLiness());
				json.put(ijo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("sql fail" + sql + "\n" + e);
		}
		return json;
	}
	@Deprecated
	public void addJobList(String pubUnit, String pubContent, String pubTime, String date) {
//		放进去的时间没有进行修改，拿出数据的时候进行判断时间的时效性 或者在数据库中自行判断（每日判断一次）
		String sql = "insert into parttimejob(pubUnit,pubContent)values(?,?)";
		try {
			this.getJdbcTemplate().update(sql, pubUnit ,pubContent);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sql error!");
			System.out.println(sql);
		}
	}
	public void addJobList (Entity e){
		String sql = "insert into parttimejob(pubUnit,pubContent,pubTime,timeLiness,salary)values(?,?,?,?,?)";
//		String sql = "insert into parttimejob (pubUnit,pubContent,pubTime,timeLiness) values(?,?,?,?)";
		try {
//			this.getJdbcTemplate().update(sql, e.pubUnit ,e.pubContent,e.pubTime,e.timeLiness);
			this.getJdbcTemplate().update(sql, e.pubUnit ,e.pubContent,e.pubTime,e.timeLiness,e.salary);
			System.out.println("sql success!");
			System.out.println(sql);
		} catch (DataAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("sql error!");
			System.out.println(sql);
		}
	}

}
