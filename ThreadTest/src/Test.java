import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by marcus on 16/3/19.
 */
public class Test extends Thread{

    int count = 5;
    volatile double d;

    public Test(){
        super();
        start();
    }

    public Test(String name, int priority){
        super(name);
        setPriority(priority);
        start();
    }

    public Test(String name){
        super(name);
        start();
    }

    @Override
    public String toString() {
        return "#"+getName()+":"+count;
    }

    @Override
    public void run() {
        while (count>0){
            System.out.println(this);
            for (int i=0; i<100000; i++){
                d /= (i+1);
            }
            if (count==0){
                return;
            }
            count--;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Test("cat",MAX_PRIORITY).getPriority());
        for (int i=0; i<3; i++){
            System.out.println(new Test(Integer.toString(i),MIN_PRIORITY).getPriority());
        }

    }
}
