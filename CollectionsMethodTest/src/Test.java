import sun.misc.Regexp;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by marcus on 16/3/12.
 */

public class Test {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        for (int i=0; i<20; i++){
            list.add(i);
        }
        System.out.println(list);
        //max
        System.out.println(Collections.max(list));
        //min
        System.out.println(Collections.min(list));
        //swap
        Collections.swap(list,0,list.size()-1);
        System.out.println(list);
        //reverse
        Collections.reverse(list);
        System.out.println(list);
        //shuffle,random
        Collections.shuffle(list);
        System.out.println(list);
        //replace
        for (int i=0; i<list.size(); i++){
            Collections.replaceAll(list,new Integer(i),100);
        }
        System.out.println(list);
        //change to readonly collection
        Collection readOnly = Collections.unmodifiableCollection(list);
//        readOnly.add("lalala");  //will cause UnsupportedOperationException
        System.out.println(readOnly);

        //UnsupportedMethods after do a Arrays.asList(),but you can use those methods by
        //List test = new ArrayList<>(Arrays.asList("one two three four five".split(" ")));
        //just use the Arrays.asList() as the constructor of ArrayList
        List test = Arrays.asList("one two three four five".split(" "));
        List a = test.subList(0,3);
        System.out.println(test);
        System.out.println(a);
        //methods below this line are not supported
        //test.add("six");
        //System.out.println(test);
        //test.clear();
        //System.out.println(test);
        //test.addAll(list);
        //test.retainAll(list);
        //test.remove(a.get(0));
        //System.out.println(test);
        //test.removeAll(a);
        //System.out.println(test);

    }
}
