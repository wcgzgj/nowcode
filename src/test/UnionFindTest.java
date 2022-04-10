package test;

/**
 * @ClassName UnionFindTest
 * @Description TODO
 * @Author faro_z
 * @Date 2022/4/10 7:58 下午
 * @Version 1.0
 **/
public class UnionFindTest {
    public static void main(String[] args) {
        UnionFind uf = new UnionFind(7);
        uf.merge(1,2);
        uf.merge(5,7);
        uf.merge(2,7);
        System.out.println(uf.find(5));
        System.out.println(uf.find(7));
    }

    static class UnionFind {

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
