



class FamilyAccount{
	public static void main(String args[]){
		int balance = 10000;
		String details =  "��֧\t�˻����\t��֧���\t˵ ��\n";
		label: while(true)
		{
			System.out.println("-----------��ͥ��֧��������------------");
			System.out.println("           1 ��֧��ϸ                  ");
			System.out.println("           2 �Ǽ�����                  ");
			System.out.println("           3 �Ǽ�֧��                  ");
			System.out.println("           4 �˳�ϵͳ                  ");
			System.out.print("           ��ѡ��1-4:");
			char enter_num = Utility.readMenuSelection();
			

			switch(enter_num){
				case '1':
					System.out.println("==============��֧��ϸ================");
					System.out.println(details);
					System.out.println("======================================");
					break;
				case '2':
					System.out.print("�����������");
					int income = Utility.readNumber();
					balance += income;
					System.out.print("����������˵����");
					String info = Utility.readString();
					details = details + "����" + "\t"+ balance + "\t\t" + income + "\t\t" + info + "\n";
					System.out.println("-------�Ǽ����-------\n");
					break;
				case '3':
					System.out.print("������֧����");
					int spend = Utility.readNumber();
					balance -= spend;
					System.out.print("������֧��˵����");
					String spend_info = Utility.readString();
					details = details + "֧��" + "\t"+ balance + "\t\t" + spend + "\t\t" + spend_info + "\n";
					System.out.println("-------�Ǽ����-------\n");
					break;
				case '4':
					System.out.print("ȷ���Ƿ��˳���[y/n]");
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