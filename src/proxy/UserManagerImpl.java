package proxy;

/**
 * @Auther: discat
 * @Email: distantcat@126.com
 * @Date: 2018-10-29 10:03
 * @Description: 用户实现类  （被代理的类）
 */
public class UserManagerImpl implements  IUserManager {
    @Override
    public void addUser(String id, String password) {
        System.out.println("调用了UserManagerImpl.addUser方法");
    }
}
