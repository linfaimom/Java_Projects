package task9_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class FileEncryption{
	private String password;
	public void setPwd(String pwd){
		password = pwd;
	}
	//定义一个加密文件的方法
	public boolean encryption(String inFile, String outFile) throws IOException{
		File file = new File(inFile);
		byte[] key = password.getBytes();
		byte[] buffer = new byte[key.length];
		int hasRead;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file);
			fos = new FileOutputStream(outFile);
			while ((hasRead=fis.read(buffer)) != -1) {
				for (int i = 0; i < key.length; i++) {
					buffer[i]=(byte)(buffer[i]^key[i]);
				}
				fos.write(buffer,0,hasRead);
			}
			return true;
		} catch (Exception e) {
			return false;
		}finally{
			fis.close();
			fos.close();
		}
	}
	
	public boolean decryption(String inFile, String outFile) throws IOException{
		return encryption(inFile, outFile);
	}
}

public class Task9_3 {
	public static void main(String[] args) throws IOException {
		FileEncryption fe = new FileEncryption();
		fe.setPwd("dswybs");
		fe.encryption("D:\\aa.txt", "D:\\encrptedaa.txt");
		fe.decryption("D:\\encrptedaa.txt", "D:\\decrytedaa.txt");
		System.out.println("OK");
	}
}
