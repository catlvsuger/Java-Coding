package sort;

/**
 * @Author dengjing
 * @Date Created in 11:05 2018/3/28.
 * @Description: bubleSort 冒泡排序
 * @Modified By:
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int len = arr.length - 1;
        int isChange; //交换标志位 0 没有交换，
        int tmp;
        int n = 0;
        for (int i = 0 ; i < len; i++) {
            isChange = 0;
            for(int j = 0 ; j < len - i  ; j++) {
                n++;
                if (arr[j] > arr[j+1]) {
                    isChange = 1;
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
            if (isChange == 0) {
                break;
            }
        }
        System.out.println(n);

    }


    public static void main(String[] args) {
        int[] arr = {13,9,8,7,6,5,4,3,2,1};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
