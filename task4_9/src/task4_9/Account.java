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
		System.out.println("���й�ע��"+m+"Ԫ");
	}
	
	static public void showTotal(){
		System.out.println("����Ŀǰ�����Ϊ:"+totalMoney+"Ԫ");
	}
	
	public void showAccountMoney(){
		System.out.println("�˻�"+accountID+"����"+money+"Ԫ");
		showTotal();
	}
	
	public void saveMoney(double m){
		money += m;
		totalMoney += m;
		System.out.println("�˻�"+accountID+"����"+m+"Ԫ");
	}
	
	public void withDraw(double m){
		money -= m;
		totalMoney -= m;
		System.out.println("�˻�"+accountID+"ȡ��"+m+"Ԫ");
	}

}
