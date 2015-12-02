package task5_4;


class Bank{
	int savedMoney;
	int	year;
	double computerInterest(){
		return savedMoney * year * 0.04;
	}
}

class ConstructionBank extends Bank{
	double year;  //隐藏父类中的year
	double computerInterest(){
		super.year = (int)year;
		double total;
		total = super.computerInterest();
		int remained = (int)((year-(int)year)*1000);  //计算不足一年的天数
		total += remained*0.0001*savedMoney;
		System.out.println(savedMoney+"一共存了"+super.year+"年"+remained+"天");
		return total;
	}
	
}

public class Task5_4 {
	public static void main(String[] args) {
		ConstructionBank cb = new ConstructionBank();
		cb.savedMoney=10000;
		cb.year=3.150;
		System.out.println(cb.computerInterest());
	}
}
