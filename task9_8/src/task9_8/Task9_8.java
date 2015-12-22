//����RandomAccessFile�����д��

package task9_8;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Task9_8 {
	public static void main(String[] args) {
		try {
			//��������֧�ֶ���д
			RandomAccessFile raf = new RandomAccessFile("./data.dat","rw");
			
			//����10���������д���ļ�
			for (int i = 0; i < 10; i++) {
				int n = (int)(Math.random()*90+10);
				raf.writeInt(n);
			}
			
			//ѡ������
			for (int i = 0; i < 9; i++) {
				//��λ����i����
				raf.seek(i*4);
				//��ȡһ��������iData
				int iData = raf.readInt();
				for (int j = i+1; j < 10; j++) {
					raf.seek(j*4);
					int jData = raf.readInt();
					if(jData>iData){
						//��jData�ϴ����iDataλ�õ����ݸ���ΪjData���ɴ˿ɼ��������ǰ��Ӵ�С˳������
						raf.seek(i*4);
						raf.writeInt(jData);
						raf.seek(j*4);
						raf.writeInt(iData);
						//��iData��¼�����еĽϴ�ֵ
						iData = jData;
					}
				}
			}
			
			//���ļ��ж�ȡ���������֣��������Ļ
			for (int i = 0; i < 10; i++) {
				raf.seek(i*4);
				int read = raf.readInt();
				System.out.println(read);	
			}
			
			//�ر������д
			raf.close();
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
	}
}
