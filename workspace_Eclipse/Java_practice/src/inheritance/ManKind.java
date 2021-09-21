package inheritance;

public class ManKind {
	private int sex;
	private int salary;
	
	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void manOrWoman(){
		if(sex == 1) {
			System.out.print("man");
			return;
		}
		System.out.print("woman");
		
		
	}
	
}
