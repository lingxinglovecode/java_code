package abstractexc3;

abstract public class Employee {
	private String name;
	private static int ID=1;
	private int number;
	private Mydata birthday;
	
	abstract int earnings();
	
	
	
	
	public Employee(String name, Mydata birthday) {
		super();
		this.name = name;
		number = ID++; 
		this.birthday = birthday;
	}




	@Override
	public String toString() {
		return "Employee [name=" + getName() + ", number=" + getNumber() + ", birthday=" + getBirthday() + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Mydata getBirthday() {
		return birthday;
	}

	public void setBirthday(Mydata birthday) {
		this.birthday = birthday;
	}
	
	
}	

