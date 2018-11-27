package sort;

import java.util.Arrays;

/**
 * @Auther: discat
 * @Email: distantcat@126.com
 * @Date: 2018-11-15 10:33
 * @Description: 堆排序 步骤： 1.构建 大顶堆（小顶堆） 2. 堆顶和堆底元素交换，最大值沉到最后 3. 重复调整，下沉
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {112, 7, 4, 12, 45, 3, 90, 210, 6, 48};
        adjustDownToUp(arr, 1, arr.length);
        System.out.print("adjustDownToUp:    " );
        toString(arr);
        buildHeap(arr);
        System.out.print("buildHeap:    " );
        toString(arr);
        int[] insert = insert(arr, 500);
        System.out.print("insert:arr:    " );
        toString(arr);
        System.out.print("insert:insert:    " );
        toString(insert);
        int[] del =deleteMax(arr);
        System.out.print("del:arr    " );
        toString(arr);
        System.out.print("del:del    " );
        toString(del);

        heapSort(arr);
        heapSort(del);
        System.out.print("heapSort:arr:    " );
        toString(arr);
        System.out.print("heapSort:del:    " );
        toString(del);
    }
    /*
        打印
     */
    public static void toString(int[] array){
        for(int i:array){
            System.out.print(i+" ");
         }
        System.out.println(" ");
     }

    /*
        构建 大顶堆
     */
    public static  void buildHeap(int[] arr) {
        //从最后一个节点array.length-1的父节点（array.length-1-1）/2开始，直到根节点0，反复调整堆
        int length = arr.length;
        for (int i = (length-2) / 2;i >= 0; i--){
            adjustDownToUp(arr, i, length);
        }
    }

    /*
        调整，将元素arr[k]向下逐步调整树形结构
     */
    public static  void  adjustDownToUp(int[] arr, int k, int length) {
        int temp = arr[k];
        //i为初始化为节点k的左孩子，沿节点较大的子节点向下调整
        for (int i = 2 * k + 1; i < length; i = 2 * i + 1) {
            //取节点较大的子节点的下标
            if (i < length - 1 && arr[i] < arr[i+1]){
                //右孩子大则取右孩子节点下标
                i++;
            }
            //大于左右子节点，这不调整，否则将较大孩子调整到父节点
            if (temp >= arr[i]) {
                break;
            } else {
                arr[k] = arr[i];
                k = i;  //【关键】修改k值，以便继续向下调整
            }
        }
        arr[k] = temp;  //被调整的结点的值放人最终位置
    }

    /*
        堆排序
     */
    public static  void heapSort(int[] arr) {
        buildHeap(arr); //初始建堆，array[0]为第一趟值最大的元素
        int length = arr.length;
        for (int i = length -1; i >= 1 ; i--) {
            int temp = arr[0]; //将堆顶元素和堆低元素交换，即得到当前最大元素正确的排序位置
            arr[0] = arr[i];
            arr[i] = temp;
            adjustDownToUp(arr,0, i); //整理，将剩余的元素整理成堆
        }
    }

    /*
        删除堆顶元素
     */
    public static int[] deleteMax(int[] arr) {
        int temp = arr[0];
        int length = arr.length;
        arr[0] = arr[length - 1];
        arr[length - 1] = temp;
        adjustDownToUp(arr, 0 , length - 1); //排除堆底元素
        return Arrays.copyOf(arr,length-1);
    }

    /*
        插入 元素
     */
    public static int[] insert(int[] arr , int num) {
        int length = arr.length;
        arr=Arrays.copyOf(arr, arr.length+1);
        arr[length] = num;
        adjustUp(arr, length);
        return  arr;
    }

    /*
        向下调整  j 为 i 的 双亲节点 i == 0  即到堆顶 调整停止
     */
    public static void adjustUp(int[] arr, int i) {
        int temp , j;
        temp = arr[i];
        j = (i - 1) / 2;
        while (i != 0 && j >= 0 && arr[j] < temp) {
            arr[i] = arr[j];
            i = j;
            j = (j - 1) / 2;
        }
        arr[i] = temp;
    }
}
