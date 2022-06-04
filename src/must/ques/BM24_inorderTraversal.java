package must.ques;

import must.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BM24_inorderTraversal
 * @Description TODO
 * @Author faro_z
 * @Date 2022/5/29 6:49 下午
 * @Version 1.0
 **/
public class BM24_inorderTraversal {

    public int[] inorderTraversal (TreeNode root) {
        List<Integer> track = new ArrayList<>();
        dfs(root,track);
        int[] res = new int[track.size()];
        for (int i = 0; i < track.size(); i++) {
            res[i] = track.get(i);
        }
        return res;
    }

    private void dfs(TreeNode root, List<Integer>track) {
        if (root==null) return;
        if (root.left!=null) track.add(root.left.val);
        track.add(root.val);
        if (root.right!=null) track.add(root.right.val);
    }
}
