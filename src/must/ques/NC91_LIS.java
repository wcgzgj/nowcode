package must.ques;

import java.util.Arrays;

/**
 * @ClassName NC91_LIS
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/23 3:49 下午
 * @Version 1.0
 **/
public class NC91_LIS {
    public static void main(String[] args) {
        int[] arr = {2,1,5,3,6,4,8,9,7};
        NC91_LIS solu = new NC91_LIS();
        System.out.println(Arrays.toString(solu.LIS(arr)));
    }

    // 方法1：动态规划
    public int[] LIS (int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i]=1;
        }
        // 获取最长递增子序列的 dp 数组
        int maxLen = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int preMax = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j]<=arr[i]) preMax=Math.max(preMax,dp[j]);
            }
            dp[i]=preMax+1;
            maxLen=Math.max(maxLen,dp[i]);
        }

        int[] res = new int[maxLen];
        for (int i = dp.length-1,index = maxLen-1; index >=0 ; i--) {
            if (dp[i]==maxLen) {
                res[index--]=arr[i];
                maxLen--;
            }
        }
        return res;
    }
}
