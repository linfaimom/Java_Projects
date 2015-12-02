package fileoutputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class TestFileOutputStream {
	public static void main(String[] args) {
		File f = new File("hello.txt");
		String s = "»¶Ó­Welcome!";
		byte[] b = s.getBytes();
		try {
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(b);
			fos.close();
			FileInputStream fis = new FileInputStream(f);
			int count = 0;
			while((count=fis.read(b,0,2))!=-1){
				String str = new String(b,0,count);
				System.out.println(str);
			}
			fis.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
