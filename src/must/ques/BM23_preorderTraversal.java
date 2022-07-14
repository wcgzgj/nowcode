package must.ques;

import must.domain.TreeNode;

import java.util.*;
import java.util.Stack;

/**
 * @ClassName BM23_preorderTraversal
 * @Description TODO
 * @Author faro_z
 * @Date 2022/5/28 5:32 下午
 * @Version 1.0
 **/
public class BM23_preorderTraversal {

    // 方法1：递归
    //public int[] preorderTraversal (TreeNode root) {
    //    List<Integer> res = new ArrayList<>();
    //    dfs(res,root);
    //    int[] resArr = new int[res.size()];
    //    for (int i = 0; i < res.size(); i++) {
    //        resArr[i]=res.get(i);
    //    }
    //    return resArr;
    //}
    //
    //private void dfs(List<Integer>res,TreeNode root) {
    //    if (root==null) return;
    //    res.add(root.val);
    //    dfs(res,root.left);
    //    dfs(res,root.right);
    //}

    // 方法2：使用栈
    //public int[] preorderTraversal (TreeNode root) {
    //    Stack<TreeNode> stack = new Stack<>();
    //    List<Integer> res = new ArrayList<>();
    //    if (root==null) return new int[0];
    //    stack.push(root);
    //    while (!stack.isEmpty()) {
    //        TreeNode tmp = stack.pop();
    //        res.add(tmp.val);
    //        if (tmp.right!=null) stack.push(tmp.right);
    //        if (tmp.left!=null) stack.push(tmp.left);
    //    }
    //    int[] resArr = new int[res.size()];
    //    for (int i = 0; i < res.size(); i++) {
    //        resArr[i]=res.get(i);
    //    }
    //    return resArr;
    //}

    // 使用栈（复习）
    public int[] preorderTraversal (TreeNode root) {
        if (root==null) return new int[0];
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerLast(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pollLast();
            res.add(tmp.val);
            if (tmp.right!=null) stack.offerLast(tmp.right);
            if (tmp.left!=null) stack.offerLast(tmp.left);
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}
