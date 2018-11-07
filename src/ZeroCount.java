import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @Auther: discat
 * @Email: distantcat@126.com
 * @Date: 2018-10-23 16:59
 * @Description: 求 零 的个数
 */
public class ZeroCount {
    public static void main(String[] args) {
        System.out.println("1000!尾部0的个数："+ zeroCount(1000));
        System.out.println("1000!中 0的个数： " + zeroCount2(1000));
    }

    /*
    1000的阶乘有多少个0
     */
    private static int zeroCount2(int n) {
        BigInteger bi = new BigInteger("1");
        for (int i = 2; i <= n ; i++) {
            bi = bi.multiply(BigInteger.valueOf(i));
        }
        int num = 0;
        String s = bi.toString();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                num++;
            }
        }
        return  num;
    }

    /*
    阶乘 最后0的个数 因子 2 * 5   2的个数比5多，求含有5因子的个数即可
     */
    private static int zeroCount(int n) {
        int count = 0;
        while (n >= 5) {
            n = n / 5;
            count += n;
        }
        return count;
    }

}
