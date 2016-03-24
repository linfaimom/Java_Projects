import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by marcus on 16/3/13.
 */

public class Test {

    //this method show availableCharsets in the system.
    public static void printCharset(){
        Map charSet = Charset.availableCharsets();
        Iterator iterator = charSet.keySet().iterator();
        while (iterator.hasNext()){
            //print all the charset languages
            String csName = (String) iterator.next();
            System.out.print(csName);
            //print the aliases of these languages
            Iterator aliases = ((Charset)charSet.get(csName)).aliases().iterator();
            if (aliases.hasNext()){
                System.out.print(":");
            }
            while (aliases.hasNext()){
                System.out.print(aliases.next());
                if (aliases.hasNext()){
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

    //test ByteBuffer
    public static void testByteBuffer(){
        final int SIZE = 1024;
        ByteBuffer bb = ByteBuffer.allocate(SIZE);
        //show limit of this ByteBuffer
        System.out.println(bb.limit());
        //as a int
        bb.asIntBuffer().put(1000);
        System.out.println(bb.getInt());
        bb.rewind();    //clear
        //as a char
        char c;
        bb.asCharBuffer().put("Marcus");
        while ((c = bb.getChar()) != 0){
            System.out.print(c+" ");
        }
        bb.rewind();
        //as a double
        //......
    }

    //test IntBuffer
    public static void testIntBuffer(){
        final int SIZE = 1024;
        ByteBuffer bb = ByteBuffer.allocate(SIZE);
        IntBuffer ib = bb.asIntBuffer();
        ib.put(new int[]{11,21,31,22,51,0,0,25,40});
        System.out.println(ib.get(3));
        System.out.println();
        ib.rewind();
        while (ib.hasRemaining()){
            int i = ib.get();
            if (i==0){
                continue;
            }
            System.out.println(ib.position()+":"+i);
        }
    }

    public static void main(String[] args) {
        //printCharset();
        //testByteBuffer();
        //testIntBuffer();
        try {
            FileChannel channel = new FileOutputStream("./sb.txt").getChannel();
            ByteBuffer bb = ByteBuffer.wrap(new byte[]{'C','h','i','n','a'});
            //set the position and the limit
            bb.position(1);
            bb.limit(4);
            channel.write(bb);
            //set the position to 0, and set limit to the capacity of bb
            bb.clear();
            System.out.println(bb.limit());
            channel.write(bb);
            bb.clear();
            channel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
