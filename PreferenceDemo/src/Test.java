import java.util.Arrays;
import java.util.Iterator;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * Created by marcus on 16/3/17.
 */
public class Test {
    public static void main(String[] args) throws BackingStoreException {
        Preferences preferences = Preferences.userNodeForPackage(Test.class);
        preferences.put("lalala","fuck");
        preferences.putInt("int",5);
        preferences.putBoolean("boolean",true);
        preferences.putDouble("double",2.5d);
        preferences.putFloat("float",5.8f);
        //the second arg in get...() 's usage is that when there's no such key you have put,
        //use the arg's value.
        float f = preferences.getFloat("float",10.8f);
        f += 4;
        System.out.println(f);
        //it can also use a iterator to show all things
        Iterator iterator = Arrays.asList(preferences.keys()).iterator();
        while (iterator.hasNext()){
            String key = (String) iterator.next();
            System.out.println(key + ":" + preferences.get(key,null));
        }
    }
}
