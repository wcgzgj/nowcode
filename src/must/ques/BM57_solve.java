package must.ques;

import java.util.Arrays;

/**
 * @ClassName BM57_solve
 * @Description https://www.nowcoder.com/practice/0c9664d1554e466aa107d899418e814e?tpId=295&tqId=1024684
 * @Author faro_z
 * @Date 2022/7/4 17:36
 * @Version 1.0
 **/
public class BM57_solve {
    public static void main(String[] args) {
        BM57_solve solu = new BM57_solve();
        char[][] grid = {
                {'1'}
        };
        System.out.println(solu.solve(grid));
    }

    private static final int[] rows = {0, 0, 1, -1};
    private static final int[] cols = {1, -1, 0, 0};

    public int solve (char[][] grid) {
        char[][] dummy = Arrays.copyOf(grid, grid.length);
        int count = 0;
        for (int i = 0; i < dummy.length; i++) {
            for (int j = 0; j < dummy[0].length; j++) {
                if (dummy[i][j]=='1') {
                    ++count;
                    sinkIsland(i,j,dummy);
                }
            }
        }
        return count;
    }

    private void sinkIsland(int r,int c,char[][]grid) {
        if (r<0 || c<0 || r>=grid.length || c>=grid[0].length) return;
        if (grid[r][c]=='0') return;
        grid[r][c]='0';
        for (int i = 0; i < 4; i++) {
            sinkIsland(r+rows[i],c+cols[i],grid);
        }
    }
}
