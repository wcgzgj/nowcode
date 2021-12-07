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

    /*
        dp[i][j] 表示数量为 i ，可用容量为 j 的情况下，最大的重量
        状态转移方程为：dp[i][j] = max(dp[i-1][j] , dp[i-1][j-Vi]+Wi)  ，意思是在选和不选 i 的两种情况中，选择对应价值最大的情况
     */
    public int knapsack (int V, int n, int[][] vw) {
        int[][] dp = new int[vw.length+1][vw[0].length+1];
        for (int i = 0; i < vw.length; i++) {
            for (int j = 0; j < vw[0].length; j++) {

            }
        }
        return -1;
    }
}