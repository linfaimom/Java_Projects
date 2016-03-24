import java.io.*;
import java.util.zip.GZIPOutputStream;

/**
 * Created by marcus on 16/3/15.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream("test.txt"));
        BufferedOutputStream writer = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("test.gz")));
        int hasRead;
        while ((hasRead=reader.read()) != -1){
            writer.write(hasRead);
        }
        reader.close();
        writer.close();
    }
}
