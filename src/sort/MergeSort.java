package sort;

/**
 * @Auther: discat
 * @Email: distantcat@126.com
 * @Date: 2018-11-14 15:22
 * @Description: 归并排序，是利用归并的思想实现的排序方法，该算法采用经典的分治（divide-and-conquer）策略
 * （分治法将问题分(divide)成一些小的问题然后递归求解，
 * 而治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之)。
 */
public class MergeSort {

    public static void sort(int[] arr) {
        ////在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[] temp = new int[arr.length];
        sort(arr,0,arr.length -1,temp);
    }

    /*
        递归 分
     */
    private static void sort(int[] arr, int left, int right, int[] temp) {
        if(left < right) {
            int mid = (left + right) >>> 1;
            sort(arr, left, mid, temp); //左边归并排序
            sort(arr,  mid + 1, right, temp); //右边归并排序
            merge(arr, left, mid, right, temp);
        }
    }

    /*
        合并排序
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left; // 左序列指针
        int j = mid + 1; //右序列指针
        int t  = 0 ; // 临时数组指针
        while (i <= mid && j <= right ) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {13,11,6,6,4,2,11,0, 32, 2, 5, 19};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }
}
