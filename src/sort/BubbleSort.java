package sort;

/**
 * @Author dengjing
 * @Date Created in 11:05 2018/3/28.
 * @Description: bubleSort 冒泡排序
 * @Modified By:
 */
public class BubbleSort {

    public static void bubbleSort(int[] arrays) {
        int len = arrays.length-1;
        int isChange; //交换标志位 0 没有交换，
        int tmp;
        int n = 0;
        for (int i = 0 ; i < len ; i++) {
            isChange = 0;
            for(int j = 0 ; j < len-i ; j++) {
                n++;
                if (arrays[j] > arrays[j+1]) {
                    isChange = 1;
                    tmp = arrays[j];
                    arrays[j] = arrays[j+1];
                    arrays[j+1] = tmp;
                }
            }
            if (isChange == 0) {
                break;
            }
        }
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }
        System.out.println(n);

    }

    public static void main(String[] args) {
        int[] arrs = {13,1,2,3,4,6,8,7,9,11};
        bubbleSort(arrs);
    }
}
