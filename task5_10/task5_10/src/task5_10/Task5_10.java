package task5_10;

abstract class Order{
	double totalMoney;
	abstract double computePayment();
}

class CommonOrder extends Order{

	@Override
	double computePayment() {
		System.out.println("普通用户，没有折扣！");
		return totalMoney;
	}
	
}

class GoldOrder extends Order{

	@Override
	double computePayment() {
		System.out.println("金卡用户，九折优惠！");
		return totalMoney * 0.9;
	}
	
}

class SilverOrder extends Order{

	@Override
	double computePayment() {
		System.out.println("银卡用户，九五折优惠！");
		return totalMoney * 0.95;
	}
	
}

class SuperMarket{
	static double totalIncome;
	static void dealWithOrder(Order order){
		double payment = order.computePayment();
		System.out.println("需要实际付款"+payment+"元");
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
