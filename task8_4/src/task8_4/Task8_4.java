package task8_4;

public class Task8_4 {
	public static void main(String[] args) {
		String regex = "[^a-zA-Z]+";  //利用正则表达式，去掉除字母以外的其他字符
		String s = "My123name    34^5is  Yuan Liyong";
		String[] ss = s.split(regex);
		System.out.println("共有"+ss.length+"个单词");
		System.out.println("内容为:");
		for (String string : ss) {
			System.out.println(string);
		}
	}
}
