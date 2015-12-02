import java.io.IOException;
import java.net.*;

/**
 * Created by Administrator on 2015/11/25.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        InetAddress ip = InetAddress.getByName("www.google.com");
        System.out.println(ip.getHostName());
        System.out.println(ip.getHostAddress());
        InetAddress localIP = InetAddress.getLocalHost();
        System.out.println(localIP);
        System.out.println(localIP.getHostName());
        System.out.println(localIP.getHostAddress());
        System.out.println(localIP.getCanonicalHostName());
        String decoder = URLDecoder.decode("%E7%96%AF%E7%8B%82","utf-8");
        System.out.println(decoder);
        String encoder = URLEncoder.encode("疯狂","utf-8");
        System.out.println(encoder);
    }
}

