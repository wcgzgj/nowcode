package test;

import must.util.RandomData;

import java.util.Arrays;

/**
 * @ClassName SortTest
 * @Description TODO
 * @Author faro_z
 * @Date 2022/6/4 15:06
 * @Version 1.0
 **/
public class SortTest {
    public static void main(String[] args) {
        int[] randomArray = RandomData.getRandomArray(10, 100);
        System.out.println(Arrays.toString(randomArray));
        mergeSort(randomArray,0,randomArray.length-1);
        System.out.println(Arrays.toString(randomArray));
    }

    public static void mergeSort(int[] arr,int l,int r) {
        if (l==r) return;
        int mid = (l + r) / 2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

    // 归并
    private static void merge(int[]arr,int ls,int le,int re) {
        int[] tmp = new int[re - ls + 1];
        int l = ls;
        int r = le + 1;
        int index = 0;
        while (l<=le && r<=re) {
            if (arr[l]<=arr[r]) tmp[index++]=arr[l++];
            else tmp[index++]=arr[r++];
        }
        while (l<=le) tmp[index++]=arr[l++];
        while (r<=re) tmp[index++]=arr[r++];
        index = 0;
        for (int i = ls; i <=re ; i++) {
            arr[i]=tmp[index++];
        }
    }


}
