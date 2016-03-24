/**
 * Created by marcus on 16/3/20.
 */

class Daemon extends Thread{
    private Thread[] t = new Thread[10];

    public Daemon(){
        //must before start();
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        for (int i=0; i<t.length; i++){
            t[i] = new Daemons(i);
        }
        for (int i=0; i<t.length; i++){
            System.out.println("t[" + i +"] is daemon? " + t[i].isDaemon());
        }
        while (true){
            yield();
        }
    }
}

class Daemons extends Thread{
    public Daemons(int i){
        start();
        System.out.println("daemon " + i + " is started!");
    }

    @Override
    public void run() {
        while (true){
            yield();
        }
    }
}


public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Daemon();
        System.out.println("t is daemon ? " + t.isDaemon());
        //allow the daemon threads to finish their startup processes.
        //Thread.sleep(1000);
    }
}
