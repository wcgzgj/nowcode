package test;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName HeapSortDemo3
 * @Description TODO
 * @Author faro_z
 * @Date 2022/7/16 02:12
 * @Version 1.0
 **/
public class HeapSortDemo3 {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        heapSort(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void heapSort(int[]arr) {
        if (arr==null || arr.length<2) return;
        buildMaxHeap(arr);
        for (int i = arr.length-1; i>0 ; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            maxHeapAdjust(arr,0,i);
        }
    }

    private static void buildMaxHeap(int[]arr) {
        if (arr==null || arr.length<2) return;
        int bottomRowLastNodeIndex = (arr.length - 1) / 2;
        for (int i = bottomRowLastNodeIndex; i >=0 ; i--) {
            maxHeapAdjust(arr,i,arr.length);
        }
    }

    private static void maxHeapAdjust(int[]arr,int index,int heapSize) {
        if (index>=heapSize) return;
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int maxValIndex = index;
        if (left<heapSize && arr[left]>arr[maxValIndex]) {
            maxValIndex = left;
        }
        if (right<heapSize && arr[right]>arr[maxValIndex]) {
            maxValIndex = right;
        }
        if (maxValIndex==index) {
            return;
        }
        int tmp = arr[index];
        arr[index] = arr[maxValIndex];
        arr[maxValIndex] = tmp;
        maxHeapAdjust(arr,maxValIndex,heapSize);
    }

    //private static void buildMinHeap(int[]arr) {
    //    if (arr==null || arr.length<2) return;
    //    int bottomRowLastNodeIndex = (arr.length - 1) / 2;
    //    for (int i = bottomRowLastNodeIndex; i >=0 ; i--) {
    //        minHeapAdjust(arr,i,arr.length);
    //    }
    //}
    //
    //private static void minHeapAdjust(int[]arr,int index,int heapSize) {
    //    if (index>=heapSize) return;
    //    int left = index * 2 + 1;
    //    int right = index * 2 + 2;
    //    int minValIndex = index;
    //    if (left<heapSize && arr[left]<arr[minValIndex]) {
    //        minValIndex = left;
    //    }
    //    if (right<heapSize && arr[right]<arr[minValIndex]) {
    //        minValIndex = right;
    //    }
    //    if (minValIndex==index) {
    //        return;
    //    }
    //    int tmp = arr[index];
    //    arr[index] = arr[minValIndex];
    //    arr[minValIndex] = tmp;
    //    minHeapAdjust(arr,minValIndex,heapSize);
    //}
}
