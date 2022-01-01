package must.ques;

import must.domain.TreeNode;

/**
 * @ClassName NC16_isSymmetrical
 * @Description TODO
 * @Author faro_z
 * @Date 2022/1/1 2:50 下午
 * @Version 1.0
 **/
public class NC16_isSymmetrical {
    public static void main(String[] args) {

    }

    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot==null) return true;
        return dfs(pRoot.left,pRoot.right);
    }

    public boolean dfs(TreeNode left,TreeNode right) {
        if (left==null && right==null) return true;
        if (left==null || right==null) return false;
        if (left.val!=right.val) return false;
        return dfs(left.left,right.right) && dfs(left.right,right.left);
    }

}
