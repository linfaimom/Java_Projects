package fanxing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Apple<T extends Number>{
	T size;
	public Apple(){
		
	}
	public Apple(T size){
		this.size = size;
	}
	public void setSize(T size){
		this.size = size;
	}
	public T getSize(){
		return size;
	}
}

public class FanXing {
	public static void main(String[] args) {
		ArrayList<String> school = new ArrayList<>();
		school.add("�ַ���");
		school.add("����֡");
		school.add("������");
		school.add("�");
		Map<String, ArrayList<String>> schooleInfo  = new HashMap<>();
		schooleInfo.put("16-120����", school);
		schooleInfo.forEach((key,value) -> System.out.println(key+"-->"+value));
		
		//���Է��͵Ĳ���
		Apple<Integer> a = new Apple<>(56);
		System.out.println(a.getSize());
		//��һ�������˷��͵���Ϣ,bֻ֪��a��Number���Ͷ����Ǿ����Integer������
		Apple b = a;
		Number num1 = b.getSize();
		System.out.println(num1);
		//�������б�������֪������Integer��,���ǽ���ǿ������ת��
		//Integer num2 = b.getSize();
	}
}
