import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by marcus on 16/3/20.
 */

class RunThread {

    private int count = 5;

    public RunThread(String name) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count > 0) {
                    System.out.println(Thread.currentThread().getName() + " : " + count);
                    count--;
                }
            }
        }, name).start();
    }
}


class TimeOut extends Timer{

    public TimeOut(int delay, final String msg){
        super(true);
        schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(msg);
                System.exit(0);
            }
        },delay);
    }
}


public class Test{

    public static void main(String[] args) throws InterruptedException {
        //new RunThread("Cat");
        new TimeOut(1000,"lalala,demaxiya!");
        Thread.sleep(1000);
    }
}
