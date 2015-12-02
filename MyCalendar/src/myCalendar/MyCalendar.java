package myCalendar;

import java.util.Scanner;

public class MyCalendar {

	public static void main(String[] args) {
		int year,month;
		int dc = 0;  //记录当月有几天
		int[] days = new int[42];  //定义一个一维数组，便于对后面6行7列进行填充
		int dayCount=0;  //算出现在距离1900-1-1一共多少天
		int start;       //算出这个月的第一天是星期几
		Scanner reader = new Scanner(System.in);
		System.out.println("请输入年份:");
		year = reader.nextInt();
		System.out.println("请输入月份:");
		month = reader.nextInt();
		//关闭Scanner
		reader.close();
		for(int y=1900;y<year;y++){
			if (y%400==0||(y%4==0&&y%100!=0)) {
				dayCount += 366;  //如果是闰年
			}
			else
				dayCount += 365;  //如果是平年
		}
		
		for(int m=1;m<month;m++){
			if(m==4||m==6||m==9||m==11){
				dayCount += 30;
			}
			else if(m==2){
				if (year%400==0||(year%4==0&&year%100!=0)) {
					dayCount += 29;  //如果是闰年
				}
				else{
					dayCount += 28;  //如果是平年
				}
			
			}
			else {
				dayCount += 31;
			}
		}
		
		//dayCount++;
		start = dayCount % 7;  //结果为星期（start+1）
		
		//判断当前月有几天
		if(month==4||month==6||month==9||month==11){
			dc=30;
		}
		else if(month==2){
			if (year%400==0||(year%4==0&&year%100!=0)) {
				dc = 29;  //如果是闰年
			}
			else{
				dc = 28;  //如果是平年
			}
		
		}
		else {
			dc = 31;
		}
				
		//对6行7列的表进行数据填充
		for(int i=0;i<start+1;i++) days[i]=0;
	    for(int i=1;i<=dc;start++,i++) days[start+1]=i;
		for(int i=start+dc+1;i<42;i++)  days[i]=0;
		
		//打印列表
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
