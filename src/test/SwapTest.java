package test;

import java.util.Arrays;

/**
 * @ClassName SwapTest
 * @Description TODO
 * @Author faro_z
 * @Date 2021/9/13 4:28 下午
 * @Version 1.0
 **/
public class SwapTest {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        for (int i = 0; i <= 6; i+=2) {
            swap(arr,i,i+1);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[]arr,int l,int r) {
        arr[l]=arr[r]-arr[l];
        arr[r]=arr[r]-arr[l];
        arr[l]=arr[r]+arr[l];
    }
}
