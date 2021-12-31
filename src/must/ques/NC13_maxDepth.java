package must.ques;

import must.domain.TreeNode;

/**
 * @ClassName NC13_maxDepth
 * @Description TODO
 * @Author faro_z
 * @Date 2021/12/31 3:41 下午
 * @Version 1.0
 **/
public class NC13_maxDepth {
    public static void main(String[] args) {

    }

    public int maxDepth (TreeNode root) {
        if(root==null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
