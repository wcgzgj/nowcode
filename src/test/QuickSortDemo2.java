package test;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName QuickSortDemo2
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/28 1:38 下午
 * @Version 1.0
 **/
public class QuickSortDemo2 {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=r.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[]arr) {
        quickSort(arr,0,arr.length-1);
    }

    private static void quickSort(int[]arr,int l,int r) {
        if (l>=r) return;
        int pivot = partition(arr, l, r);
        quickSort(arr,l,pivot-1);
        quickSort(arr,pivot+1,r);
    }

    private static int partition(int[]arr,int l,int r) {
        int pivotVal = arr[l];
        int index = l + 1;
        for (int i = index; i <=r ; i++) {
            if (arr[i]<=pivotVal) swap(arr,index++,i);
        }
        swap(arr,index-1,l);
        return index-1;
    }

    private static void swap(int[]arr,int l,int r) {
        int tmp = arr[l];
        arr[l]=arr[r];
        arr[r]=tmp;
    }

}
