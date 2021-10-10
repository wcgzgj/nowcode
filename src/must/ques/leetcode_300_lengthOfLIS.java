package must.ques;

/**
 * @ClassName leetcode_300_lengthOfLIS
 * @Description TODO
 * @Author faro_z
 * @Date 2021/9/25 3:29 下午
 * @Version 1.0
 **/
public class leetcode_300_lengthOfLIS {
    public static void main(String[] args) {
        leetcode_300_lengthOfLIS leetcode_300_lengthOfLIS = new leetcode_300_lengthOfLIS();
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println(leetcode_300_lengthOfLIS.lengthOfLIS(arr));
    }
    public int lengthOfLIS(int[] nums) {
        if (nums.length<2) return nums.length;
        // 状态转移方程 dp[i] = max(dp[j])+1
        int[] dp = new int[nums.length];
        dp[0]=1;
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int maxVal=0;
            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i]) {
                    if (maxVal<dp[j]) {
                        maxVal=dp[j];
                    }
                }
            }
            dp[i]=maxVal+1;
            res=Math.max(res,dp[i]);
        }
        return res;
    }


}
