import java.io.*;

/**
 * Created by marcus on 16/3/16.
 */
public class FreezeAlien {
    public static void main(String[] args) {
        Alien alien = new Alien();
        ObjectOutputStream oos;
        ObjectInputStream ois;
        FileOutputStream out;
        FileInputStream in;
        try {
            out = new FileOutputStream("x.txt");
            oos = new ObjectOutputStream(out);
            oos.writeObject(alien);
            System.out.println("done output");
            out.close();
            oos.close();
            in = new FileInputStream("x.txt");
            ois = new ObjectInputStream(in);
            System.out.println(ois.readObject().getClass());
            in.close();
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
