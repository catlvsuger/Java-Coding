package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @Auther: discat
 * @Email: distantcat@126.com
 * @Date: 2018-10-23 15:01
 * @Description:
 */
public class ProxyTest {
    public static void main(String[] args) {
        Collection proxy = (Collection) Proxy.newProxyInstance(Collection.class.getClassLoader(), new Class[]{Collection.class}, new InvocationHandler() {
            ArrayList<Object> target = new ArrayList();
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                long begin = System.currentTimeMillis();
                Object retValue = method.invoke(target, args);
                long end = System.currentTimeMillis();
                System.out.println("运行时间： " + (end - begin));
                return retValue;
            }
        });
        proxy.add("adb");
        System.out.println(proxy);
        System.out.println(proxy.getClass().getName());
    }
}
