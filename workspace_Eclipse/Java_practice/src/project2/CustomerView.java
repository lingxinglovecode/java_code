package project2;

public class CustomerView {
	
	public static void main(String args[]) {
		CustomerView my_software = new CustomerView();
		my_software.showMainView();
		
	}
	
	
	
	
	private CustomerList customers = new CustomerList();
	private CMUtility my_util = new CMUtility();	
	public void showMainView() {
		
		 label:while(true) {
			System.out.println("-------客戶信息管理軟件--------");	
			System.out.println("\t1.添加客戶");
			System.out.println("\t2.修改客戶");
			System.out.println("\t3.刪除客戶");
			System.out.println("\t4.客戶列表");
			System.out.println("\t5.退出");
			System.out.print("\t請選擇（1-5）：");
			
			char choice = my_util.readMenuSelection();
			switch (choice) {
			case '1': {
				this.addNewCustomer();
				break;
			}
			case '2':{
				this.modifyCustomer();
				break;
			}
			case '3':{
				this.deletCustomer();
				break;
			}
			case '4':{
				this.showCustomer();
				break;
			}
			case '5':{
				break label;
			}
			
			}
			
			
			
		}
	}
		
	public void addNewCustomer() {
		System.out.println("-------添加客戶--------");
		System.out.print("姓名：");
		String name = my_util.readString(10);
		System.out.print("性別：");
		String sex = my_util.readString(1);
		System.out.print("年齡：");
		int age = my_util.readInt();
		System.out.print("電話：");
		String number = my_util.readString(13);
		System.out.print("郵箱：");
		String email = my_util.readString(20);
		Customer new_customer = new Customer(name,sex,age,number,email);
		customers.addCustomer(new_customer);
		
	}
	
	public void modifyCustomer() {
		System.out.println("-------修改客戶--------");
		System.out.print("請選擇待修改客戶編號（-1退出）：");
		int index = my_util.readInt();
		if(index == -1) {
			return;
		}
		else if (index >= customers.getCustomerNum()) {
			System.out.println("輸入的編號"+index+"大於客戶總人數"+customers.getCustomerNum());
			return;
		}
		Customer modifyCus = customers.getCustomer(index);
		
		System.out.print("姓名：");
		String name = my_util.readString(10,"-1");
		if(name != "-1") {
			modifyCus.setName(name);
		}
		
		System.out.print("性別：");
		String sex = my_util.readString(1,"-1");
		if(sex != "-1") {
			modifyCus.setSex(sex);
		}
		
		System.out.print("年齡：");
		int age = my_util.readInt(-1);
		if(age != -1) {
			modifyCus.setAge(age);
		}
		
		System.out.print("電話：");
		String number = my_util.readString(13,"-1");
		if(number != "-1") {
			modifyCus.setNumber(number);
		}
		
		
		System.out.print("郵箱：");
		String email = my_util.readString(20,"-1");
		if(email != "-1") {
			modifyCus.setEmail(email);
		}
		
		System.out.println("修改完成");
		
	}
	
	public void deletCustomer() {
		System.out.println("-------刪除客戶--------");
		System.out.print("請選擇待刪除客戶編號（-1退出）：");
		int index = my_util.readInt();
		if(index == -1) {
			return;
		}
		System.out.print("確認是否刪除（y/n）：");
		char confirm = my_util.readConfirmSelection();
		if(confirm == 'Y'){
		customers.deletCustomer(index);
		System.out.println("-------刪除完成--------");
		}
		else {
			return;
		}
		
	}
	
	public void showCustomer() {
		if(customers.getCustomerNum()==0) {
			System.out.println("目前沒有客戶！");
			return;
		}
		System.out.println("-------客戶列表--------");
		System.out.println("編號\t姓名\t性別\t年齡\t電話\t\t郵箱");
		for(int i=0;i<customers.getCustomerNum();i++) {
			Customer cur = customers.getCustomer(i);
			System.out.println(i+"\t"+cur.getName()+"\t"+cur.getSex()+"\t"+cur.getAge()+"\t"+cur.getNumber()+"\t\t"+cur.getEmail());
		}
		System.out.println("-------客戶列表完成--------");
			
		
		
	}
		
		
		
	}
	
	
	
	


