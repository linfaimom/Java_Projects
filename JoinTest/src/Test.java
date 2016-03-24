/**
 * Created by marcus on 16/3/20.
 */

class Sleeper extends Thread{
    int duration;

    public Sleeper(String name, int sleepTime){
        super(name);
        duration = sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted!" + " .isInterrupted:" + isInterrupted());
        }
        System.out.println(getName() + " nature awaken!");
    }
}

class Joiner extends Thread{
    Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper){
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            new RuntimeException(e);
        }
        System.out.println(getName() + " join completed!");
    }
}

public class Test extends Thread {
    public static void main(String[] args) {
        Sleeper
                sleepy = new Sleeper("Sleepy",1500),
                grumpy = new Sleeper("Grumpy",1500);

        Joiner
                dopey = new Joiner("Dopey",sleepy),
                doc = new Joiner("Doc",grumpy);

        grumpy.interrupt();  //从中可以看出,不论打断与否,doc要在grumpy后执行.

    }
}
