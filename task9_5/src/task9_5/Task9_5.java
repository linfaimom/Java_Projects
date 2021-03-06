package task9_5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class CodeLineCounter{
	private int total;    													//用于记录代码总行数
	
	//定义计算代码行数的方法
	public boolean codeLineNum(String fileName) throws IOException{
		int temp=0;                     									//记录行数
		File file = new File(fileName);
		FileReader reader = null;
		BufferedReader bufferedReader = null;
		String line = null;
		try {
			reader = new FileReader(file);
			bufferedReader = new BufferedReader(reader);
			while ((line=bufferedReader.readLine()) != null) {
				temp++;														//行数加1
			}
			reader.close();
			bufferedReader.close();
			total+=temp;
			return true;
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	
	public int getTotal() {
		return total;
	}
	
	//定义去除代码中多余空格的方法
	public boolean deleteSpace(String input, String output) throws IOException{
		File iF = new File(input);
		File oF = new File(output);
		BufferedReader reader = null;
		BufferedWriter writer = null;
		boolean isSpace = false;
		try {		
		    reader = new BufferedReader(new FileReader(iF));
			writer = new BufferedWriter(new FileWriter(oF));
			String line;
			while ((line=reader.readLine()) != null) {
				if (line.equals("")) {											//如果读取到的这一行为空字符串
					isSpace = true;
				}
				else {
					if (isSpace) {											//如果前一行是空
						writer.newLine();                                   //则只输出一个新的空行，也即是把n个空行变为一个
					}
					writer.write(line); 									//将当前读取的那行字符串写入output文件
					writer.newLine(); 										//
					isSpace = false;										//将标识符变为false
				}
			}
			reader.close();
			writer.close();
			return true;
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}

public class Task9_5 {
	public static void main(String[] args) throws IOException {
		CodeLineCounter clc = new CodeLineCounter();
		clc.codeLineNum("D:\\JavaProjects\\task9_5\\src\\task9_5\\Task9_5.java");
		System.out.println("该文件共有:"+clc.getTotal()+"行代码");
		clc.deleteSpace("D:\\result.txt", "D:\\lalala.txt");
		System.out.println("OK");
	}
}
