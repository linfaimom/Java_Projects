//测试RandomAccessFile随机读写类

package task9_8;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Task9_8 {
	public static void main(String[] args) {
		try {
			//创建对象，支持读和写
			RandomAccessFile raf = new RandomAccessFile("./data.dat","rw");
			
			//创建10个随机数并写入文件
			for (int i = 0; i < 10; i++) {
				int n = (int)(Math.random()*90+10);
				raf.writeInt(n);
			}
			
			//选择排序
			for (int i = 0; i < 9; i++) {
				//定位到第i个数
				raf.seek(i*4);
				//读取一个整数到iData
				int iData = raf.readInt();
				for (int j = i+1; j < 10; j++) {
					raf.seek(j*4);
					int jData = raf.readInt();
					if(jData>iData){
						//若jData较大，则把iData位置的数据覆盖为jData，由此可见本程序是按从大到小顺序排列
						raf.seek(i*4);
						raf.writeInt(jData);
						raf.seek(j*4);
						raf.writeInt(iData);
						//让iData记录两者中的较大值
						iData = jData;
					}
				}
			}
			
			//从文件中读取排序后的数字，输出到屏幕
			for (int i = 0; i < 10; i++) {
				raf.seek(i*4);
				int read = raf.readInt();
				System.out.println(read);	
			}
			
			//关闭随机读写
			raf.close();
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
	}
}
