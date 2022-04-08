package must.ques;

import java.util.*;

/**
 * @ClassName leetcode210_findOrder
 * @Description TODO
 * @Author faro_z
 * @Date 2022/4/1 4:58 下午
 * @Version 1.0
 **/
public class leetcode210_findOrder {
    public static void main(String[] args) {
        leetcode210_findOrder solu = new leetcode210_findOrder();
        System.out.println(Arrays.toString(solu.findOrder(2,new int[][]{{1,0}})));
    }

    /**
     * 拓卜排序
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 统计 topo 顺序
        List<Integer> res = new ArrayList<>();
        // 记录每个点的出度
        Map<Integer, Integer> interMap = new HashMap<>();
        // 记录入度为 0 的点
        ArrayList<Integer> zeroInterList = new ArrayList<>();
        // 统计每个点的入度
        for (int[] elem : prerequisites) {
            interMap.put(elem[0],interMap.getOrDefault(elem[0],0)+1);
            //interMap.put(elem[1],interMap.getOrDefault(elem[1],0));
        }
        for (int i = 0; i < numCourses; i++) {
            interMap.put(i,interMap.getOrDefault(i,0));
        }
        // 收集所有入度为 0 的点
        for (Integer key : interMap.keySet()) {
            if (interMap.get(key)==0) {
                zeroInterList.add(key);
            }
        }
        while (!zeroInterList.isEmpty()) {
            int start = zeroInterList.remove(0);
            res.add(start);
            for (int[] elem : prerequisites) {
                if (elem[1]==start) {
                    interMap.put(elem[0],interMap.get(elem[0])-1);
                    // 更新入度为 0 的节点表
                    if (interMap.get(elem[0])==0) {
                        zeroInterList.add(elem[0]);
                    }
                }
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=res.get(i);
        }
        return arr;
    }
}
