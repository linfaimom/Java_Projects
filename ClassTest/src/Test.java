import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by marcus on 16/3/7.
 */
interface Man{}
interface Women{}

class RenYao{}
class ThailandRY extends RenYao implements Man,Women{
}

public class Test {

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("ThailandRY");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Object o;
        try {
            o = c.newInstance();
            System.out.println(o.getClass());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(c.getName());
        System.out.println(c.getSuperclass());
        Class[] interfaces = c.getInterfaces();
        for (int i=0;i<interfaces.length;i++){
            System.out.print(interfaces[i]+" ");
        }
        System.out.println();

    }
}
