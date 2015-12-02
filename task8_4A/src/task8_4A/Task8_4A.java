package task8_4A;

public class Task8_4A {
	public static void main(String[] args) {
		String regex = "[_0-9a-zA-Z]{1,16}[@][zjnu]+[.][edu]*[.]?[cn]+";
		String a = "_god_xiang12312@zjnu.edu.cn";
		String b = "12_34";
		String c = "12345";
		String d = "123456";
		System.out.println(a.matches(regex));
		System.out.println(b.matches(regex));
		System.out.println(c.matches(regex));
		System.out.println(d.matches(regex));
		
	}
}
