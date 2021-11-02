package must.ques;

import java.util.Arrays;

/**
 * 现在有一个仅包含‘X’和‘O’的二维板，请捕获所有的被‘X’包围的区域
 * 捕获一个被包围区域的方法是将被包围区域中的所有‘O’变成‘X’
 * 例如
 * X X X X
 * X O O X
 * X X O X
 * O X X X
 * 执行完你给出的函数以后，这个二维板应该变成：
 * X X X X
 * X X X X
 * X X X X
 * O X X X
 **/
public class CC21_solve {
    public static void main(String[] args) {
            //char[][] board = {  {'X','X','X','X'},
            //                    {'X','O','O','X'},
            //                    {'X','X','O','X'},
            //                    {'O','X','X','X'}};
        //char[][] board ={{'O','O'},
        //                {'O','O'}};
        char[][] board =   {{'O','O','O','O','X','X'},
                            {'O','O','O','O','O','O'},
                            {'O','X','O','X','O','O'},
                            {'O','X','O','O','X','O'}, // 照理说，这一行第四个元素不应该被修改的，但是，他却被修改了！！
                            {'O','X','O','X','O','O'},
                            {'O','X','O','O','O','O'}};
        CC21_solve solu = new CC21_solve();
        solu.solve(board);
        int R = board.length;
        int C = board[0].length;
        for (int i = 0; i <R ; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(board[i][j]+"  ");
            }
            System.out.println();
        }
    }

    public void solve(char[][] board) {
        int R = board.length;
        if (R==0) return;
        int C = board[0].length;
        if (C==0) return;
        boolean[][] visited = new boolean[R][C];
        for (int i = 0; i <R; i++) {
            for (int j = 0; j < C; j++) {
                // 当前位置为 O 且还没有被访问过
                // （没访问是因为我们之前的 dfs 操作，可能已经让改点被访问过了）
                if (board[i][j]=='O' && !visited[i][j]) {
                    dfs(visited,board,i,j);
                }
            }
        }
    }

    public boolean dfs(boolean[][]visited,char[][]board,int r,int c) {
        int R = board.length;
        int C = board[0].length;
        // 如果 O 界限的边界触碰到 board 边缘，说明不符合条件
        if (r<0 || r>=R || c<0 || c>=C) return false;
        // 如果是 X 或者是已经访问过了，那么认为这个位置是可行的
        if (board[r][c]=='X' || visited[r][c]) return true;

        visited[r][c]=true;

        int[] rs = {0,0,1,-1};
        int[] cs = {1,-1,0,0};
        boolean res = true;
        for (int i = 0; i < 4; i++) {
            //这里要保证所有方向都符合条件
            res = res && dfs(visited,board,r+rs[i],c+cs[i]);
        }
        if (res) {
            board[r][c]='X';
        }
        return res;
    }
}
