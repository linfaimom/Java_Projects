package task8_4;

public class Task8_4 {
	public static void main(String[] args) {
		String regex = "[^a-zA-Z]+";  //����������ʽ��ȥ������ĸ����������ַ�
		String s = "My123name    34^5is  Yuan Liyong";
		String[] ss = s.split(regex);
		System.out.println("����"+ss.length+"������");
		System.out.println("����Ϊ:");
		for (String string : ss) {
			System.out.println(string);
		}
	}
}
