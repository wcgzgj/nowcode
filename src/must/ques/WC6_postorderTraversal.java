package must.ques;

import must.domain.ListNode;
import must.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName WC6_postorderTraversal
 * @Description TODO
 * @Author faro_z
 * @Date 2021/10/11 10:57 上午
 * @Version 1.0
 **/
public class WC6_postorderTraversal {

    public ArrayList<Integer> postorderTraversal (TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        dfs(res,root);
        return res;
    }

    private void dfs(List<Integer> res,TreeNode root) {
        if (root==null) return;
        dfs(res,root.left);
        dfs(res,root.right);
        res.add(root.val);
    }
}
