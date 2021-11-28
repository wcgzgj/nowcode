package must.ques;

import must.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName NC58_findError
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/28 2:44 下午
 * @Version 1.0
 **/
public class NC58_findError {
    public static void main(String[] args) {

    }

    public int[] findError (TreeNode root) {
        int[] res = new int[2];
        List<Integer> nums = new ArrayList<>();
        return findErr(nums);
    }

    public void dfs(List<Integer>nums,TreeNode root) {
        if (root==null) return;
        dfs(nums,root.left);
        nums.add(root.val);
        dfs(nums,root.right);
    }

    public int[] findErr(List<Integer>nums) {
        int[] res = new int[2];
        int count=0;
        for (int i = 0; i < nums.size(); i++) {
            if (count>=2) return res;
            if (i>0 && nums.get(i)<nums.get(i-1)) {
                res[0]=nums.get(i);
                count++;
            }
            if (i<nums.size()-2 && nums.get(i)>nums.get(i+1)) {
                res[1]=nums.get(i);
                count++;
            }
        }
        return res;
    }

}
