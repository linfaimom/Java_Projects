package task4_9;

public class Task4_9 {

	public static void main(String[] args) {
		Account.addMoney(1000000);
		Account a1 = new Account("001", 2000);
		a1.saveMoney(2000000);
		Account.showTotal();
		a1.withDraw(500);
		a1.showAccountMoney();
	}

}
