import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;

/**
 * Created by marcus on 16/3/23.
 */

class Sender extends Thread{
    private Random random = new Random();
    private PipedWriter pw;

    public Sender(){
        pw = new PipedWriter();
    }

    public PipedWriter getPw(){
        return pw;
    }

    @Override
    public void run() {
        for (char c='A'; c<='z'; c++){
            try {
                pw.write(c);
                sleep(random.nextInt(500));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Receiver extends Thread{
    private PipedReader in;

    public Receiver(Sender sender) throws IOException {
        in = new PipedReader(sender.getPw());
    }

    @Override
    public void run() {
        while (true){
            try {
                System.out.println("Read: " + (char)in.read());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Test {
    public static void main(String[] args) throws IOException {
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);
        sender.start();
        receiver.start();
    }
}
