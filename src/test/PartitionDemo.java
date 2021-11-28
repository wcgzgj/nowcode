package test;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName PartitionDemo
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/28 1:15 下午
 * @Version 1.0
 **/
public class PartitionDemo {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i]=r.nextInt(100);
        }
        int[] myArr = {6, 78, 20, 16, 92, 62, 7, 29, 25, 70};
        System.out.println(Arrays.toString(arr));
        System.out.println(partition2(arr,0,arr.length-1));
        System.out.println(Arrays.toString(arr));
    }

    // 以下有两种 partition 的方式
    // 方式1：书上给的传统的 partition 方式
    //public static int partition1(int []arr,int l,int r) {
    //    int pivotVal = arr[l];
    //    while (l<=r) {
    //        while (l<=r && arr[r]>=pivotVal) r--;
    //        arr[l]=arr[r];
    //        while (l<=r && arr[l]<=pivotVal) l++;
    //        arr[r]=arr[l];
    //    }
    //    arr[l]=pivotVal;
    //    return l;
    //}

    // 方式2：带上 Index 的 partition 方式
    public static int partition2(int []arr,int l,int r) {
        int pivotVal = arr[l];
        int index = l + 1;
        for (int i = index; i <=r ; i++) {
            if (arr[i]<=pivotVal) swap(arr,index++,i);
        }
        swap(arr,index-1,l);
        return index-1;
    }

    private static void swap(int[] arr,int l,int r) {
        int tmp = arr[l];
        arr[l]=arr[r];
        arr[r]=tmp;
    }
}
