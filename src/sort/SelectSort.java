package sort;

import java.lang.reflect.Array;

/**
 * @Auther: discat
 * @Email: distantcat@126.com
 * @Date: 2018-11-13 15:50
 * @Description: 选择排序 找出 最小值 放到第一个 ，然后依次，知道有序
 */
public class SelectSort {
    public static void selectSort(int[] arr) {
        int len = arr.length;
        int i , j , min, temp;
        for (i = 0; i < len -1; i++) {
            min = i;
            for (j = min + 1; j < len; j++) {
                if (arr[min] > arr[j]) {
                    min = j; //记住最小值
                }
            }
            if (min != i) {
                temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {13,1,2,5,3,4,6,8,7,9,11};
        selectSort(arr);
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + "  ");
        }
    }
}
