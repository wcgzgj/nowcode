package must.util;

import must.domain.TreeNode;

/**
 * @ClassName MyTree
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/2 3:07 下午
 * @Version 1.0
 **/
public class MyTree {
    private static TreeNode root;
    /*
    最后构建的树是这样的形式
            1
           / \
          2   3
         / \
        4   5

     */
    static {
        root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        root.left=n2;
        root.right=n3;
        n2.left=n4;
        n2.right=n5;
    }

    public static TreeNode getRoot() {
        return root;
    }
}
