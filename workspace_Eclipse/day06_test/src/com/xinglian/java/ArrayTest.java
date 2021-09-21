package com.xinglian.java;
import java.util.Scanner;
public class ArrayTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入学生人数：");
		int num = scan.nextInt();
		int[] scores = new int[num];
		System.out.println("请依次输入"+num+"个学生的成绩：");
		int max_grade = 0;
		for(int i = 0; i < scores.length;i++) {
			scores[i] = scan.nextInt();
			max_grade = max_grade > scores[i] ? max_grade : scores[i]; 
		}
		System.out.println("最高分为：" + max_grade);
		
		for(int i=0;i<scores.length;i++) {
			System.out.print("student"+i+" score is "+scores[i]);
			char level;
			if(scores[i] >= max_grade-10) {
				level = 'A';
			}
			else if(scores[i] >= max_grade-20) {
				level = 'B';
			}
			else if(scores[i] >= max_grade-30) {
				level = 'C';
			}
			else {
				level = 'D';
			}
			System.out.println(" grade is "+level);
		}
	}
}
