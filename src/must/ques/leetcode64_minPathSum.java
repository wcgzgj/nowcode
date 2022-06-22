package must.ques;

/**
 * @ClassName leetcode64_minPathSum
 * @Description TODO
 * @Author faro_z
 * @Date 2022/6/22 16:10
 * @Version 1.0
 **/
public class leetcode64_minPathSum {
    public static void main(String[] args) {
        int[][] grid =new int[][] {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        leetcode64_minPathSum solu = new leetcode64_minPathSum();
        System.out.println(solu.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int R = grid.length;
        if (R==0) return 0;
        int C = grid[0].length;
        int[][] dp = new int[R][C];
        for (int i = 0; i <R ; i++) {
            for (int j = 0; j <C ; j++) {
                if (i==0 && j==0) dp[i][j]=grid[i][j];
                else if (i==0) dp[i][j]=dp[i][j-1]+grid[i][j];
                else if (j==0) dp[i][j]=dp[i-1][j]+grid[i][j];
                else dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[R-1][C-1];
    }
}
