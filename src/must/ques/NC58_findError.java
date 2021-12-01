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

    /**
     * 题目：
     * 一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，使得这棵二叉树不再是搜索二叉树，
     * 请按升序输出这两个错误节点的值。(每个节点的值各不相同)
     * 搜索二叉树：满足每个节点的左子节点小于当前节点，右子节点大于当前节点。
     *
     * 思考：
     * 这道题的答题做法如下
     * 1、使用中序遍历，获得节点的遍历顺序
     * 2、在中序遍历的序列中，获得被调换顺序的两个数
     *
     */
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
