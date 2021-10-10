package must.ques;

import java.util.Arrays;

/**
 * @ClassName WC132_LIS
 * @Description 最长递增子串
 *
 * 给定数组 arr ，设长度为 n ，输出 arr 的最长递增子序列。
 *（如果有多个答案，请输出其中 按数值(注：区别于按单个字符的ASCII码值)进行比较的 字典序最小的那个
 * @Author faro_z
 * @Date 2021/10/6 12:33 下午
 * @Version 1.0
 **/
public class WC132_LIS {
    public static void main(String[] args) {
        WC132_LIS solu = new WC132_LIS();
        int[] arr = {10,9,2,5,3,7,101,18};
        //int res = solu.lengthOfLIS(arr);
        //System.out.println(res);
    }

    // 力扣的版本，只要将长度获取就 OK 了
    //public int LIS (int[] arr) {
    //    int[] dp = new int[arr.length];
    //    dp[0]=1;
    //    int res = Integer.MIN_VALUE;
    //    for (int i = 1; i < arr.length; i++) {
    //        int maxIndex=0;
    //        for (int j = 0; j < i; j++) {
    //            if (arr[i]>arr[j] && dp[j]>dp[maxIndex]) {
    //                maxIndex=j;
    //            }
    //        }
    //        if (maxIndex==0 && arr[maxIndex]>arr[i]) {
    //            dp[i]=1;
    //        } else {
    //            dp[i]=dp[maxIndex]+1;
    //        }
    //        res=Math.max(dp[i],res);
    //    }
    //    return res;
    //}

    public int[] LIS (int[] arr) {
        if (arr.length<2) return arr;
        // dp[i] 表示到位置 i 可以获取的最长递增子序列长度
        // dp[i]=max(dp[i],max(dp[k])+1) k 表示 0~i-1 的一个位置，且 arr[k]<arr[i]
        int res = 1;
        int[] dp = new int[arr.length];
        dp[0]=1;
        for (int i = 1; i < arr.length; i++) {
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if (arr[j]<arr[i]) dp[i]=Math.max(dp[i],dp[j]+1);
            }
            res=Math.max(res,dp[i]);
        }


        return null;
    }

    // 力扣版
    //public int lengthOfLIS(int[] nums) {
    //    if (nums.length<2) return nums.length;
    //    // dp[i] 表示到位置 i 可以获取的最长递增子序列长度
    //    // dp[i]=max(dp[i],max(dp[k])+1) k 表示 0~i-1 的一个位置，且 nums[k]<nums[i]
    //    int res = 1;
    //    int[] dp = new int[nums.length];
    //    dp[0]=1;
    //    for (int i = 1; i < nums.length; i++) {
    //        dp[i]=1;
    //        for (int j = 0; j < i; j++) {
    //            if (nums[j]<nums[i]) dp[i]=Math.max(dp[i],dp[j]+1);
    //        }
    //        res=Math.max(res,dp[i]);
    //    }
    //    System.out.println(Arrays.toString(dp));
    //    return res;
    //}
}
