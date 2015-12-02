package task5_4;


class Bank{
	int savedMoney;
	int	year;
	double computerInterest(){
		return savedMoney * year * 0.04;
	}
}

class ConstructionBank extends Bank{
	double year;  //���ظ����е�year
	double computerInterest(){
		super.year = (int)year;
		double total;
		total = super.computerInterest();
		int remained = (int)((year-(int)year)*1000);  //���㲻��һ�������
		total += remained*0.0001*savedMoney;
		System.out.println(savedMoney+"һ������"+super.year+"��"+remained+"��");
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
