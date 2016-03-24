import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by marcus on 16/3/19.
 */
public class Test {
    public static void main(String[] args) {
        BufferedReader reader = null;
        LinkedList list = new LinkedList();
        String result = "";
        try {
            reader = new BufferedReader(new FileReader("test.txt"));
            while ((result=reader.readLine()) != null){
                list.add(result);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
    }
}
