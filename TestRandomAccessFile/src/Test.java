import java.io.*;

/**
 * Created by Adminifuck your mother!this is just a test!fuck your mother!this is just a test!strator on 2015/11/23.
 */
public class Test {
    public static void insert(String fileName, long pos, String insertContent) throws IOException {
        //����һ����ʱ�ļ����ڱ���ָ��λ�ú����������
        File tmp = File.createTempFile("tmp",null);
        //���˳���ɾ�������ʱ�ļ�
        tmp.deleteOnExit();
        RandomAccessFile raf = new RandomAccessFile(fileName,"rw");
        FileInputStream fis = new FileInputStream(tmp);
        FileOutputStream fos = new FileOutputStream(tmp);
        byte[] bbuff = new byte[64];
        int hasRead = 0;
        //��λ��posλ��
        raf.seek(pos);
        //��pos��ʼһֱ��ȡ���ļ�ĩβ,��д�뵽tmp�����ʱ�ļ���
        while((hasRead=raf.read(bbuff))>0){
            fos.write(bbuff,0,hasRead);
        }
        //���¶�λ��posλ��
        raf.seek(pos);
        //�������������
        raf.write(insertContent.getBytes());
        //Ȼ���ں���׷��tmp�ļ��������
        while ((hasRead=fis.read(bbuff))>0){
            raf.write(bbuff,0,hasRead);
        }
        raf.close();
        fis.close();
        fos.close();

    }

    public static void main(String[] args) throws IOException {
        //���������insert����
        insert("./src/Test.java",46,"fuck your mother!this is just a test!");
    }
}
