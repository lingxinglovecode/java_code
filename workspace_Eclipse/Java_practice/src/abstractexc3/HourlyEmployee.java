package abstractexc3;

import java.util.Calendar;

public class HourlyEmployee extends Employee{

	private int wage;
	private int hour;
	
	
	
	

	public HourlyEmployee(String name, Mydata birthday,int wage,int hour) {
		super(name, birthday);
		this.wage = wage;
		this.hour = hour;
	}

	@Override
	int earnings() {
		return wage * hour;
	}

	@Override
	public String toString() {
		return "员工类型：HourlyEmployee 员工姓名：" + getName() + ", 员工编号：" + getNumber() + ", 员工生日："
				+ getBirthday().getYear() + "年"+ getBirthday().getMonth() + "月"+ getBirthday().getDay() + "日";
	} 
	
	
	
	
}
