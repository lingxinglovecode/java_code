package service;

import java.util.Iterator;

import domin.Architect;
import domin.Designer;
import domin.Employee;
import domin.Programmer;

public class TeamService {
	
	private static int architecNum = 0;
	private static int designNum = 0;
	private static int programNum = 0;
	
	private static int counter = 1;
	private final int MAX_NUMBER = 5;
	private Programmer[] team = new Programmer[MAX_NUMBER];
	private int total =0;
	
	public Programmer[] getTeam() {
		//应该返回已有的成员，空指针不能返回
		Programmer[] team =  new Programmer[total];
		for(int i=0;i<total;i++) {
			team[i] = this.team[i];
		}
		return team;
	}
	
	
	public void addMember(Employee e) throws TeamException{
		if (!(e instanceof Programmer)) {
			throw new TeamException("该成员不是开发人员，无法添加");
		}
		Programmer p = (Programmer) e;
		
		if (total>=MAX_NUMBER) {
			throw new TeamException("成员已满，无法添加");
		}
		
		
		if("BUSY".equals(p.getStatus().getNAME())) {
			throw new TeamException("该员工已是某团队成员");
		}else if ("VOCATION".equals(p.getStatus().getNAME())) {
			throw new TeamException("该员正在休假，无法添加");
		}
		
		
//		if(!(p.getStatus()==Status.getFree())) {
//			throw new TeamException("该员正在休假，无法添加");
//		}
		
		for(int i=0;i<team.length;i++) {
			if(team[i]!=null && team[i].getId() == e.getId()) {
				throw new TeamException("该员工已在本开发团队中");
			}
		}
		
		
		
		if(e.getClass().equals(Programmer.class)) {
			if (programNum == 3) {
				throw new TeamException("团队中至多只能有三名程序员");
			}
			programNum = programNum;
//			team[total++] = (Programmer)e;
//			return;
		}
		else if (e.getClass().equals(Designer.class)) {
			if (designNum == 2) {
				throw new TeamException("团队中至多只能有两名设计师");
			}
			designNum += 1;
//			team[total++] = (Designer)e;
//			return;
		}
		else if (e.getClass().equals(Architect.class)) {
			if (architecNum == 1) {
				throw new TeamException("团队中至多只能有一名架构师");
			}
			architecNum += 1;
//			team[total++] = (Architect)e;
//			return;
		}
		 team[total++] = p;
		 p.setStatus(Status.BUSY);
		 p.setMemberId(counter++);
		
		
		
	}
	public void removeMember(int memberId) throws TeamException{
		
		for(int i=0;i<team.length;i++) {
			if(team[i]!=null&& i == memberId) {
				
				while(i+1<team.length) {
					team[i] = team[i+1];
					i= i+1;
				}
				team[i] = null;
				total -= 1;
				return;
			}
		}
		throw new TeamException("找不到指定memberId的员工，删除失败");
		
		
		
	}
	

}
