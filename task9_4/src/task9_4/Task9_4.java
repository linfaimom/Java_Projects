package task9_4;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class CountChar{
	File iF;
	File oF;
	int[] num = new int[26];
	
	public CountChar(File inputFile,File outputFile){
		iF = inputFile;
		oF = outputFile;
	}
	
	//初始化num数组
	public void initialize(){
		for (int i = 0; i < num.length; i++) {
			num[i]=0;
		}
	}
	
	//读取字符
	public boolean countCharNum(){
		int[] temp = new int[26];
		FileReader reader = null;
		if (!iF.exists()) {
			System.out.println("不是文件或该文件不存在！");
		}
		try {
			reader = new FileReader(iF);
			char[] buffer = new char[8];
			int hasRead;
			while ((hasRead=reader.read(buffer)) != -1) {
				//对读取到的每个字符进行检测并统计
				for (int i = 0; i < hasRead; i++) {
					char c = buffer[i];
					if (c>='A'&&c<='Z') {
						num[c-'A']++;
					}
					else if(c>='a'&&c<='z'){
						temp[c-'a']++;
					}
				}
			}
			reader.close();
			for (int i = 0; i < num.length; i++) {
				num[i]=num[i]+temp[i];
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	//写入字符
	public boolean saveResult(){
		FileWriter writer = null;
		try {
			writer = new FileWriter(oF);
			for (int i = 0; i < num.length; i++) {
				writer.write("字母“"+(char)(i+'A')+"”的个数为:"+num[i]);
				writer.write("\r\n");
			}
			writer.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}

public class Task9_4 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入要统计字符的文件（绝对路径）:");
		File input = new File(scanner.nextLine());
		System.out.println("请指定输出文件（绝对路径）");
		File output = new File(scanner.nextLine());
		CountChar cc = new CountChar(input, output);
		cc.initialize();
		cc.countCharNum();
		cc.saveResult();
		System.out.println("OK");
		scanner.close();
	}
}
