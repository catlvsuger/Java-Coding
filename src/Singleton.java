/**
 * @Auther: discat
 * @Email: distantcat@126.com
 * @Date: 2018-10-25 10:42
 * @Description: 懒汉式 volatile 避免jvm 乱序加载
 */
public class Singleton {
    private  Singleton() {}
    private volatile  static Singleton singleton = null;

    /**
     * 线程不安全
     * @return
     */
    public static Singleton getSingleton() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return  singleton;
    }

    /**
     * 添加synchronized同步 线程安全
     * @return
     */
    public static synchronized Singleton getSingleton2() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return  singleton;
    }

    /**
     * 双重检查
     * @return
     */
    public static Singleton getSingleton3() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return  singleton;
    }

    /**
     * 静态内部类：静态内部类比双重检查锁定和在getInstance()方法上加同步都要好，
     * 实现了线程安全又避免了同步带来的性能影响
     */
    private  static class  LazyHolder {
        //创建实例
        private static Singleton INSTANCE = new Singleton();

    }
    public static Singleton getSingleton4() {
        return LazyHolder.INSTANCE;
    }

}

/**
 * 枚举
 */
enum Singleton2 {
    INSTANCE;
    public void method() {

    }
}
