package abstractexc3;

import java.util.Scanner;

public class PayrollSystem {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Employee[] works = new Employee[2];
		works[0]  = new HourlyEmployee("dada",new Mydata(2001,12,3),5,10);
		works[1] = new SalariedEmployee("gaga",new Mydata(2011,12,3),2000);
		
		System.out.println("请输入当前月份：");
		int month = scanner.nextInt();
		for(int i=0;i<works.length;i++) {
			if(month == works[i].getBirthday().getMonth()) {
				System.out.println(works[i]+" 由于生日本月增加工资:100");
			}
			else {
				System.out.println(works[i]);
			}
			
			
		}
		
		
	}
	
	
	
}
