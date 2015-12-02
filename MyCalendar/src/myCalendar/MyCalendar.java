package myCalendar;

import java.util.Scanner;

public class MyCalendar {

	public static void main(String[] args) {
		int year,month;
		int dc = 0;  //��¼�����м���
		int[] days = new int[42];  //����һ��һά���飬���ڶԺ���6��7�н������
		int dayCount=0;  //������ھ���1900-1-1һ��������
		int start;       //�������µĵ�һ�������ڼ�
		Scanner reader = new Scanner(System.in);
		System.out.println("���������:");
		year = reader.nextInt();
		System.out.println("�������·�:");
		month = reader.nextInt();
		//�ر�Scanner
		reader.close();
		for(int y=1900;y<year;y++){
			if (y%400==0||(y%4==0&&y%100!=0)) {
				dayCount += 366;  //���������
			}
			else
				dayCount += 365;  //�����ƽ��
		}
		
		for(int m=1;m<month;m++){
			if(m==4||m==6||m==9||m==11){
				dayCount += 30;
			}
			else if(m==2){
				if (year%400==0||(year%4==0&&year%100!=0)) {
					dayCount += 29;  //���������
				}
				else{
					dayCount += 28;  //�����ƽ��
				}
			
			}
			else {
				dayCount += 31;
			}
		}
		
		//dayCount++;
		start = dayCount % 7;  //���Ϊ���ڣ�start+1��
		
		//�жϵ�ǰ���м���
		if(month==4||month==6||month==9||month==11){
			dc=30;
		}
		else if(month==2){
			if (year%400==0||(year%4==0&&year%100!=0)) {
				dc = 29;  //���������
			}
			else{
				dc = 28;  //�����ƽ��
			}
		
		}
		else {
			dc = 31;
		}
				
		//��6��7�еı�����������
		for(int i=0;i<start+1;i++) days[i]=0;
	    for(int i=1;i<=dc;start++,i++) days[start+1]=i;
		for(int i=start+dc+1;i<42;i++)  days[i]=0;
		
		//��ӡ�б�
		System.out.println("Sun"+" Mon"+" Tue"+" Wen"+" Thu"+" Fri"+" Sta");
		for(int i=0;i<42;i++){
			if(days[i]==0)
				System.out.print("    ");
			else if(days[i]<10)
				System.out.print(days[i]+"   ");
			else
				System.out.print(days[i]+"  ");
			if(i%7==6){
				System.out.println();
			}
		}
	}

}
