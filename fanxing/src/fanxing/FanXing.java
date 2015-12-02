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
		school.add("林凤翔");
		school.add("刘子帧");
		school.add("游绍威");
		school.add("李安");
		Map<String, ArrayList<String>> schooleInfo  = new HashMap<>();
		schooleInfo.put("16-120寝室", school);
		schooleInfo.forEach((key,value) -> System.out.println(key+"-->"+value));
		
		//测试泛型的擦除
		Apple<Integer> a = new Apple<>(56);
		System.out.println(a.getSize());
		//这一步擦除了泛型的信息,b只知道a是Number类型而不是具体的Integer类型了
		Apple b = a;
		Number num1 = b.getSize();
		System.out.println(num1);
		//下面这行报错，并不知道它是Integer型,除非进行强制类型转化
		//Integer num2 = b.getSize();
	}
}
