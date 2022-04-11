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
     * @param n n个点
     * @param m m条可能路径
     * @param cost
     * @return
     */
    public int miniSpanningTree (int n, int m, int[][] cost) {
        int minCost = 0;
        UnionFind uf = new UnionFind(n);
        List<int[]> list = new ArrayList<>();
        for (int[] elem : cost) {
            list.add(elem);
        }
        list.sort((o1,o2)->o1[2]-o2[2]);

        for (int[] elem : list) {
            if (uf.find(elem[0]) != uf.find(elem[1])) {
                uf.merge(elem[0],elem[1]);
                minCost+=elem[2];
            }
        }

        return minCost;
    }

    class UnionFind {

        private int N;
        private int[] innerArr;

        public UnionFind(int n) {
            N = n;
            innerArr = new int[N+1];
            init(n);
        }

        /**
         * 并查集初始化
         * 一开始每个节点的父节点都是自己
         * @param n
         */
        private void init(int n) {
            for (int i = 1; i <=N ; i++) {
                innerArr[i]=i;
            }
        }

        /**
         * 查找父节点
         * @param num
         * @return
         */
        public int find(int num) {
            if (innerArr[num]==num) return num;
            //// 方法1：回溯寻找父节点
            //return find(innerArr[num]);

            // 方法2：在递归找寻的时候更新父节点
            // 即让最底层节点直指最顶父节点
            int topFather = find(innerArr[num]);
            innerArr[num] = topFather;
            return topFather;
        }

        /**
         * 合并两个节点所在的集合
         * 即将 num2 的父节点修改为 num1 的父节点
         * @param num1
         * @param num2
         */
        public void merge(int num1,int num2) {
            innerArr[find(num2)] = find(num1);
        }

    }

}
