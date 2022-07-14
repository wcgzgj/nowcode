package must.ques;

import must.domain.TreeNode;
import sun.tools.jconsole.inspector.Utils;

/**
 * @ClassName BM37_lowestCommonAncestor
 * @Description TODO
 * @Author faro_z
 * @Date 2022/7/14 17:41
 * @Version 1.0
 **/
public class BM37_lowestCommonAncestor {
    public static void main(String[] args) {

    }

    // 对于所有二叉树
    //public int lowestCommonAncestor (TreeNode root, int p, int q) {
    //    if (root==null) return -1;
    //    if (root.val==p || root.val==q) return root.val;
    //    int left = lowestCommonAncestor(root.left, p, q);
    //    int right = lowestCommonAncestor(root.right, p, q);
    //    if (left!=-1 && right!=-1) return root.val;
    //    if (left==-1) return right;
    //    else return left;
    //}

    // 对于二叉搜索树
    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        if (root.val<p && root.val<q) {
            return lowestCommonAncestor(root.right,p,q);
        }
        if (root.val>p && root.val>q) {
            return lowestCommonAncestor(root.left,p,q);
        }
        return root.val;
    }
}
