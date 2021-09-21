package domin;

public class Architect extends Designer{
	private int stock;

	public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus,int stock) {
		super(id, name, age, salary, equipment, bonus);
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public String toString() {
		
		return getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t架构师"+"\t"+getStatus()+"\t"+getBonus()+"\t"+stock+"\t"+getEquipment().getDescription();
		
		
	}
	public String teamString() {
		return getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t架构师\t"+getBonus()+"\t"+stock;
		
	}
	
}
