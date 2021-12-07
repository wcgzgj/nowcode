package must.ques;

/**
 * @ClassName leetcode70_climbStairs
 * @Description TODO
 * @Author faro_z
 * @Date 2021/12/7 3:33 下午
 * @Version 1.0
 **/
public class leetcode70_climbStairs {
    public static void main(String[] args) {

    }

    //public int climbStairs(int n) {
    //    if (n<=2) return n;
    //    int[] dp = new int[n+1];
    //    // 跳到第一级，只有一种方法
    //    dp[1]=1;
    //    // 跳到第二级，有两种方法
    //    dp[2]=2;
    //    for (int i = 3; i <=n ; i++) {
    //        // 状态转移方程转换为代码
    //        dp[i]=dp[i-1]+dp[i-2];
    //    }
    //    return dp[n];
    //}

    public int climbStairs(int n) {
        if (n<=2) return n;
        // 跳到第一级，只有一种方法
        int pre=1;
        // 跳到第二级，有两种方法
        int curr=2;
        for (int i = 3; i <=n ; i++) {
            // 状态转移方程转换为代码
            int tmp = pre + curr;
            pre=curr;
            curr=tmp;
        }
        return curr;
    }
}
