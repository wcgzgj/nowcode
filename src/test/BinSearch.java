package test;

import java.util.Arrays;

/**
 * @ClassName BinSearch
 * @Description TODO
 * @Author faro_z
 * @Date 2021/10/15 12:04 下午
 * @Version 1.0
 **/
public class BinSearch {
    public static void main(String[] args) {
        int[] arr = {554,2,8,5,123,0,4};
        Arrays.sort(arr);
        System.out.println("排序后的数组为:"+Arrays.toString(arr));
        System.out.println("查找 123 的结果为："+binSearch(arr,123));
    }

    /**
     * 二分查找，返回下标
     * @param arr 数组
     * @param target 要找的数
     * @return
     */
    public static int binSearch(int[]arr,int target) {
        if (arr.length==0) return -1;
        int l=0,r=arr.length-1;
        int mid = (l+r)/2;
        while (l<=r) {
            if (arr[mid]==target) return mid;
            if (arr[mid]<target) l=mid+1;
            else r=mid-1;
            mid=(l+r)/2;
        }
        return -1;
    }
}
