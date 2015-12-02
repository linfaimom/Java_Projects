package task4_9;

public class Account {
	String accountID;
	double money;
	static double totalMoney;
	
	public Account(String id,double money) {
		accountID = id;
		this.money = money;
		totalMoney+=money;
	}
	
	static public void addMoney(double m){
		totalMoney += m;
		System.out.println("银行共注入"+m+"元");
	}
	
	static public void showTotal(){
		System.out.println("银行目前存款金额为:"+totalMoney+"元");
	}
	
	public void showAccountMoney(){
		System.out.println("账户"+accountID+"共有"+money+"元");
		showTotal();
	}
	
	public void saveMoney(double m){
		money += m;
		totalMoney += m;
		System.out.println("账户"+accountID+"存入"+m+"元");
	}
	
	public void withDraw(double m){
		money -= m;
		totalMoney -= m;
		System.out.println("账户"+accountID+"取出"+m+"元");
	}

}
