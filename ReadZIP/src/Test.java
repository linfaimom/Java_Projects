import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * Created by marcus on 16/3/16.
 */
public class Test {

    public static void main(String[] args) {
        //read files from zip file
        ZipFile files = null;
        try {
            files = new ZipFile("/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/src.zip");
            System.out.println(files.getComment());
            System.out.println(files.getName());
            System.out.println(files.size());
            Enumeration enumeration = files.entries();
            while (enumeration.hasMoreElements()){
                System.out.println(enumeration.nextElement());
            }
            files.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //add file to zip
        ZipOutputStream out = null;
        FileInputStream in = null;
        try {
            out = new ZipOutputStream(new FileOutputStream("sb.zip"));
            out.putNextEntry(new ZipEntry("sb.txt"));
            in = new FileInputStream("sb.txt");
            byte[] bytes = new byte[64];
            int hasRead;
            while ((hasRead=in.read(bytes)) != -1){
                out.write(bytes,0,hasRead);
            }
            System.out.println("output ok");
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
