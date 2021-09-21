package domin;

import service.Status;

public class Programmer extends Employee{
	private int memberId;
	private Status status= Status.getFree();
	private Equipment equipment;
	
	
	public Programmer(int id, String name, int age, double salary,Equipment equipment) {
		super(id, name, age, salary);
		this.equipment = equipment;
		// TODO Auto-generated constructor stub
	}


	public int getMemberId() {
		return memberId;
	}


	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public Equipment getEquipment() {
		return equipment;
	}


	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	
	public String toString() {
		
		return getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t程序员"+"\t"+status+"\t\t\t"+equipment.getDescription();
		
		
	}
	
	public String teamString() {
		return getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t程序员";
		
	}
	
	
	
	
}
