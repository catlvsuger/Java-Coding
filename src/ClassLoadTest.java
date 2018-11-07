/**
 * @Auther: discat
 * @Email: distantcat@126.com
 * @Date: 2018-10-23 15:33
 * @Description:  类加载机制
 */
public class ClassLoadTest {
    public static void main(String[] args) {
        //调用class加载器 appClassLoader   sun.misc.Launcher$AppClassLoader@18b4aac2
        ClassLoader cl = ClassLoadTest.class.getClassLoader();
        System.out.println(cl);
        //调用父类加载器 extClassloader   sun.misc.Launcher$ExtClassLoader@1b6d3586
        ClassLoader clParent = cl.getParent();
        System.out.println(clParent);
        //调用根加载器 BootStrap    null
        ClassLoader clRoot = clParent.getParent();
        System.out.println(clRoot);
    }
}

class Test1 {
    public static void main(String[] args) {
        System.out.println(Test1.class.getClassLoader());
        Test2 test2 = new Test2();
        test2.print();
    }
}

class Test2 {
    public void print() {
        System.out.println(Test2.class);
        System.out.println(this.getClass());
        System.out.println(Test2.class.getClassLoader());
    }
}