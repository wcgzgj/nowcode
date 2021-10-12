package test;

import com.sun.tools.javac.util.Pair;
import sun.tools.jstack.JStack;

import java.util.*;

/**
 * @ClassName TableProblem
 * @Description TODO
 * @Author faro_z
 * @Date 2021/10/12 5:17 下午
 * @Version 1.0
 **/
public class TableProblem {
    private static final Scanner sc = new Scanner(System.in);
    private static int count=0;
    public static void main(String[] args) {
        int n = sc.nextInt();
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1,2});
        list.add(new int[]{2,3});
        list.add(new int[]{5,4});
        System.out.println(getTableNum(n,list));
    }

    public static int getTableNum(int n,List<int[]>list) {
        Map<Integer, Set<Integer>> grid = new HashMap<>();
        // 初始化邻接表
        for (int[] pair : list) {
            if (grid.get(pair[0])==null) {
                grid.put(pair[0],new HashSet<Integer>());
            }
            grid.get(pair[0]).add(pair[1]);
        }
        boolean[] visited = new boolean[n + 1];
        for (Integer key : grid.keySet()) {
            if (!visited[key]) {
                visited[key]=true;
                for (Integer end : grid.get(key)) {
                    dfs(end,visited,grid);
                }
            }
        }
        return count;
    }

    public static void dfs(int start,boolean[]visited,Map<Integer, Set<Integer>> grid) {
        if (visited[start]) return;
        // 深度遍历，统计关系个数
        if (grid.get(start)==null || grid.get(start).size()==0) {
            count++;
            return;
        }
        visited[start]=true;
        for (Integer dest : grid.get(start)) {
            dfs(dest,visited,grid);
        }
    }
}
