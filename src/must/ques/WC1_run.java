package must.ques;

import must.domain.TreeNode;

/**
 * @ClassName WC1_run
 * @Description 二叉树最小深度
 * @Author faro_z
 * @Date 2021/10/10 1:44 下午
 * @Version 1.0
 **/
public class WC1_run {
    public static void main(String[] args) {
        WC1_run solu = new WC1_run();
        TreeNode node1 = new TreeNode(1);
        //TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        //node1.left=node2;
        node1.right=node3;
        System.out.println(solu.run(node1));
    }
    public int run (TreeNode root) {
        if (root==null) return 0;
        return dfs(root,0);
    }

    /**
     * @param root
     * @param depth 表示的是上一层的深度
     * @return
     */
    public int dfs(TreeNode root,int depth) {
        if (root==null) {
            return depth;
        }
        // 这道题，一定要主要只有一边有节点的情况（瘸子树）
        if (root.left==null) return dfs(root.right,depth+1);
        if (root.right==null) return dfs(root.left,depth+1);
        return Math.min(dfs(root.left,depth+1),dfs(root.right,depth+1));
    }
}
