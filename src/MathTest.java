/**
 * @Auther: discat
 * @Email: distantcat@126.com
 * @Date: 2018-10-23 17:16
 * @Description:
 */
public class MathTest {

    public static void main(String[] args) {
        chickenCount();
        isPrimeNum(11);
    }

    /*
       100块买100只鸡 公鸡 3块1只 母鸡 2块1只 小鸡 1块3只 求刚好用完买100只有多少方案
     */
    private static void chickenCount() {
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
