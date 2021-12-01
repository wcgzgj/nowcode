package test;

import must.util.RandomData;

import java.util.Arrays;

/**
 * @ClassName FindTwoSwapDemo
 * @Description 找到有序数组中被交换的两个元素
 * @Author faro_z
 * @Date 2021/12/1 2:07 下午
 * @Version 1.0
 **/
public class FindTwoSwapDemo {
    public static void main(String[] args) {
        int[] arr = RandomData.getRandomArray(10, 100);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        RandomData.swap(arr,2,4);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(getTwoSwap(arr)));
    }

    public static int[] getTwoSwap(int[]arr) {
        int[] res = new int[2];
        int first=-1;
        int second=-1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i]>arr[i+1]) {
                if (first==-1) {
                    first=i;
                    second=i+1;
                } else {
                    second=i+1;
                }
            }
        }
        res[0]=first;
        res[1]=second;
        return res;
    }


}
