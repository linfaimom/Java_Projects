package countchar;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class CountChar{
	File iF;
	File oF;
	int count;
	FileReader reader = null;
	FileWriter writer = null;
	int[] num = new int[26];
	
	public CountChar(File inputFile,File outputFile){
		iF = inputFile;
		oF = outputFile;
	}
	
	public void outputCharNum() throws IOException{
		try {
			reader = new FileReader(iF);
			writer = new FileWriter(oF);
			char[] buffer = new char[8];
			int hasRead;
			while ((hasRead=reader.read(buffer)) != -1) {
				//对读取到的每个字符进行检测并统计
				for (int i = 0; i < hasRead; i++) {
					if (buffer[i]>=97&&buffer[i]<=122) {
						
						
						
						
						
						
					}
					else if(buffer[i]>=65&&buffer[i]<=90){
						
						
						
						
						
						
					}
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
		finally {
			reader.close();
			writer.close();
		}
	}
}

public class Task {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入要统计字符的文件（绝对路径）:");
		File input = new File(scanner.nextLine());
		System.out.println("请指定输出文件（绝对路径）");
		File output = new File(scanner.nextLine());
		CountChar cc = new CountChar(input, output);
		cc.outputCharNum();
		System.out.println("OK");
		scanner.close();
	}
}
