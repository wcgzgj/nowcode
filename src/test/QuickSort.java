package test;

import must.util.RandomData;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName QuickSort
 * @Description TODO
 * @Author faro_z
 * @Date 2021/10/24 12:42 下午
 * @Version 1.0
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = RandomData.getRandomArray(20, 100);
        System.out.println("排序前:"+ Arrays.toString(arr));
        quickSort(arr);
        System.out.println("排序后:"+Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {
        quickSort(arr,0,arr.length-1);
    }

    private static void quickSort(int[] arr,int l,int r) {
        if (l>=r) return;
        int pivot = partition(arr, l, r);
        quickSort(arr,l,pivot-1);
        quickSort(arr,pivot+1,r);
    }

    private static int partition(int[] arr,int l,int r) {
        int pivotVal = arr[l];
        int index = l+1;
        for (int i = index; i <=r; i++) {
            if (arr[i]<=pivotVal) swap(arr,index++,i);
        }
        swap(arr,l,index-1);
        return index-1;
    }

    public static void swap(int[] arr,int l,int r) {
        int tmp = arr[l];
        arr[l]=arr[r];
        arr[r]=tmp;
    }



}
