package abstractprac;

abstract public class Employee {
	public static void main(String[] args) {
		Manager m1 = new Manager("lingxing ", 20000, 10000);
		CommonEmployee c1 = new  CommonEmployee("xiaot", 20000);
		m1.work();
		c1.work();
	}
	
	
	private String name;
	private static int id = 1001;
	private int salary;
	
	public Employee(String name,int saraly) {
		this.name = name;
		this.salary = saraly;
		id++;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public abstract void work();
	
}

class Manager extends Employee{
	private int  bonus;
	
	public Manager(String name,int saraly,int bonus) {
		super(name, saraly);
		this.bonus = bonus;
	}
	public void work() {
		System.out.print("我不用工作");
		
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
}

class CommonEmployee extends Employee{
	
	public CommonEmployee(String name,int saraly) {
		super(name, saraly);
	}

	@Override
	public void work() {
		System.out.print("我需要工作");
		
	}
	
	
	
}



