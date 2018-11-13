package sort;

/**
 * @Author dengjing
 * @Date Created in 15:19 2018/3/29.
 * @Description: 插入排序  选择第一个数为最小值
 * @Modified By:
 */
public class InsertSort {

    public static int[]  insertSort(int[] arrays) {
        int temp;  //临时变量
        int len = arrays.length;
        for (int i = 1; i < len; i++) { //外层向右的index，即作为比较对象的数据的index
            temp = arrays[i]; //用作比较的数据
            int j = i - 1;
            while (j >= 0 && arrays[j] > temp) { //当比到最左边或者遇到比temp小的数据时，结束循环
                arrays[j+1] = arrays[j]; //3 2  -->  3 3   |  2 3 1 -->   2 3 3 -->  2 2 3  左边比右边大 ，后移一位
                j--;
            }
            arrays[j+1] = temp;  //3 3 --> 3 2  |  2 2 3 --> 1 2 3 把 temp 插入 比它小的数后面
        }
        return arrays;
    }

    public static void main(String[] args) {
        int[] arrs = {13,3,2,3,4,6,8,9,11};
        int[] ints = insertSort(arrs);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] +"  ");
        }
    }
}
