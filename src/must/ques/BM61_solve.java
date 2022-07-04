package must.ques;

/**
 * @ClassName BM61_solve
 * @Description TODO
 * @Author faro_z
 * @Date 2022/7/4 15:20
 * @Version 1.0
 **/
public class BM61_solve {
    public static void main(String[] args) {
        BM61_solve solu = new BM61_solve();
        System.out.println(solu.solve(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        }));
    }

    /**
     * 方法1：普通回溯法
     * @param matrix
     * @return
     */
    //public int solve (int[][] matrix) {
    //        int R = matrix.length;
    //        int C = matrix[0].length;
    //        boolean[][] visited = new boolean[R][C];
    //        int max = Integer.MIN_VALUE;
    //        for (int r = 0; r < R; r++) {
    //            for (int c = 0; c < C; c++) {
    //                visited[r][c]=true;
    //                max = Math.max(max,backtrack(visited,matrix,r,c));
    //                visited[r][c]=false;
    //            }
    //        }
    //        return max;
    //}
    //
    //private int backtrack(boolean[][]visited,int[][]matrix,int r,int c) {
    //    int R = matrix.length;
    //    int C = matrix[0].length;
    //    int[] rows = {0, 0, 1, -1};
    //    int[] cols = {1, -1, 0, 0};
    //    int max = 0;
    //    for (int i = 0; i < 4; i++) {
    //        int nextR = r + rows[i];
    //        int nextC = c + cols[i];
    //        if (valid(R,C,nextR,nextC,visited) && matrix[nextR][nextC]>matrix[r][c]) {
    //            visited[nextR][nextC]=true;
    //            max = Math.max(backtrack(visited,matrix,nextR,nextC),max);
    //            visited[nextR][nextC]=false;
    //        }
    //    }
    //    return max+1;
    //}
    //
    //private boolean valid(int R,int C,int r,int c,boolean[][] visited) {
    //    if (!inBound(R,C,r,c) || visited[r][c]) {
    //        return false;
    //    }
    //    return true;
    //}
    //
    //private boolean inBound(int R,int C,int r,int c) {
    //    if (r<0 || c<0 || r>=R || c>=C) {
    //        return false;
    //    }
    //    return true;
    //}

    private static final int[] rows = {0, 0, 1, -1};
    private static final int[] cols = {1, -1, 0, 0};

    /**
     * 方法2：回溯+记忆化数组
     * @param matrix
     * @return
     */
    public int solve (int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        int[][] memo = new int[R][C];
        int max = Integer.MIN_VALUE;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                max = Math.max(max,backtrack(memo,matrix,r,c));
            }
        }
        return max;
    }

    private int backtrack(int[][]memo,int[][]matrix,int r,int c) {
        if (memo[r][c]!=0) return memo[r][c];
        // 当前为0，说明之前没有访问过
        // 但是这次访问到了，所以这个自增代表访问到自己
        ++memo[r][c];
        int R = matrix.length;
        int C = matrix[0].length;
        for (int i = 0; i < 4; i++) {
            int nextR = r + rows[i];
            int nextC = c + cols[i];
            if (valid(R,C,nextR,nextC) && matrix[nextR][nextC]>matrix[r][c]) {
                memo[r][c] = Math.max(memo[r][c],backtrack(memo,matrix,nextR,nextC)+1);
            }
        }
        return memo[r][c];
    }

    private boolean valid(int R,int C,int r,int c) {
        if (!inBound(R,C,r,c)) {
            return false;
        }
        return true;
    }

    private boolean inBound(int R,int C,int r,int c) {
        if (r<0 || c<0 || r>=R || c>=C) {
            return false;
        }
        return true;
    }
}
