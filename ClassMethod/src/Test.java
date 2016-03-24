import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by marcus on 16/3/10.
 */

class Groundhog{
    int num;
    String name;

    public Groundhog(int num){
        this.num = num;
        System.out.println("num is : " + this.num);
    }

    public Groundhog(String name){
        this.name = name;
        System.out.println("name is : " + this.name);
    }

}

public class Test {

    public static void detect(Class gh) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Map map = new HashMap<>();
        Constructor[] constructors = gh.getConstructors();

        for (int i=0; i<10; i++){
            map.put(constructors[0].newInstance(i), i * i);
        }

        System.out.println(map);

        map.clear();

        for (int i=0; i<10; i++){
            map.put(constructors[1].newInstance("name"+i), i*i);
        }

        System.out.println(map);
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        detect(Groundhog.class);
    }
}
