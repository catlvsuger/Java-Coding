package sort;

/**
 * @Auther: discat
 * @Email: distantcat@126.com
 * @Date: 2018-11-27 17:56
 * @Description: 其实桶排序的与计数排序类似，需要引入一个变量K，K的值大于序列的最大值。
 * 此处K表示有K个桶，引入一个表示桶的数组buckets[K]，初始时各元素都为0,遍历一遍待排序序列A，
 * 序列值即为其对应的桶的序号，直接扔进对应的桶：buckets[A[i]]+=1。
 * 遍历完之后，开始按桶序号从小到大遍历桶，检查相应的元素，然后逐个存入A中，遍历结束则排序完成，获得的A为有序序列
 */
public class BucketSort {

    public static  int[] bucketSort(int[] arr , int n, int k) { //K 必须大于该数组最大值
        //将值作为桶的序号，将每个元素丢进相应的桶中，然后进行遍历桶，当桶的数字为多少时，则输出多少个桶的序号即元素值。
        int w, h, u;
        int[] buckets = new int[k];

        for(int i= 0; i < k; i++ ) {
            buckets[i] = 0;  //初始化
        }
        for(int i= 0; i < n; i++ ) {
            buckets[arr[i]] += 1; //arr[i] 有几个就加几
        }
        for(w = 0,h = 0; h < k ; h++){   //遍历 桶
            for (u = buckets[h]; u > 0 ; u--){  //遍历该位置桶有几个相同的数
                arr[w++] = h;  //根据桶从小到大依次排列
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 6, 1, 4, 9, 3, 2, 10};
        bucketSort(arr, arr.length, 12);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
