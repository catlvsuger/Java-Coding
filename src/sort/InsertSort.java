package sort;

/**
 * @Author dengjing
 * @Date Created in 15:19 2018/3/29.
 * @Description: 插入排序  选择第一个数为最小值
 * @Modified By:
 */
public class InsertSort {

    public static void   insertSort(int[] arr) {
        int len = arr.length;
        int i, j , temp;
        for (i = 1; i < len; i++) { //外层向右的index，即作为比较对象的数据的index
            temp = arr[i]; //用作比较的数据
            j = i ;
            while (j >= 1 && arr[j - 1] > temp) { //当比到最左边或者遇到比temp小的数据时，结束循环
                arr[j] = arr[j - 1]; // 后一个数比前一个数小， 前一个数往后移一位，3 2  -->  3 3   |  2 3 1 -->   2 3 3 -->  2 2 3  左边比右边大 ，后移一位
                j--;
            }
            arr[j] = temp;  //3 3 --> 3 2  |  2 2 3 --> 1 2 3 把 temp 插入 比它小的数后面
        }
    }

    public static void main(String[] args) {
        int[] arr = {13,31,2,3,42,6,8,9,11};
        insertSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] +"  ");
        }
    }
}
