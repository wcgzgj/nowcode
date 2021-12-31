package must.ques;

/**
 * @ClassName NC109_solve
 * @Description TODO
 * @Author faro_z
 * @Date 2021/12/31 3:02 下午
 * @Version 1.0
 **/
public class NC109_solve {
    public static void main(String[] args) {

    }

    public int solve (char[][] grid) {
        if (grid==null || grid.length==0) return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]=='1') count++;
                sinkIsland(i,j,grid);
            }
        }
        return count;
    }

    // 将当前岛屿沉没
    private void sinkIsland(int r,int c,char[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        if (r<0 || r>=R || c<0 || c>=C) return;
        if (grid[r][c]!='1') return;
        grid[r][c]='0';
        int[] rs = {0,0,1,-1};
        int[] cs = {1,-1,0,0};
        for (int i = 0; i < 4; i++) {
            sinkIsland(r+rs[i],c+cs[i],grid);
        }
    }

}
