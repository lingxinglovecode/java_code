package project2;
import java.util.ArrayList;

public class CustomerList {
	
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private int customerNum;
	
	public void addCustomer(Customer cust) {
		customerList.add(cust);
		customerNum += 1;
	}
	
	public Customer getCustomer(int index) {
		if(index>=0 && index<customerNum) {
			return customerList.get(index);
		}
		return null;
	}
	
	public void deletCustomer(int index) {
		customerList.remove(index);
	}

	public int getCustomerNum() {
		return customerNum;
	}

	public void setCustomerNum(int customerNum) {
		this.customerNum = customerNum;
	}
	
	
	
	
	
	
}
