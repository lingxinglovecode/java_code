package junit;

import org.junit.jupiter.api.Test;

import domin.Employee;
import service.NameListService;

public class testNameListService {
	
	@Test
	public void testGetAllEmployees() {
		NameListService nList = new NameListService();
		Employee[] allEmployees =  nList.getAllEmployees();
		for(int i=0;i<allEmployees.length;i++) {
			System.out.println(allEmployees[i]);
		}
		
	}
	
	
	
	
}
