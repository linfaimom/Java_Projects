import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2015/11/25.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        int hasRead=0;
        byte[] buff = new byte[64];
        try {
            fis = new FileInputStream(new File("lalala.txt"));
            while ((hasRead = fis.read(buff)) != -1){
                System.out.println(hasRead);
                System.out.println(new String(buff,0,hasRead));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            fis.close();
        }
    }
}
