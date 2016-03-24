/**
 * Created by marcus on 16/3/23.
 *
 * 用TokyoHot里的两男操n女的剧情做例子,假设两个男优有等级关系,一个男的在干一个女的时候,另一个男的必须在一旁一直等候,也就是wait().当
 * 高等级男优干完一个后便通知低等级的干,每干完一个中间休息2秒,如此循环罔替,操完为止(共10个女优).
 *
 */


class FuckTurn{
    //the fuckTimes should be static,otherwise every instance will has its own fuckTimes, and then it can't be counted.
    private static int fuckTimes = 0;
    private int count = fuckTimes++;

    public FuckTurn(){
        if (count == 10){
            System.out.println("All girls had been fucked! Finished!");
            System.exit(0);
        }
    }

    @Override
    public String toString() {
        return "fuck the girl" + count;
    }

}

class AVMan1 extends Thread{
    //the man works for AV
    private AV av;

    public AVMan1(AV av){
        this.av = av;
        start();
    }

    @Override
    public void run() {
           while (true){
               while (av.turn == null){
                   synchronized (this) {
                       try {
                           wait();
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
               }
               System.out.println("AVMan1 " + av.turn);
               av.turn = null;
           }
       }
}

class AVMan2 extends Thread{
    private AV av;
    //they fuck the girl in turn, so he should notify the other.
    private AVMan1 avMan1;

    public AVMan2(AV av, AVMan1 avMan1){
        this.av = av;
        this.avMan1 = avMan1;
        start();
    }

    @Override
    public void run() {
        while (true){
            if (av.turn == null){
                av.turn = new FuckTurn();
                System.out.println("Time for avMan1 to fuck");
                //let the avMan1 to own the girl, so should use the avMan1 as an arg
                synchronized (avMan1){
                    //notify the avMan1 to fuck the girl.
                    avMan1.notify();
                }
            }

            //the avMan2 will have a break after he fucked the girl
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class AV {
    FuckTurn turn;

    public static void main(String[] args) {
        AV av = new AV();
        AVMan1 avMan1 = new AVMan1(av);
        AVMan2 avMan2 = new AVMan2(av,avMan1);
    }
}
