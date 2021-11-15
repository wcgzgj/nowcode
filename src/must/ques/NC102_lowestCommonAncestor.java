package must.ques;

import must.domain.ListNode;
import must.domain.TreeNode;

/**
 * @ClassName NC102_lowestCommonAncestor
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/15 1:54 下午
 * @Version 1.0
 **/
public class NC102_lowestCommonAncestor {
    public static void main(String[] args) {

    }

    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        return helper(root,o1,o2).val;
    }

    public TreeNode helper(TreeNode root, int o1, int o2) {
        if (root==null || root.val==o1 || root.val==o2) return root;
        TreeNode left = helper(root.left, o1, o2);
        TreeNode right = helper(root.right, o1, o2);
        if (left==null) return right;
        if (right==null) return left;
        return root;
    }
}
