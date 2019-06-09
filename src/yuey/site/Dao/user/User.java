package yuey.site.Dao.user;

import com.sun.script.javascript.JSAdapter;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class User {
	private int user_id;
	private String user_name;
	private String user_institute;
	private String user_class;
	private int user_grade;
	private String user_password;
	
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_institute() {
		return user_institute;
	}

	public void setUser_institute(String user_institute) {
		this.user_institute = user_institute;
	}

	public String getUser_class() {
		return user_class;
	}

	public void setUser_class(String user_class) {
		this.user_class = user_class;
	}

	public int getUser_grade() {
		return user_grade;
	}

	public void setUser_grade(int user_grade) {
		this.user_grade = user_grade;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}


	
	public JSONObject toString(Boolean loginTF) {
//		JSONArray jsonArr = new JSONArray();
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("login", loginTF);
		jsonObj.put("user_id", user_id);
		jsonObj.put("user_name", user_name);
		jsonObj.put("user_institute", user_institute);
		jsonObj.put("user_class", user_class);
		jsonObj.put("user_grade", user_grade);
//		jsonArr.add(jsonObj);
		return jsonObj;
//		return loginTF+"; "+"UserInfo [user_id=" + user_id + "，user_name=" + user_name +"，user_institute="+user_institute+
//"，user_class="+user_class+"，user_grade="+user_grade+"]";
	}
}
