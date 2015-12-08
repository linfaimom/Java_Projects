package task9_5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class CodeLineCounter{
	private int total;    													//���ڼ�¼����������
	
	//���������������ķ���
	public boolean codeLineNum(String fileName) throws IOException{
		int temp=0;                     									//��¼����
		File file = new File(fileName);
		FileReader reader = null;
		BufferedReader bufferedReader = null;
		String line = null;
		try {
			reader = new FileReader(file);
			bufferedReader = new BufferedReader(reader);
			while ((line=bufferedReader.readLine()) != null) {
				temp++;														//������1
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
	
	//����ȥ�������ж���ո�ķ���
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
				if (line.equals("")) {											//�����ȡ������һ��Ϊ���ַ���
					isSpace = true;
				}
				else {
					if (isSpace) {											//���ǰһ���ǿ�
						writer.newLine();                                   //��ֻ���һ���µĿ��У�Ҳ���ǰ�n�����б�Ϊһ��
					}
					writer.write(line); 									//����ǰ��ȡ�������ַ���д��output�ļ�
					writer.newLine(); 										//
					isSpace = false;										//����ʶ����Ϊfalse
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
		System.out.println("���ļ�����:"+clc.getTotal()+"�д���");
		clc.deleteSpace("D:\\result.txt", "D:\\lalala.txt");
		System.out.println("OK");
	}
}