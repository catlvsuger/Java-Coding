/**
 * @Auther: discat
 * @Email: distantcat@126.com
 * @Date: 2018-10-23 09:28
 * @Description: 代码执行顺序
 */
class  C0 {
    int num = 1;

    {

        System.out.println("ClassOrder构造代码块: " + num);
        show();
    }

    void show() {
        System.out.println("ClassOrder show 方法: " + num);
    }

    C0() {
        super();
        System.out.println("ClassOrder构造方法: " + num);
    }
}

class C1 extends C0 {
    int num = 2;
    {
        System.out.println("C1构造代码块: " + num);
    }
    C1() {
        super();
        System.out.println("C1构造方法: " + num);
    }
    void show() {
        System.out.println("C1 show 方法: "+ num);
    }
}
public class ClassOrder {
    public static void main(String[] args) {
        new C1();
    }
}
