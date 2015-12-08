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
	
	//��ʼ��num����
	public void initialize(){
		for (int i = 0; i < num.length; i++) {
			num[i]=0;
		}
	}
	
	//��ȡ�ַ�
	public boolean countCharNum(){
		int[] temp = new int[26];
		FileReader reader = null;
		if (!iF.exists()) {
			System.out.println("�����ļ�����ļ������ڣ�");
		}
		try {
			reader = new FileReader(iF);
			char[] buffer = new char[8];
			int hasRead;
			while ((hasRead=reader.read(buffer)) != -1) {
				//�Զ�ȡ����ÿ���ַ����м�Ⲣͳ��
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
	
	//д���ַ�
	public boolean saveResult(){
		FileWriter writer = null;
		try {
			writer = new FileWriter(oF);
			for (int i = 0; i < num.length; i++) {
				writer.write("��ĸ��"+(char)(i+'A')+"���ĸ���Ϊ:"+num[i]);
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
		System.out.println("������Ҫͳ���ַ����ļ�������·����:");
		File input = new File(scanner.nextLine());
		System.out.println("��ָ������ļ�������·����");
		File output = new File(scanner.nextLine());
		CountChar cc = new CountChar(input, output);
		cc.initialize();
		cc.countCharNum();
		cc.saveResult();
		System.out.println("OK");
		scanner.close();
	}
}
