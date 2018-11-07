package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: discat
 * @Email: distantcat@126.com
 * @Date: 2018-10-29 10:05
 * @Description:
 */
public class JDKProxy implements InvocationHandler {
    /*需要代理的类*/
    private Object target;

    public Object newProxy(Object target) {
        this.target = target;
        /*返回代理对象*/
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /*
        proxy:　　指代我们所代理的那个真实对象
        method:　　指代的是我们所要调用真实对象的某个方法的Method对象
        args:　　指代的是调用真实对象某个方法时接受的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 一般我们进行逻辑处理的函数比如这个地方是模拟检查权限
        //　　在代理真实对象前我们可以添加一些自己的操作
        System.out.println("before jdk proxy");
        System.out.println("Method:" + method);

        checkPopedom();

        // 设置方法的返回值
        Object ret = null;
        //调用方法的invoke 方法，ret 为返回的返回值
        ret = method.invoke(target,args);
        System.out.println("after jdk proxy");
        return ret;
    }

    private void checkPopedom() {
        System.out.println("调用JDK代理，检查操作权限");
    }
}
