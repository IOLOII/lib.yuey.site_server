package yuey.site.Dao.root;

/*
 * 抽象用户类，为了今后对用户级别区分
 * student,teacher,admin.admin
 */
public abstract class root {
	
//	访问数据库能力
	public abstract void DB();
	
//	后台操作
	public abstract void serv();
	

}
