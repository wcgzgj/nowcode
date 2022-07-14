package must.ques;

import must.domain.TreeNode;

/**
 * @ClassName BM32_mergeTrees
 * @Description TODO
 * @Author faro_z
 * @Date 2022/7/14 15:58
 * @Version 1.0
 **/
public class BM32_mergeTrees {
    public static void main(String[] args) {

    }

    //public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
    //    if (t1==null || t2==null) return t2;
    //    dfs(t1,t2);
    //    return t1;
    //}
    //
    //private void dfs(TreeNode t1,TreeNode t2) {
    //    if (t1==null || t2==null) return;
    //    t1.val = t1.val+ t2.val;
    //    dfs(t1.left,t2.left);
    //    dfs(t1.right,t2.right);
    //    if (t1.left==null) t1.left = t2.left;
    //    if (t1.right==null) t1.right = t2.right;
    //}

    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        if (t1!=null && t2!=null) {
            t1.val+= t2.val;
            t1.left = mergeTrees(t1.left,t2.left);
            t1.right = mergeTrees(t1.right,t2.right);
        }
        return t1==null?t2:t1;
    }
}
