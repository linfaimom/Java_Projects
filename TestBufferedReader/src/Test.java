import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2015/11/22.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        //读取从键盘中输入的字节流
        InputStreamReader isr = new InputStreamReader(System.in);
        //利用BufferedReader将其转化为字符流
        BufferedReader br = new BufferedReader(isr);
        //保存每行读取的字符串
        String line = null;

        //一行一行的读取，即每次读取换行符之前的字符
        while((line = br.readLine()) != null){
            //当输入的字符为exit的时候，结束
            if(line.equals("exit")){
                System.out.println("程序结束!");
                System.exit(1);
            }
            System.out.println("输出的内容为:"+line);
        }
        isr.close();
        br.close();
    }
}
