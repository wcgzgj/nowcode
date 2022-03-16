package must.ques;

/**
 * @ClassName NC59_minPathSum
 * @Description 矩阵的最小路径和
 * @Author faro_z
 * @Date 2022/3/16 3:37 下午
 * @Version 1.0
 **/
public class NC59_minPathSum {
    public static void main(String[] args) {
        //int[][] matrix = {{1, 2, 3},
        //                  {1, 2, 3}};
        //NC59_minPathSum solu = new NC59_minPathSum();
        //System.out.println(solu.minPathSum(matrix));
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
}
