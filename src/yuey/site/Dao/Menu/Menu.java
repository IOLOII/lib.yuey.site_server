package yuey.site.Dao.Menu;

public class Menu {
	String catalago;
	String level;
	String icon;
	public String getCatalago() {
		return catalago;
	}
	public void setCatalago(String catalago) {
		this.catalago = catalago;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String string) {
		this.level = string;
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
	
