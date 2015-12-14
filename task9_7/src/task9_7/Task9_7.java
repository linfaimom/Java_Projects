//����ObjectO/IutputStream,��������ǿ����л���

package task9_7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sID;
	private String name;
	int grade = 1;
	int classNum = 1;
	
	public Student(String id, String name){
		super();
		sID = id;
		this.name = name;
	}

	public String getsID() {
		return sID;
	}

	public String getName() {
		return name;
	}
}

public class Task9_7 {
	public static void main(String[] args) {
		Student lin = new Student("14095224", "lfx");
		lin.grade = 1997;
		lin.classNum = 1;
		try {
			//����д�����
			FileOutputStream fos = new FileOutputStream("./lala.txt");
			ObjectOutputStream outputStream = new ObjectOutputStream(fos);
			outputStream.writeObject(lin);  //���������
			fos.close();
			outputStream.close();  //�ر�
			
			//���ж�ȡ����
			FileInputStream fis = new FileInputStream("./lala.txt");
			ObjectInputStream inputStream = new ObjectInputStream(fis);
			lin = (Student)inputStream.readObject();  //���ļ��ж�ȡ�������ݣ���Ҫǿ������ת��
			fis.close();
			inputStream.close();
			
			//�����������ֵ
			System.out.println(lin.classNum);
			System.out.println(lin.grade);
			System.out.println(lin.getName());
			System.out.println(lin.getsID());
			System.out.println("OK!");
			
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
}
