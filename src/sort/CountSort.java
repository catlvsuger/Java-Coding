package sort;

/**
 * @Auther: discat
 * @Email: distantcat@126.com
 * @Date: 2018-11-19 15:50
 * @Description: 计数排序： 数都在 0 - k 范围内
 * 1  初始化一个大小为（k+1）的数组 C（所有元素初始值为0），遍历整个待排序数组 A，根据 A 中元素次数将对应 C 中的元素大小 +1
   2  我们将 C 中每个i位置的元素大小改成C数组前i项和（基于之前的算法思考，我们不难理解这么做的道理）
   3  初始化一个和A同样大小的数组B用于存储排序后数组，然后倒序遍历（保证排序稳定性） A 中元素，通过查找 C 数组，
    将该元素放置到B中相应的位置，同时将 C 中对应的元素大小 -1（表明已经放置了一个这样大小的元素，
    下次再放同样大小的元素，就要往前挤一个位置）。遍历完 A 数组后，就完成了所有的排序工作
 */
public class CountSort {

    public static void main(String[] args) {
        int[] arr =  {2, 13, 4, 1, 7, 9, 2 , 11 ,15 ,20 ,8 , 3, 1};
        HeapSort.toString(conutSort(arr, 20));
    }

    public static int[]  conutSort(int[] arr,int k) {
        int[] c = new int[k + 1]; //构造 C 数组
        int length=arr.length,sum=0;//获取A数组大小用于构造 B 数组
        int[] B=new int[length];//构造 B 数组
        for(int i = 0; i < length; i++) {
            c[arr[i]] +=  1; // 步骤 1：  记录次数 +1
        }
        for(int i = 0; i < k + 1; i++) {
            sum += c[i];
            c[i] = sum;  //步骤 2： C 改为 前 i 项之和
        }
        for(int i = length -1; i >= 0; i--) { //倒序遍历A数组，构造B数组 （倒序是为了保持稳定性）
            B[c[arr[i]] - 1] = arr[i];  //将A中该元素放到排序后数组B中指定的位置
            c[arr[i]] -= 1; //将C中该元素-1，方便存放下一个同样大小的元素
        }
        return B;//将排序好的数组返回，完成排序
    }
}
