package must.ques;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName leetcode_78
 * @Description TODO
 * @Author faro_z
 * @Date 2021/9/23 1:21 上午
 * @Version 1.0
 **/
public class leetcode_78 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> track = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0,nums);
        return res;
    }

    public void dfs(int index,int[] nums) {
        // 递归终止
        if (index>=nums.length) {
            // 一定要新 new 一个 List
            res.add(new ArrayList<>(track));
            return;
        }
        // 当前位置选
        track.add(nums[index]);
        dfs(index+1,nums);
        track.remove(track.size()-1);

        // 当前位置不选
        dfs(index+1,nums);
    }
}
