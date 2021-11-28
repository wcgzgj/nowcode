package test;

import must.util.RandomData;

import java.util.Arrays;

/**
 * @ClassName HeapSortDemo2
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/28 1:46 下午
 * @Version 1.0
 **/
public class HeapSortDemo2 {
    public static void main(String[] args) {
        int[] arr = RandomData.getRandomArray(8, 100);
        System.out.println("排序前:"+ Arrays.toString(arr));
        //int[] arr = {1,2,3,4,5,6,7};
        heapSort(arr);
        System.out.println("排序后:"+Arrays.toString(arr));
    }

    public static void heapSort(int[]arr) {
        buildHeap(arr);
        for (int i = arr.length-1; i>0; i--) {
            swap(arr,0,i);
            heapify(arr,0,i-1);
        }
    }

    // 构建堆
    private static void buildHeap(int[] arr) {
        for (int i = (arr.length/2)-1; i >=0 ; i--) {
            heapify(arr,i,arr.length-1);
        }
    }

    // 堆化（仅在只有 root 不满足堆条件，但是其他节点都满足堆条件的前提下）
    private static void heapify(int[]arr,int root,int end) {
        // 找大一点的孩子
        int child = root * 2 + 1;
        if (child>end) return;
        if (child+1<=end && arr[child+1]>arr[child]) child++;
        // 如果孩子节点大于根节点，就和根进行交换
        if (arr[child]<=arr[root]) return;
        swap(arr,child,root);
        heapify(arr,child,end);
    }

    private static void swap(int[]arr,int l,int r) {
        int tmp = arr[l];
        arr[l]=arr[r];
        arr[r]=tmp;
    }
}
