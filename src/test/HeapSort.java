package test;

import must.util.RandomData;

import java.util.Arrays;

/**
 * @ClassName HeapSort
 * @Description TODO
 * @Author faro_z
 * @Date 2021/10/24 12:56 下午
 * @Version 1.0
 **/
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = RandomData.getRandomArray(8, 100);
        System.out.println("排序前:"+ Arrays.toString(arr));
        //int[] arr = {1,2,3,4,5,6,7};
        heapSort(arr);
        System.out.println("排序后:"+Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        buildHeap(arr);
        for (int i = arr.length-1; i >0; i--) {
            // 将大根放到数组末尾
            swap(arr,0,i);
            // 重新进行堆调整
            heapify(arr,0,i);
        }
    }

    // 将数组转化为大根堆
    public static void buildHeap(int[] arr) {
        // 从最后一个非叶子节点开始，往上进行堆化
        for (int i = arr.length/2-1; i>=0; i--) {
            heapify(arr,i,arr.length);
        }
    }

    /**
     * 堆调整
     * @param arr
     * @param root
     * @param n 自定义边界
     * 注意：这里一定不要忘记自定义边界，因为后面堆排序的过程中，
     * 每次进行堆调整，不是一直调整到最后的，因为数组后面的位置是已经排好序的部分，不能再进行改变
     */
    public static void heapify(int[] arr,int root,int n) {
        int child = root * 2+1;
        if (child>=n) return;
        if (child+1<n && arr[child+1]>arr[child]) child++;
        if (arr[child]<=arr[root]) return;
        swap(arr,root,child);
        heapify(arr,child,n);
    }

    public static void swap(int[]arr,int l,int r) {
        int tmp = arr[l];
        arr[l]=arr[r];
        arr[r]=tmp;
    }

}
