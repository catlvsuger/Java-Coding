import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: discat
 * @Email: distantcat@126.com
 * @Date: 2018-10-23 17:16
 * @Description: 算法题
 */
public class MathTest {

    public static void main(String[] args) {
        chickenCount();
        isPrimeNum(11);
        int[] input = {2, 3, 1, 0, 2, 5};
        int a = 0xffff, b = 0001;
        System.out.println(mean(a, b));
        System.out.println(mean1(a, b));
        System.out.println(mean2(a, b));
        System.out.println(mean3(a, b));

    }
    /*
        有溢出风险
     */
    public static int mean(int a, int b) {
        return  (a + b) / 2;
    }

    public static int mean1(int a, int b) {
        return  (a + b) >> 1;
    }

    public static int mean2(int a, int b) {
        return  (a + b) >>> 1;
    }

    public static int mean3(int a, int b) {
        return  (a & b) + ((a ^ b) >> 1);
    }


    /*
        一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，
        但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字
        解题思路 要求复杂度为 O(N) + O(1)，也就是时间复杂度 O(N)，空间复杂度 O(1)

     */
    public  int duplicate(int[] arr) {
        int n = arr.length;
        List<Boolean> list = new ArrayList<>();
        
        return  0;
    }

    /*
       100块买100只鸡 公鸡 3块1只 母鸡 2块1只 小鸡 1块3只 求刚好用完买100只有多少方案
     */
    public static void chickenCount() {
        for (int a = 0; a <= 33; a++) {
            for (int b = 0; b <= 50; b++) {
                int c = 100-a-b;
                if ((a*3+b*2+ c/3 == 100) && c%3 ==0) {
                    System.out.println("公鸡："+ a + "母鸡：" + b + "小鸡： " + c);
                }
                if (a*3 + b*2 + c/3 > 100) {
                    break;
                }
            }
        }
    }

    /*
        判断一个数是不是质数
     */
    private static String isPrimeNum(int i) {
        String restr = i +"是质数";
        for (int j = 2; j < i/2 ; j++) {
            if (i%j == 0 ) {
                restr = i + "不是质数";
                break;
            }
        }
        return  restr;
    }


}
