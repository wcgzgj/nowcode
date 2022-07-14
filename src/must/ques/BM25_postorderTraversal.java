package must.ques;

import must.domain.TreeNode;

import java.util.*;

/**
 * @ClassName BM25_postorderTraversal
 * @Description 二叉树后序遍历
 * 做法是把先序遍历的结果（"先序遍历"要做个调整，即变成 根-右-左）掉个个儿
 * @Author faro_z
 * @Date 2022/7/14 14:00
 * @Version 1.0
 **/
public class BM25_postorderTraversal {

    public int[] postorderTraversal (TreeNode root) {
        if (root==null) return new int[0];
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerLast(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pollLast();
            res.add(tmp.val);
            if (tmp.left!=null) stack.offerLast(tmp.left);
            if (tmp.right!=null) stack.offerLast(tmp.right);
        }
        Collections.reverse(res);
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}
