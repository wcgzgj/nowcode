package must.ques;

import must.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName BM35_isCompleteTree
 * @Description TODO
 * @Author faro_z
 * @Date 2022/7/14 16:50
 * @Version 1.0
 **/
public class BM35_isCompleteTree {
    public static void main(String[] args) {

    }

    //public boolean isCompleteTree (TreeNode root) {
    //    if (root==null) return true;
    //    //if (isLeaf(root)) return true;
    //    Queue<TreeNode> queue = new LinkedList<>();
    //    queue.offer(root);
    //    int lay = -1;
    //    while (!queue.isEmpty()) {
    //        ++lay;
    //        int rowSize = queue.size();
    //        boolean isBottom = rowSize < 2<<lay;
    //        for (int i = 0; i < rowSize; i++) {
    //            TreeNode tmp = queue.poll();
    //            if ((tmp.left==null && tmp.right!=null) ||
    //                    (isBottom && !isLeaf(tmp))) {
    //                return false;
    //            }
    //            if (tmp.left!=null) {
    //                queue.offer(tmp.left);
    //            }
    //            if (tmp.right!=null) {
    //                queue.offer(tmp.right);
    //            }
    //        }
    //    }
    //    return true;
    //}
    //
    //private boolean isLeaf(TreeNode root) {
    //    return root == null || root.left==null && root.right==null;
    //}

    public boolean isCompleteTree (TreeNode root) {
        if (root==null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean hasNull = false;
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (tmp==null) {
                hasNull=true;
                continue;
            }
            if (hasNull) return false;
            queue.offer(tmp.left);
            queue.offer(tmp.right);
        }
        return true;
    }
}
