package exception_exc;

import java.util.Scanner;

public class EcmDef {
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
		try {
			int num1 = Integer.parseInt(args[0]);
			int num2 = Integer.parseInt(args[1]);
			System.out.print(num1+"➗"+num2+"="+ ecm(num1, num2));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (ArithmeticException e) {
			e.printStackTrace();
		} catch (MinusException e) {
			e.printStackTrace();
		}
		
	}
	
	public static double ecm(int num1,int num2) throws MinusException,ArithmeticException{
		if(num1>=0 && num2>0) {
			return num1/num2;
		}
		else if (num2==0) {
			throw new ArithmeticException("除数不能为0！");
		}
		else {
			throw new MinusException("不能包含负数");
		}
		
		
		
	}


	
	
}
