package proxy;

/**
 * @Auther: discat
 * @Email: distantcat@126.com
 * @Date: 2018-10-29 10:19
 * @Description:  测试 jdk ，CGLib 需要jar 懒
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("**********************JDKProxy**********************");
        JDKProxy jdkProxy = new JDKProxy();
        IUserManager userManager = (IUserManager) jdkProxy.newProxy(new UserManagerImpl());
        System.out.println(userManager.getClass().getName());
        userManager.addUser("test", "test");

    }
}
