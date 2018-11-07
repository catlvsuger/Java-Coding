/**
 * @Auther: discat
 * @Email: distantcat@126.com
 * @Date: 2018-10-12 17:02
 * @Description:已知一个字符数组，其中存储有 R、G、B 字符，要求将所有的字符按照 RGB 的顺序进行排序。
 * 比如给定一个数组为 char s[] = "RGBBRGGBGB"，则排序后应该为 RRGGGGBBB
 */
public class RGBSort {

    private static String replaceIndex(int start,int end, String res,String str){
        StringBuilder sb = new StringBuilder(res);
        sb.replace(start, end, str);
        return sb.toString();
    }

    public static  String  swapChar(String s , int i, int j) {
        char tmp = s.charAt(i);
        s = replaceIndex(i,i+1, s, String.valueOf(s.charAt(j)));
        return replaceIndex(j,j+1, s, String.valueOf(tmp));
    }

    public static String rgbSortOnce(String s) {
        int len = s.length()-1;
        int r = -1, g = -1; //++r和++g分别指向R和G交换的位置
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'R') {
                s = swapChar(s, ++r, i);
                ++g;
                if(s.charAt(i) == 'G') {
                    s = swapChar(s, g, i);
                }
            }else if (s.charAt(i)  == 'G') { // 遇到G
               s =  swapChar(s, ++g, i);
            } else {                   // 遇到B，什么都不做
            }
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(swapChar("RGB", 0,0));
        System.out.println(rgbSortOnce("GRGBBRGGBGB"));
    }
}
