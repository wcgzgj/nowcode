package must.ques;

import must.domain.TreeNode;

/**
 * @ClassName CC27_maxPathSum
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/8 1:31 下午
 * @Version 1.0
 **/
public class CC27_maxPathSum {
    public static void main(String[] args) {

    }

    private static int res = Integer.MIN_VALUE;

    public int maxPathSum (TreeNode root) {
        if (root==null) return 0;
        maxGiven(root);
        return res;
    }

    // 计算最大贡献值
    // 这个函数，既会返回当前节点的最大贡献值
    // 也会在遍历过程中，当达到叶子节点的时候，修改 res 的值
    private int maxGiven(TreeNode root) {
        if (root==null) return 0;
        // 如果发现哪一方的贡献值为负数，那就不考虑了
        int leftGiven = Math.max(maxGiven(root.left), 0);
        int rightGiven = Math.max(maxGiven(root.right), 0);
        // 这就是我提到的在过程中进行修改
        res = Math.max(res,leftGiven+rightGiven+root.val);

        // 最大贡献值只能是一条边的
        return root.val+Math.max(leftGiven,rightGiven);
    }
}
