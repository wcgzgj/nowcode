package must.ques;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName leetcodee547_findCircleNum
 * @Description TODO
 * @Author faro_z
 * @Date 2022/4/10 10:11 下午
 * @Version 1.0
 **/
public class leetcodee547_findCircleNum {
    public static void main(String[] args) {

    }

    /**
     * 获取省份
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        if (isConnected==null || isConnected.length==0) return 0;
        int n = isConnected.length;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j]==1) {
                    unionFind.merge(i,j);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(unionFind.find(i));
        }
        return set.size();
    }

    class UnionFind {
        private int N;
        private int[] innerArr;

        public UnionFind(int n) {
            N = n;
            innerArr = new int[N];
            init();
        }

        private void init() {
            for (int i = 0; i <N ; i++) {
                innerArr[i]=i;
            }
        }

        public int find(int num) {
            if (innerArr[num]==num) return num;
            int topFather = find(innerArr[num]);
            innerArr[num] = topFather;
            return topFather;
        }

        public void merge(int num1,int num2) {
            innerArr[find(num2)] = find(num1);
        }
    }
}
