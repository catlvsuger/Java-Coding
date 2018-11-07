import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Auther: discat
 * @Email: distantcat@126.com
 * @Date: 2018-10-23 15:13
 * @Description: 反射获取数组类型
 */
public class InvokeArray {
    public static void main(String[] args) {
        System.out.println(int[].class.getName());
        for (Field field: int[].class.getFields()) {
            System.out.println(field.getName());
        }
        for (Method method: int[].class.getMethods()) {
            System.out.println(method.getName());
        }
        for (Constructor constructor : int[].class.getConstructors()){
            System.out.println(constructor.getName());
        }
    }
}
