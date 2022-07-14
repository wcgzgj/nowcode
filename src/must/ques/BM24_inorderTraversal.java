package must.ques;

import must.domain.TreeNode;

import java.util.*;
import java.util.Stack;

/**
 * @ClassName BM24_inorderTraversal
 * @Description TODO
 * @Author faro_z
 * @Date 2022/5/29 6:49 下午
 * @Version 1.0
 **/
public class BM24_inorderTraversal {

    public static void main(String[] args) {

    }

    // 方法1：使用递归
    //public int[] inorderTraversal (TreeNode root) {
    //    List<Integer> track = new ArrayList<>();
    //    dfs(root,track);
    //    int[] res = new int[track.size()];
    //    for (int i = 0; i < track.size(); i++) {
    //        res[i] = track.get(i);
    //    }
    //    return res;
    //}
    //
    //private void dfs(TreeNode root, List<Integer>track) {
    //    if (root==null) return;
    //    if (root.left!=null) track.add(root.left.val);
    //    track.add(root.val);
    //    if (root.right!=null) track.add(root.right.val);
    //}

    public int[] inorderTraversal (TreeNode root) {
        if (root==null) return new int[0];
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        while (curr!=null || !stack.isEmpty()) {
            while (curr!=null) {
                stack.offerLast(curr);
                curr = curr.left;
            }
            curr = stack.pollLast();
            res.add(curr.val);
            curr = curr.right;
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}
