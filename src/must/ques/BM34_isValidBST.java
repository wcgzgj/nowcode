package must.ques;

import must.domain.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName BM34_isValidBST
 * @Description TODO
 * @Author faro_z
 * @Date 2022/7/14 16:11
 * @Version 1.0
 **/
public class BM34_isValidBST {
    public static void main(String[] args) {

    }

    // 1、坏递归 :(
    //public boolean isValidBST (TreeNode root) {
    //    if (root==null) return true;
    //    if ((root.left!=null && maxVal(root.left)>=root.val) ||
    //            (root.right!=null && minVal(root.right)<=root.val)) {
    //        return false;
    //    }
    //    return isValidBST(root.left) && isValidBST(root.right);
    //}
    //
    //// 获取当前节点下的最大值
    //private int maxVal (TreeNode root) {
    //    if (root==null) return Integer.MIN_VALUE;
    //    return Math.max(root.val,Math.max(maxVal(root.left),maxVal(root.right)));
    //}
    //
    //// 获取当前节点下的最大值
    //private int minVal (TreeNode root) {
    //    if (root==null) return Integer.MAX_VALUE;
    //    return Math.min(root.val,Math.min(minVal(root.left),minVal(root.right)));
    //}

    // 好递归 :)
    public boolean isValidBST (TreeNode root) {
        return inorder(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private boolean inorder(TreeNode root,int l,int r) {
        if (root==null) return true;
        if (root.val<=l || root.val>=r) return false;
        return inorder(root.left,l, root.val) && inorder(root.right,root.val,r);
    }

    // 好迭代 :)
    //public boolean isValidBST (TreeNode root) {
    //    if (root==null) return true;
    //    Deque<TreeNode> stack = new LinkedList<>();
    //    TreeNode curr = root;
    //    while (curr!=null || !stack.isEmpty()) {
    //        while (curr!=null) {
    //            stack.offerLast(curr);
    //            curr = curr.left;
    //        }
    //        curr = stack.pollLast();
    //        if (stack.peekLast()!=null && curr.val>=stack.peekLast().val) {
    //            return false;
    //        }
    //        curr = curr.right;
    //    }
    //    return true;
    //}
}
