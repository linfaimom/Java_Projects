package task8_3;

import java.util.Scanner;

public class Task8_3 {
	public static void main(String[] args) {
		String regex = "(0|[1-9][0-9]*])([.][0-9]*[1-9])?"; 
		Scanner reader = new Scanner(System.in);
		System.out.println("������һ���ַ���:");
		String s = reader.nextLine();
		while(!s.equals("exit")){
			if (s.matches(regex)) {
				System.out.println("ƥ��");
			}
			else {
				System.out.println("��ƥ��");
			}
			System.out.println("������һ���ַ���:");
			s = reader.nextLine();
		}
		reader.close();
		System.out.println("�������˳�");
	}
}
