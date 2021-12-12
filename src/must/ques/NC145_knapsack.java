package must.ques;

/**
 * @ClassName NC145_knapsack
 * @Description TODO
 * @Author faro_z
 * @Date 2021/12/2 4:07 下午
 * @Version 1.0
 **/
public class NC145_knapsack {
    public static void main(String[] args) {

    }

    //public int knapsack (int V, int n, int[][] vw) {
    //    int[][] dp = new int[n+1][V+1];
    //    for (int i = 1; i <n+1 ; i++) {
    //        // 第二层循环的含义，可以这么理解
    //        // 我们为其分配的空间，由0 到 V 不断增加，假设当前为其分配的空间为 c
    //        // 那么，这个c 也不是全部由这第 i 个物品使用的，可能还有其他物品需要使用
    //        // 那怎么计算其他物品在使用掉空间后，剩余的重量呢？
    //        // 其实这在之前的循环中，就已经计算完成了
    //        // 我们在代码中的表示为 dp[i-1][c-currV]+currW
    //        for (int c = 0; c <V+1 ; c++) {
    //            int currV = vw[i - 1][0];
    //            int currW = vw[i - 1][1];
    //            if (c>=currV) {
    //                dp[i][c]=Math.max(dp[i-1][c] , dp[i-1][c-currV]+currW);
    //            } else {
    //                dp[i][c]=dp[i-1][c];
    //            }
    //        }
    //    }
    //    return dp[n][V];
    //}

    //public int knapsack (int V, int n, int[][] vw) {
    //    int[][] dp = new int[2][V+1];
    //    // 对第一行进行初始化
    //    for (int c = 0; c <V+1; c++) {
    //        int currV = vw[0][0];
    //        int currW = vw[0][1];
    //        dp[0][c]=c>=currV?currW:0;
    //    }
    //    for (int i = 1; i <n ; i++) {
    //        for (int c = 0; c <V+1 ; c++) {
    //            int currV = vw[i][0];
    //            int currW = vw[i][1];
    //            if (c>=currV) {
    //                dp[i%2][c]=Math.max(dp[(i-1)%2][c] , dp[(i-1)%2][c-currV]+currW);
    //            } else {
    //                dp[i%2][c]=dp[(i-1)%2][c];
    //            }
    //        }
    //    }
    //    return dp[1][V];
    //}

    public int knapsack (int V, int n, int[][] vw) {
        int[] dp = new int[V+1];
        for (int i = 0; i < n; i++) {
            for (int c = V; c >=vw[i][0] ; c--) {
                dp[c] = Math.max(dp[c] , dp[c-vw[i][0]]+vw[i][1]);
            }
        }
        return dp[V];
    }
}