package must.ques;

import must.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName leetcode653_findTarget
 * @Description TODO
 * @Author faro_z
 * @Date 2022/7/7 17:49
 * @Version 1.0
 **/
public class leetcode653_findTarget {
    public static void main(String[] args) {

    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> order = new ArrayList<>();
        inOrder(order,root);
        int l=0,r=order.size()-1;
        while (l<r) {
            int tmp = order.get(l) + order.get(r);
            if (tmp==k) return true;
            else if (tmp<k) l++;
            else r--;
        }
        return false;
    }

    private void inOrder(List<Integer>order,TreeNode root) {
        if (root==null) return;
        inOrder(order,root.left);
        order.add(root.val);
        inOrder(order,root.right);
    }
}
