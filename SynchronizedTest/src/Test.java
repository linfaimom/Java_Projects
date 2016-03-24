/**
 * Created by marcus on 16/3/22.
 */


class DualSync{

    private Object syncObject = new Object();

    public synchronized void f(){
        System.out.println("inside f()");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("exit f()");
    }

    public void g(){
        synchronized (syncObject){
            System.out.println("inside g()");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("exit g()");
        }
    }
}

public class Test {

    public static void main(String[] args) {

        DualSync test = new DualSync();

        new Thread(){
            @Override
            public void run() {
                test.f();
            }
        }.start();

        test.g();

    }
}
