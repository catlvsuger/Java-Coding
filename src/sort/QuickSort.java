package sort;

/**
 * @Author dengjing
 * @Date Created in 16:45 2018/4/2.
 * @Description: 快速排序:在数组中随机选一个数（默认数组中间元素），数组中小于等于此数的放在左边，\
 * 大于此数的放在右边，再对数组两边递归调用快速排序，重复这个过程，直到有序 （分治法）
 * @Modified By:
 */
public class QuickSort {

    public static void quickSort(int[] arr , int L , int R) {
        //L 数组最小下标， R 数组最大下标
        if(L>R) {//（递归过程先写结束条件）
            return;
        }
        int i , j , pivot , temp;
        i = L; j = R;
        pivot = arr[(L+R)/2]; //取参考值的下标（优化： 三数取中）
        //左右两端进行扫描，只要两端还没有交替，就一直扫描
        while (i <= j ) {
            while (arr[i] <  pivot) i++;
            while (arr[j] >  pivot) j--;
            //此时已经分别找到了右边比支点小的数、左边比支点大的数，它们进行交换
            if (i<=j) {
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++; j--;
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
    }

    //接口调整
    public static void adjust_quicksort(int k[]) {
        int n = k.length - 1;
        quicksort(k,0,n);
    }
    public static void quicksort(int a[], int left, int right) {
        int i,j,t,temp;
        if(left>right) {  //（递归过程先写结束条件）
            return;
        }
        temp=a[left]; //temp中存的就是基准数
        i=left;
        j=right;
        while(i!=j)
        {
            //顺序很重要，要先从右边开始找（最后交换基准时换过去的数要保证比基准小，因为基准
            //选取数组第一个数，在小数堆中）
            while(a[j]>=temp && i<j)
                j--;
            //再找右边的
            while(a[i]<=temp && i<j)
                i++;
            //交换两个数在数组中的位置
            if(i<j)
            {
                t=a[i];
                a[i]=a[j];
                a[j]=t;
            }
        }
        //最终将基准数归位 （之前已经temp=a[left]过了，交换只需要再进行两步）
        a[left]=a[i];
        a[i]=temp;

        quicksort(a,left,i-1);//继续处理左边的，这里是一个递归的过程
        quicksort(a,i+1,right);//继续处理右边的 ，这里是一个递归的过程
    }

    public static void main(String[] args) {
        int[] arr = {13,11,6,6,4,2,11,0};
        quickSort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ "  ");
        }
        System.out.println();
        int[] arrs2 = {13,11,6,6,4,2,11,0};
         adjust_quicksort(arrs2);
        for (int i = 0; i < arrs2.length; i++) {
            System.out.print(arrs2[i]+ "  ");
        }
    }

}
