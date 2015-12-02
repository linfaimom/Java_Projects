package sample1_2;

import java.util.Scanner;

public class InputChar {
	private static Scanner reader;
	public static void main(String[] args) {
		char c;
		reader = new Scanner(System.in);
		do {
		  do {
			  System.out.println("请输入A-E之间的一个字符,输入Q退出");
			  c = reader.nextLine().charAt(0);
		  } while (c!='Q'&&(c<'A'||c>'E'));
		
		  switch (c) {
		  case 'A': System.out.println("90-100");break;
		  case 'B': System.out.println("80-89");break;
		  case 'C': System.out.println("70-79");break;
		  case 'D': System.out.println("60-69");break;
		  case 'E': System.out.println("<60");break;
		  default: break;
		  }
	    }while(c!='Q');
		System.out.println("谢谢您的使用，再见！");
	}

}
