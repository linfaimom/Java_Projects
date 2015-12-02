package sample1_1;


public class FindPrime {
	public static void main(String[] args){
		int c=0;
		boolean flag = true;
		for(int i=100;i<=500;i++){
			flag = true;
			for(int j=2;j<i;j++){
				if (i % j == 0){
					flag  = false;
					break;
				}
			}
		    if(flag){
		    	c++;
				System.out.print(i+"  ");
				if (c%5==0) {
					System.out.println();
				}
			}
		}
	}
}
