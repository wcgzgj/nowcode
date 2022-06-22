package must.ques;

import java.util.Arrays;

/**
 * @ClassName leetcode543_updateMatrix
 * @Description TODO
 * @Author faro_z
 * @Date 2022/6/22 16:58
 * @Version 1.0
 **/
public class leetcode542_updateMatrix {
    public static void main(String[] args) {
        int[][] mat = {{0, 1, 1, 0},
                        {1, 1, 1, 0},
                        {1, 1, 1, 1}};
        leetcode542_updateMatrix solu = new leetcode542_updateMatrix();
        int[][] res = solu.updateMatrix(mat);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j]+" ,");
            }
            System.out.println();
        }
    }

    // 失败的尝试：不能一次判断四个方向，因为在左上到右下的过程中，
    // 右边和下边的数据还没有准备好，所以只能左上到右下，再右下到左上
    //public int[][] updateMatrix(int[][] mat) {
    //    int R = mat.length;
    //    int C = mat[0].length;
    //    int[][] dp = new int[R][C];
    //    for (int i = 0; i < R; i++) {
    //        for (int j = 0; j < C; j++) {
    //            if (mat[i][j]==0) dp[i][j]=0;
    //            else dp[i][j]=getMidDisNei(mat,i,j)+1;
    //        }
    //    }
    //    return dp;
    //}
    //
    //private int getMidDisNei(int[][]dp,int r,int c) {
    //    int R = dp.length;
    //    int C = dp[0].length;
    //    int[] rows = {0, 0, 1, -1};
    //    int[] cols = {1, -1, 0, 0};
    //    int min = Integer.MAX_VALUE;
    //    for (int i = 0; i < 4; i++) {
    //        int cr = r + rows[i];
    //        int cc = c + cols[i];
    //        if (cr>=0 && cr<R && cc>=0 && cc<C) {
    //            min = Math.min(min,dp[cr][cc]);
    //        }
    //    }
    //    return min;
    //}

    public int[][] updateMatrix(int[][] mat) {
        int R = mat.length;
        int C = mat[0].length;
        int[][] dp = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                dp[i][j]=mat[i][j]==0?0:Integer.MAX_VALUE-1;
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // 必须要使用这种分段写法，上方和下方的判断不可以写在一起
                // 因为这种分段写法，其判断范围会更大一些
                // 注意：不是单边判断的时候，完全空出一个 「  形
                // 而是 if (i>0) 先空出一个 - 形
                // 再在 if (j>0) 空出一个 | 形
                // 这个写法其实是优化写法，原写法是
                //if (i==0) dp[i][j] = Math.min(dp[i][j],dp[i][j-1]+1);
                //else if (j==0) dp[i][j] = Math.min(dp[i][j],dp[i-1][j]+1);
                //。。。
                if (i>0) {
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j]+1);
                }
                if (j>0) {
                    dp[i][j]=Math.min(dp[i][j],dp[i][j-1]+1);
                }
            }
        }
        for (int i = R-1; i >= 0; i--) {
            for (int j = C-1; j >=0 ; j--) {
                if (i<R-1) {
                    dp[i][j] = Math.min(dp[i][j],dp[i+1][j]+1);
                }
                if (j<C-1) {
                    dp[i][j]=Math.min(dp[i][j],dp[i][j+1]+1);
                }
            }
        }
        return dp;
    }
}
