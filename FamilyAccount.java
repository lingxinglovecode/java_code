



class FamilyAccount{
	public static void main(String args[]){
		int balance = 10000;
		String details =  "收支\t账户金额\t收支金额\t说 明\n";
		label: while(true)
		{
			System.out.println("-----------家庭收支记账软件------------");
			System.out.println("           1 收支明细                  ");
			System.out.println("           2 登记收入                  ");
			System.out.println("           3 登记支出                  ");
			System.out.println("           4 退出系统                  ");
			System.out.print("           请选择1-4:");
			char enter_num = Utility.readMenuSelection();
			

			switch(enter_num){
				case '1':
					System.out.println("==============收支明细================");
					System.out.println(details);
					System.out.println("======================================");
					break;
				case '2':
					System.out.print("请输入收入金额：");
					int income = Utility.readNumber();
					balance += income;
					System.out.print("请输入收入说明：");
					String info = Utility.readString();
					details = details + "收入" + "\t"+ balance + "\t\t" + income + "\t\t" + info + "\n";
					System.out.println("-------登记完成-------\n");
					break;
				case '3':
					System.out.print("请输入支出金额：");
					int spend = Utility.readNumber();
					balance -= spend;
					System.out.print("请输入支出说明：");
					String spend_info = Utility.readString();
					details = details + "支出" + "\t"+ balance + "\t\t" + spend + "\t\t" + spend_info + "\n";
					System.out.println("-------登记完成-------\n");
					break;
				case '4':
					System.out.print("确认是否退出：[y/n]");
					char quit = Utility.readConfirmSelection();
					if (quit == 'Y')
					{
						break label;
					}



				


			}

			if (enter_num == '1')
			{	
				
			}



		}


	}


}