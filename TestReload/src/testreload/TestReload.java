package testreload;

class Sum{
	public int getSum(int a,int b){
		return a+b;
	}
	public double getSum(int a,double b, double c){
		return a+b+c;
	}
}

public class TestReload {
	public static void main(String[] args) {
		Sum sum = new Sum();
		System.out.println(sum.getSum(10, 15));
		System.out.println(sum.getSum(10, 12.5, 13.2));
	}
}
