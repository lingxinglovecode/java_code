package view;


import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import domin.Employee;
import service.NameListService;
import service.TeamException;
import service.TeamService;

public class TeamView {
	public static void main(String[] args) {
		
		System.out.println("-------------------开发团队调度软件-------------------");
		TeamView tView = new TeamView();
		tView.listAllEmployees();
		System.out.println("-------------------------------------------------");
		label:while(true) {
			System.out.println("1-团队列表 2-添加団队成员 3-删除团队成员 4-退出请选择 (1-4):");
			char choice = TSUtility.readMenuSelection();
			switch (choice) {
			case '1':
				tView.getTeam();
				break;
			case '2':
				System.out.println("请输入想要添加人员的ID：");
				int id = TSUtility.readInt();
				Boolean isAdd = tView.addMember(id);
				if(isAdd == true) {
					System.out.println("添加成功！");
					TSUtility.readReturn();
					break;
				}
				TSUtility.readReturn();
				break;	
			case '3':
				System.out.println("请输入想要删除人员的TID：");
				int deletId = TSUtility.readInt();
				System.out.println("请确认是否删除(Y/N):");
				char confirmBoolean = TSUtility.readConfirmSelection();
				if(confirmBoolean == 'Y') {
					Boolean isDeleteBoolean = tView.deleteMember(deletId);
					if(isDeleteBoolean==true) {
					System.out.println("删除成功！");}
					TSUtility.readReturn();
					break;
				}
				break;
			case '4':
				break label;
			}
			
		}
		
		

	}
	
	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService();
	
	public void enterMainMenu() {
		
		
	}
	
	private  void listAllEmployees() {
		Employee[] allEmployees = listSvc.getAllEmployees();
		System.out.println("ID\t"+"姓名\t"+"年龄\t"+"工资\t"+"职位\t"+"状态\t"+"奖金\t"+"股票\t"+"领用设备");
		for(int i=0;i<allEmployees.length;i++) {
			System.out.println(allEmployees[i]);
		}
	}
	private void getTeam() {
		Employee[] teamEmployees = teamSvc.getTeam();
		System.out.println("---------------------------团队成员列表------------------");
		System.out.println("TID/ID\t"+"姓名\t"+"年龄\t"+"工资\t"+"职位\t"+"奖金\t"+"股票\t");
		
	
		for(int i=0;i<teamEmployees.length;i++) {
			System.out.println((i+1)+"/"+teamEmployees[i].teamString());}
		
		
		
		System.out.println("------------------------------------------------------");
		
		
		
	}
	
	private boolean addMember(int ID) {

		Employee[] allEmployees = listSvc.getAllEmployees();
		for(int i=0;i<allEmployees.length;i++) {
			if(allEmployees[i].getId() == ID) {
				try {
					teamSvc.addMember(allEmployees[i]);
					return true;
				} catch (TeamException e) {
					// TODO Auto-generated catch block
					System.out.println("添加失败，原因："+e.getMessage());
//					e.printStackTrace();
				}
	
			}
		}
		return false;
		
	}

	private boolean deleteMember(int TID) {
		try {
			teamSvc.removeMember(TID-1);
			return true;
		} catch (TeamException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return false;
		
	}

}
