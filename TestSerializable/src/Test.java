import java.io.*;

/**
 * Created by Administrator on 2015/11/23.
 */

//创建一个Person类,继承Serializable接口
class Person implements Serializable{
    String name;
    int age;
    public Person(String name, int age){
        System.out.println("带参数的构造方法");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person p = new Person("John Lin",19);
        //创建一个处理流，里面包含了一个字节流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("godxiang.txt"));
        //将p对象写入到文件里
        oos.writeObject(p);
        //调用下面那个方法，读取刚写入文件中的信息
        readJustObject();
    }

    //定义一个方法，从文件中读取出写入的对象信息
    public static void readJustObject() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("godxiang.txt"));
        Person p = (Person)ois.readObject();
        System.out.println("名字为:"+p.getName()+""+"年龄为:"+p.getAge());
    }
}
