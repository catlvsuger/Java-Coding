import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Auther: discat
 * @Email: distantcat@126.com
 * @Date: 2018-10-23 17:58
 * @Description: 数组去重
 */
public class Array {
    public static void main(String[] args) {
        int[] arr = {1,2,3,32,2,1,3,5,3,5};
        moveSame(arr);
    }

    /*
        数组去除重复数字
     */
    private static void moveSame(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!list.contains(arr[i])) {
                list.add(arr[i]);
            }
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
