package task5_10;

abstract class Order{
	double totalMoney;
	abstract double computePayment();
}

class CommonOrder extends Order{

	@Override
	double computePayment() {
		System.out.println("��ͨ�û���û���ۿۣ�");
		return totalMoney;
	}
	
}

class GoldOrder extends Order{

	@Override
	double computePayment() {
		System.out.println("���û��������Żݣ�");
		return totalMoney * 0.9;
	}
	
}

class SilverOrder extends Order{

	@Override
	double computePayment() {
		System.out.println("�����û����������Żݣ�");
		return totalMoney * 0.95;
	}
	
}

class SuperMarket{
	static double totalIncome;
	static void dealWithOrder(Order order){
		double payment = order.computePayment();
		System.out.println("��Ҫʵ�ʸ���"+payment+"Ԫ");
		totalIncome += payment;
	}
}

public class Task5_10 {
	public static void main(String[] args) {
		SuperMarket.totalIncome=0;
		CommonOrder co = new CommonOrder();
		co.totalMoney = 190;
		SuperMarket.dealWithOrder(co);
		GoldOrder go = new GoldOrder();
		go.totalMoney=200;
		SuperMarket.dealWithOrder(go);
		SilverOrder so = new SilverOrder();
		so.totalMoney=500;
		SuperMarket.dealWithOrder(so);
	}
}
