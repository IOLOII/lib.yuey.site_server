package yuey.site.Dao;

public class Menu {
	String catalago;
	int level;
	String icon;
	public String getCatalago() {
		return catalago;
	}
	public void setCatalago(String catalago) {
		this.catalago = catalago;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return icon + catalago + level;
	}
}
	
