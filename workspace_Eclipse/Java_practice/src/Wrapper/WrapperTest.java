package Wrapper;
/*
 * 
 * 利用Vector代替数组处理：从键盘读入学生成绩（以负数代表输入结束），找出
最高分，并输出学生成绩等级。
	提示：数组一旦创建，长度就固定不变，所以在创建数组前就需要知道它的
	  长度。而向量类java.util.Vector可以根据需要动态伸缩。
	创建Vector对象：Vector v=new Vector();
	给向量添加元素：v.addElement(Object obj); //obj必须是对象
	取出向量中的元素：Object obj=v.elementAt(0);
	注意第一个元素的下标是0，返回值是Object类型的。
	计算向量的长度：v.size();
	若与最高分相差10分内：A等；20分内：B等；
	  30分内：C等；其它：D等
 * 
 * 
 * 
 * 
 */

import java.util.Scanner;
import java.util.Vector;


public class WrapperTest {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Vector v=new Vector();
		System.out.println("请输入学生成绩（负数表示退出）:");
		
		int maxNum = 0;
		while(true) {
			int num = scanner.nextInt();
			if(num<0) {
				break;
			}
			if(num>100) {
				System.out.println("最高成绩必须小于等于100！");
				continue;
			}
			v.addElement(num);
			maxNum = maxNum>num ? maxNum : num;
			
		}
		
		char grade;
		for(int i=0;i<v.size();i++) {
			Object obj=v.elementAt(i);
//			Integer objInteger = (Integer)obj;
//			int score = objInteger.intValue();
			
			int score = (int) obj;
			if(maxNum-score<=10) {
				grade = 'A';
			}
			else if (maxNum-score<=20) {
				grade = 'B';
				
			}
			else if (maxNum-score<=30) {
				grade = 'C';
			}
			else {
				grade = 'D';
			}
			System.out.println("Student "+i+" score is "+score+",grade is "+grade);
			
			}
			
			
		}
	
	
	
	
	

}
