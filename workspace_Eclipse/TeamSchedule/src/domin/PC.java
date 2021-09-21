package domin;

public class PC implements Equipment{
	private String model;
	private String display;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	
	public PC(String model, String display) {
		super();
		this.model = model;
		this.display = display;
	}
	public String getDescription() {
		
		return "型号："+model+" 显示器名称："+display;
	}
}