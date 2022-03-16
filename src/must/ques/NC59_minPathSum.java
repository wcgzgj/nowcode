package must.ques;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @ClassName NC59_minPathSum
 * @Description 矩阵的最小路径和
 * @Author faro_z
 * @Date 2022/3/16 3:37 下午
 * @Version 1.0
 **/
public class NC59_minPathSum {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                          {1, 2, 3}};
        NC59_minPathSum solu = new NC59_minPathSum();
        System.out.println(solu.minPathSum(matrix));
    }
    // 方案1：dfs，但是会超时
    //private int minSum = Integer.MAX_VALUE;
    //public int minPathSum (int[][] matrix) {
    //    dfs(0,0,matrix.length-1,matrix[0].length-1,0,matrix);
    //    return minSum;
    //}
    //
    //private void dfs(int r,int c,int rLeft,int cLeft,int sum,int[][] matrix) {
    //    sum+=matrix[r][c];
    //    if (rLeft==0 && cLeft==0) {
    //        minSum = Math.min(sum,minSum);
    //        return;
    //    }
    //    if (rLeft>0) dfs(r+1,c,rLeft-1,cLeft,sum,matrix);
    //    if (cLeft>0) dfs(r,c+1,rLeft,cLeft-1,sum,matrix);
    //}

    // 方案2：暴力解法的优化
    // 这里还有一种使用记忆化的优化方式
    // 就是再开一个数组，每个位置记录之前走到过这个位置时最小的权值
    // 如果当前的和已经大于之前记录的位置和了，那就没有再走下去的意义了，直接返回
    // 时间复杂度是小于 O(2^n) ，但是在牛客还是会超时，只能用动规
    //private int minSum = Integer.MAX_VALUE;
    //public int minPathSum (int[][] matrix) {
    //    // 记录之前走到当前位置的最小值
    //    int[][] memo = new int[matrix.length][matrix[0].length];
    //    for (int i = 0; i < memo.length; i++) {
    //        for (int j = 0; j < memo[0].length; j++) {
    //            memo[i][j]=-1;
    //        }
    //    }
    //    dfs(0,0,matrix.length-1,matrix[0].length-1,0,matrix,memo);
    //    return minSum;
    //}
    //
    //private void dfs(int r,int c,int rLeft,int cLeft,int sum,int[][] matrix,int[][] memo) {
    //    sum+=matrix[r][c];
    //    if (memo[r][c]==-1) {
    //        memo[r][c]=sum;
    //    }
    //    // 大于之前某次的走法，排除以减小递归
    //    if (sum>memo[r][c]) return;
    //    if (rLeft==0 && cLeft==0) {
    //        minSum = Math.min(sum,minSum);
    //        return;
    //    }
    //    if (rLeft>0) dfs(r+1,c,rLeft-1,cLeft,sum,matrix,memo);
    //    if (cLeft>0) dfs(r,c+1,rLeft,cLeft-1,sum,matrix,memo);
    //}

    // 方案 3：动态规划
    public int minPathSum (int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        if (matrix==null || R*C==0) return 0;
        int[][] dp = new int[R][C];
        for (int i = 0; i < C; i++) {
            if (i==0) dp[0][i]=matrix[0][i];
            else dp[0][i]=matrix[0][i]+dp[0][i-1];
        }
        for (int i = 0; i < R; i++) {
            if (i==0) dp[i][0]=matrix[i][0];
            else dp[i][0]=matrix[i][0]+dp[i-1][0];
        }
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + matrix[i][j];
            }
        }
        //for (int i = 0; i < R; i++) {
        //    System.out.println(Arrays.toString(dp[i]));
        //}
        return dp[R-1][C-1];
    }
}
