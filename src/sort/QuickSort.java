package sort;

/**
 * @Author dengjing
 * @Date Created in 16:45 2018/4/2.
 * @Description: 快速排序
 * @Modified By:
 */
public class QuickSort {

    public static int[] quickSort(int[] arr , int L , int R) {
        int i = L;
        int j = R;
        int pivot = arr[(L+R)/2];
        //左右两端进行扫描，只要两端还没有交替，就一直扫描
        while (i<=j) {
            while (arr[i]< pivot) i++;
            while (arr[j]> pivot) j--;
            //此时已经分别找到了比支点小的数(右边)、比支点大的数(左边)，它们进行交换
            if (i<=j) {
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
                i++;
                j--;
            }
        }
        //“左边”再做排序，直到左边剩下一个数(递归出口)
        if (L < j){
            quickSort(arr , L, j);
        }
        //“右边”再做排序，直到右边剩下一个数(递归出口)
        if (i < R) {
            quickSort(arr , i, R);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arrs = {13,1,2,3,4,6,8,9,11};
        int[] arr = quickSort(arrs,0,arrs.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
