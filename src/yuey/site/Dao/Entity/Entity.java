package yuey.site.Dao.Entity;

public class Entity {
	String pubUnit;
	String pubTime;
	String pubContent;
	String salary;
	String timeLiness;
	public String getPubUnit() {
		return pubUnit;
	}
	public void setPubUnit(String pubUnit) {
		this.pubUnit = pubUnit;
	}
	public String getPubTime() {
		return pubTime;
	}
	public void setPubTime(String pubTime) {
		this.pubTime = pubTime;
	}
	public String getPubContent() {
		return pubContent;
	}
	public void setPubContent(String pubContent) {
		this.pubContent = pubContent;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getTimeLiness() {
		return timeLiness;
	}
	public void setTimeLiness(String timeLiness) {
		this.timeLiness = timeLiness;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return pubUnit+"\n"+pubTime+"\n"+pubContent+"\n"+salary+"\n";
	}
}
