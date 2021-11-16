package must.ques;

import java.util.ArrayList;

/**
 * @ClassName NC38_spiralOrder
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/16 6:59 下午
 * @Version 1.0
 **/
public class NC38_spiralOrder {
    public static void main(String[] args) {
        NC38_spiralOrder solu = new NC38_spiralOrder();
        //int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] grid = {{1}};
        System.out.println(solu.spiralOrder(grid));
    }

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length==0) return res;
        if (matrix[0].length==0) return res;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        // 记录一共需要遍历多少节点
        int stepCount = matrix.length*matrix[0].length;
        // 四个遍历方向
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dirCount=0;
        int r=0,c=0;
        while (stepCount-->0) {
            visited[r][c]=true;
            res.add(matrix[r][c]);
            if (onEdge(r,c,matrix,visited,dirCount)) {
                dirCount++;
            }
            r+=dir[dirCount%4][0];
            c+=dir[dirCount%4][1];
        }
        return res;
    }

    // 判断是否到达边界
    // 注意，这个边界与移动方向是有关系的
    public boolean onEdge(int r,int c,int[][] matrix,boolean[][]visited,int dirCount) {
        int dir = dirCount % 4;
        int[][] dirArr = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int R = matrix.length;
        int C = matrix[0].length;
        int nextR = r + dirArr[dirCount % 4][0];
        int nextC = c + dirArr[dirCount % 4][1];
        switch (dir) {
            case 0: // 往右
                if (c==C-1 || visited[nextR][nextC]) return true;
                break;
            case 1:
                if (r==R-1 || visited[nextR][nextC]) return true;
                break;
            case 2:
                if (c==0 || visited[nextR][nextC]) return true;
                break;
            case 3:
                if (r==0 || visited[nextR][nextC]) return true;
                break;
        }
        return false;
    }
}
