import java.io.*;

/**
 * Created by Adminifuck your mother!this is just a test!fuck your mother!this is just a test!strator on 2015/11/23.
 */
public class Test {
    public static void insert(String fileName, long pos, String insertContent) throws IOException {
        //创建一个临时文件用于保存指定位置后的所有内容
        File tmp = File.createTempFile("tmp",null);
        //在退出后删除这个临时文件
        tmp.deleteOnExit();
        RandomAccessFile raf = new RandomAccessFile(fileName,"rw");
        FileInputStream fis = new FileInputStream(tmp);
        FileOutputStream fos = new FileOutputStream(tmp);
        byte[] bbuff = new byte[64];
        int hasRead = 0;
        //定位到pos位置
        raf.seek(pos);
        //从pos开始一直读取到文件末尾,并写入到tmp这个临时文件中
        while((hasRead=raf.read(bbuff))>0){
            fos.write(bbuff,0,hasRead);
        }
        //重新定位到pos位置
        raf.seek(pos);
        //插入输入的内容
        raf.write(insertContent.getBytes());
        //然后在后面追加tmp文件里的内容
        while ((hasRead=fis.read(bbuff))>0){
            raf.write(bbuff,0,hasRead);
        }
        raf.close();
        fis.close();
        fos.close();

    }

    public static void main(String[] args) throws IOException {
        //调用上面的insert方法
        insert("./src/Test.java",46,"fuck your mother!this is just a test!");
    }
}
