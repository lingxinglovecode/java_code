package service;

import javax.swing.DefaultBoundedRangeModel;

import domin.Architect;
import domin.Designer;
import domin.Employee;
import domin.Equipment;
import domin.NoteBook;
import domin.PC;
import domin.Printer;
import domin.Programmer;

public class NameListService {
	public static void main(String[] args) {
		
	}
	
	private Employee[] employees;
	
	public Equipment GetEquipment(String[] equStrings) {
		if(Integer.parseInt(equStrings[0]) == Data.PC) {
			return (Equipment) new PC(equStrings[1],equStrings[2]);
		}
		else if (Integer.parseInt(equStrings[0]) == Data.NOTEBOOK) {
			return (Equipment) new NoteBook(equStrings[1],Double.parseDouble(equStrings[2]));
		}
		else if(Integer.parseInt(equStrings[0]) == Data.PRINTER) {
			return (Equipment) new Printer(equStrings[1],equStrings[2]);
		}
		return null;
	}
	
	
	public NameListService() {
		super();
		Data data = new Data();
		this.employees = new Employee[data.EMPLOYEES.length];
		for(int i=0; i < data.EMPLOYEES.length;i++) {
			String [] dataInfo = data.EMPLOYEES[i];
			int type = Integer.parseInt(dataInfo[0]);
			if(type == data.EMPLOYEE) {
				employees[i] = new Employee(Integer.parseInt(dataInfo[1]) ,dataInfo[2], 
						Integer.parseInt(dataInfo[3]), Double.parseDouble(dataInfo[4]));
			}
			else if (type == data.PROGRAMMER) {
				
				employees[i] = new Programmer(Integer.parseInt(dataInfo[1]) ,dataInfo[2], 
						Integer.parseInt(dataInfo[3]), Double.parseDouble(dataInfo[4]),
						GetEquipment(data.EQUIPMENTS[i]));
			}
			else if(type ==data.DESIGNER) {
				employees[i] = new Designer(Integer.parseInt(dataInfo[1]) ,dataInfo[2], 
						Integer.parseInt(dataInfo[3]), Double.parseDouble(dataInfo[4]),
						GetEquipment(data.EQUIPMENTS[i]),Double.parseDouble(dataInfo[5]));
			}
			
			else if(type ==data.ARCHITECT) {
				employees[i] = new Architect(Integer.parseInt(dataInfo[1]) ,dataInfo[2], 
						Integer.parseInt(dataInfo[3]), Double.parseDouble(dataInfo[4]),
						GetEquipment(data.EQUIPMENTS[i]),Double.parseDouble(dataInfo[5]),
						Integer.parseInt(dataInfo[6]));
				
			}
		
			
			
		}
		
		
		
	}

	public Employee[] getAllEmployees() {
		return employees;
	}
	
//	public Employee getEmployee(int id) throws TeamException {
//		for(int i=0;i<employees.length;i++) {
//			if(employees[i].getId()==id-1) {
//				return employees[id-1];
//				
//			}
//		}
//		throw new TeamException("找不到相应员工！");
//	
//	}
//	
	
	
	
	
}
