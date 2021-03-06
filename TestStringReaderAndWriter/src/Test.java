import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by Administrator on 2015/11/22.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        String src = "啦啦啦"
                +"德玛西亚"
                +"呜啦啦德玛西亚"
                +"日啊日啊德玛西亚";
        int hasRead;
        char[] read = new char[32];
        StringReader sr = new StringReader(src);

        while((hasRead = sr.read(read)) != -1){
            System.out.println(new String(read,0,hasRead));
        }
        sr.close();

        //利用StringWriter输出字符串
        StringWriter sw = new StringWriter();
        sw.write("爱存在\r\n");
        sw.write("这美丽新世界\r\n");
        sw.write("我喜欢\r\n");
        sw.write("自信的感觉\r\n");
        System.out.println(sw);
    }
}
