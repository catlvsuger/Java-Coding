package sort;

import java.lang.reflect.Array;

/**
 * @Auther: discat
 * @Email: distantcat@126.com
 * @Date: 2018-11-13 15:50
 * @Description: 选择排序 找出 最小值 放到第一个 ，然后依次，知道有序
 */
public class SelectSort {
    public static int[] selectSort(int[] arrays) {
        int len = arrays.length;
        for (int i = 0; i < len -1; i++) {
            int minIndex = i;
            for (int j = minIndex + 1; j < len; j++) {
                if (arrays[minIndex] > arrays[j]) {
                    minIndex = j; //记住最小值
                }
            }
            int tmp = arrays[minIndex];
            arrays[minIndex] = arrays[i];
            arrays[i] = tmp;
        }
        return  arrays;
    }

    public static void main(String[] args) {
        int[] arrs = {13,1,2,5,3,4,6,8,7,9,11};
        int[] ints = selectSort(arrs);
        for (int i = 0; i < ints.length ; i++) {
            System.out.print(ints[i] + "  ");
        }
    }
}
