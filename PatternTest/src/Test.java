import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by marcus on 16/3/17.
 */
public class Test {
    public static void main(String[] args) {
        String regex = "\\w+";
        StringBuilder result = new StringBuilder(" ");
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher("Marcus Lin");
        m.reset("hahaha,you are just a stupid boy");
        while (m.find()){
            result.append(m.group() + " ");
        }
        System.out.println(result);
    }
}
