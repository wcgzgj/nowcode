package must.ques;

/**
 * @ClassName NC18_rotateMatrix
 * @Description TODO
 * @Author faro_z
 * @Date 2022/1/1 3:44 下午
 * @Version 1.0
 **/
public class NC18_rotateMatrix {
    public static void main(String[] args) {

    }

    // 方法1：
    //public int[][] rotateMatrix(int[][] mat, int n) {
    //    if (mat==null || mat.length==0) return null;
    //    int[][] res = new int[mat.length][mat[0].length];
    //    for (int i = 0; i < mat.length; i++) {
    //        for (int j = 0; j < mat[0].length; j++) {
    //            res[j][n-i-1] = mat[i][j];
    //        }
    //    }
    //    return res;
    //}

    // 方法2
    public int[][] rotateMatrix(int[][] mat, int n) {
        // 主对角线反转
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                swap(mat,i,j,j,i);
            }
        }
        // 左右反转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                swap(mat,i,j,i,n-j-1);
            }
        }
        return mat;
    }

    private void swap(int[][]mat,int x1,int y1,int x2,int y2) {
        int tmp = mat[x1][y1];
        mat[x1][y1]=mat[x2][y2];
        mat[x2][y2]=tmp;
    }
}
