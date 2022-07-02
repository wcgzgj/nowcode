package must.ques;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName BM55_permute
 * @Description
 * 给出一组数字，返回该组数字的所有排列
 * 例如：
 * [1,2,3]的所有排列如下
 * [1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2], [3,2,1].
 * （以数字在数组中的位置靠前为优先级，按字典序排列输出。）
 * https://www.nowcoder.com/practice/4bcf3081067a4d028f95acee3ddcd2b1?tpId=295&tqId=701&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
 * @Author faro_z
 * @Date 2022/7/2 16:55
 * @Version 1.0
 **/
public class BM55_permute {
    public static void main(String[] args) {
        BM55_permute solu = new BM55_permute();
        System.out.println(solu.permute(new int[]{1,2,3}));
    }

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (num==null || num.length==0) return res;
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
            if (!visited[i]) {
                visited[i]=true;
                track.add(num[i]);
                dfs(visited,num,track,res);
                visited[i]=false;
                track.remove(track.size()-1);
            }
        }
    }

}
