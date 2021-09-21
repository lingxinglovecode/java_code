package abstractexc3;

import java.util.Calendar;

public class SalariedEmployee extends Employee {
	
	private int monthlySalary;
	
	public SalariedEmployee(String name, Mydata birthday,int monthlySalary) {
		super(name, birthday);
		this.monthlySalary = monthlySalary;
	}

	@Override
	public int earnings() {
		return monthlySalary;
		
	}
	
	public String toString() {
		return "员工类型：SalariedEmployee 员工姓名：" + getName() + ", 员工编号：" + getNumber() + ", 员工生日："
				+ getBirthday().getYear() + "年"+ getBirthday().getMonth() + "月"+ getBirthday().getDay() + "日";
	}
	

}
