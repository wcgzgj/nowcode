package must.ques;

/**
 * @ClassName leetcode300_lengthOfLIS
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/10 8:02 下午
 * @Version 1.0
 **/
public class leetcode300_lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        // 状态转移方程：dp[i]=max(dp[k])+1 dp[k] 表示 0~i-1 中所有 list[k]<list[i] 的情况
        if (nums.length==0) return 0;
        int res = 1;
        int[] dp = new int[nums.length];
        dp[0]=1;
        for (int i = 1; i < nums.length; i++) {
            int currMax=0;
            for (int j = 0; j < i; j++) {
                // 找到 dp[k]
                if (nums[j]<nums[i]) currMax=Math.max(currMax,dp[j]);
            }
            dp[i]=currMax+1;
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
