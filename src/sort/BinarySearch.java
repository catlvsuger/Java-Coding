package sort;

/**
 * @Auther: discat
 * @Email: distantcat@126.com
 * @Date: 2018-11-13 16:53
 * @Description: 二分查找法 ，前提 有序
 */
public class BinarySearch {

    /*
        递归  时间最坏 O(log2 N) 最好：O(1) 空间; O(log2N )
     */
    public static int recursionBinarySearch(int[] arrs, int min, int max, int key) {
        //首先判断错误情况
        if (key > arrs[max] || key < arrs[min] || min > max) {
            return -1;
        }
        int mid = (max + min) >>> 1; //求 max min 平均值
        if ( key > arrs[mid] ) {
            return  recursionBinarySearch(arrs, mid + 1 , max, key);
        }
        if( key < arrs[mid] ) {
            return recursionBinarySearch(arrs, min, mid - 1, key);
        }
        if (key == arrs[mid]){
            return mid;
        }
        return -1;
    }

    /*
        while循环 查找 时间最坏 O(log2 N) 最好：O(1) 空间; O(1)
     */
    public static  int binarySearch(int[] arrs, int min, int max, int key) {
        while (min <= max) {
            int mid = (max + min) >>> 1; //求 max min 平均值
            if (key > arrs[mid]) {
                min = mid + 1;
            }
            if (key < arrs[mid]) {
                max = mid -1;
            }
            if (key == arrs[mid]) {
                return mid;
            }
        }
        return  -1; // 没有找到，返回 -1
    }

    public static void main(String[] args) {
        int[] arrs = {1, 3, 4, 6, 8, 9, 11, 12, 15};
        int key = 11;
        System.out.println(binarySearch(arrs, 0, arrs.length-1, key));
        System.out.println(recursionBinarySearch(arrs,0, arrs.length-1, key));
    }
}
