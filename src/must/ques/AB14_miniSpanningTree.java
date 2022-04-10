package must.ques;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName AB14_miniSpanningTree
 * @Description TODO
 * @Author faro_z
 * @Date 2022/4/8 9:09 下午
 * @Version 1.0
 **/
public class AB14_miniSpanningTree {
    public static void main(String[] args) {
        AB14_miniSpanningTree solu = new AB14_miniSpanningTree();
        /**
         * 6,10
         * [5,3,8],[1,3,6],[2,5,4],[2,3,5],[4,5,6],[3,4,3],[2,4,8],[1,2,2],[1,4,5],[5,6,2]
         */
        int[][] cost = new int[][]{
                {5,3,8}, {1,3,6},{2,5,4},{2,3,5},{4,5,6},{3,4,3},{2,4,8},{1,2,2},{1,4,5},{5,6,2}
        };
        System.out.println(solu.miniSpanningTree(6,10,cost));
    }

    /**
     * 方法1：克鲁斯卡（贪心）
     * 先将所有路径权值排序，然后
     * @param n
     * @param m
     * @param cost
     * @return
     */
    public int miniSpanningTree (int n, int m, int[][] cost) {
        int minCost = 0;
        // 使用 visited 数组，可以保证所有位置都能访问，但是不能保证联通！！！！
        // 这里可以考虑使用并查集！！
        boolean[] visited = new boolean[n+1];
        List<int[]> list = new ArrayList<>();
        for (int[] elem : cost) {
            list.add(elem);
        }
        list.sort((o1,o2)->o1[2]-o2[2]);
        for (int[] elem : list) {
            if (!visited[elem[0]] || !visited[elem[1]]) {
                visited[elem[0]]=true;
                visited[elem[1]]=true;
                minCost+=elem[2];
            }
        }
        System.out.println("visited数组情况为："+ Arrays.toString(visited));
        return minCost;
    }

}
