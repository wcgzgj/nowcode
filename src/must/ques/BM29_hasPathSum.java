package must.ques;

import must.domain.TreeNode;

/**
 * @ClassName BM29_hasPathSum
 * @Description TODO
 * @Author faro_z
 * @Date 2022/7/13 23:32
 * @Version 1.0
 **/
public class BM29_hasPathSum {
    public static void main(String[] args) {

    }

    public boolean hasPathSum (TreeNode root, int sum) {
        if (root==null) return false;
        if (root.left==null && root.right==null && root.val == sum) return true;
        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }
}
