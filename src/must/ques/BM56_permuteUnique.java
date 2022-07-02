package must.ques;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName BM56_permuteUnique
 * @Description TODO
 * @Author faro_z
 * @Date 2022/7/2 17:06
 * @Version 1.0
 **/
public class BM56_permuteUnique {
    public static void main(String[] args) {
        BM56_permuteUnique solu = new BM56_permuteUnique();
        System.out.println(solu.permuteUnique(new int[]{1,1,2}));
    }

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (num==null || num.length==0) return res;
        Arrays.sort(num);
        ArrayList<Integer> track = new ArrayList<>();
        boolean[] visited = new boolean[num.length];
        dfs(visited,num,track,res);
        return res;
    }

    private void dfs(boolean[]visited, int[] num, ArrayList<Integer> track, ArrayList<ArrayList<Integer>> res) {
        if (num.length==track.size()) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] || i>0 && num[i]==num[i-1] && !visited[i-1]) {
                continue;
            }
            visited[i]=true;
            track.add(num[i]);
            dfs(visited,num,track,res);
            visited[i]=false;
            track.remove(track.size()-1);
        }
    }
}
