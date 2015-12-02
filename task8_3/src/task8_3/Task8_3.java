package task8_3;

import java.util.Scanner;

public class Task8_3 {
	public static void main(String[] args) {
		String regex = "(0|[1-9][0-9]*])([.][0-9]*[1-9])?"; 
		Scanner reader = new Scanner(System.in);
		System.out.println("请输入一个字符串:");
		String s = reader.nextLine();
		while(!s.equals("exit")){
			if (s.matches(regex)) {
				System.out.println("匹配");
			}
			else {
				System.out.println("不匹配");
			}
			System.out.println("请输入一个字符串:");
			s = reader.nextLine();
		}
		reader.close();
		System.out.println("程序已退出");
	}
}
