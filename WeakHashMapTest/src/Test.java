import java.util.Iterator;
import java.util.WeakHashMap;

/**
 * Created by marcus on 16/3/12.
 */

class Key{
    String ident;

    public Key(String id){
       ident = id;
    }

    @Override
    public int hashCode() {
        return ident.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Key) && (ident.equals(((Key)obj).ident));
    }

    @Override
    public String toString() {
        return ident;
    }
}

class Value{
    String ident;

    public Value(String id){
        ident = id;
    }

    @Override
    public String toString() {
        return ident;
    }
}

public class Test {
    public static void main(String[] args) {
        int size = 10;
        Key[] keys = new Key[size];
        WeakHashMap map = new WeakHashMap();
        for (int i=0; i<size; i++){
           Key k = new Key(Integer.toString(i));
           Value v = new Value(Integer.toString(i));
           if (i % 3 == 0){
               keys[i] = k;
           }
           map.put(k,v);
        }
        System.out.println(map);
        /*Iterator iterator = map.entrySet().iterator();  //entrySet()方法生成一个由Map.entry对象组成的Set,这个Set也包含映射关系
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/
        System.gc();
        System.out.println(map);
        //结果显而易见,除了放入数组中的,其他的引用全被回收了
    }
}
