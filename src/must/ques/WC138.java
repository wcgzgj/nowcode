package must.ques;

import must.domain.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName WC138
 * @Description 二叉树遍历
 * @Author faro_z
 * @Date 2021/9/13 5:08 下午
 * @Version 1.0
 **/
public class WC138 {
    public int[][] threeOrders (TreeNode root) {
        // write code here
        List<Integer> preRes = new ArrayList<>();
        List<Integer> midRes = new ArrayList<>();
        List<Integer> postRes = new ArrayList<>();
        preOrder(root,preRes);
        midOrder(root,midRes);
        postOrder(root,postRes);
        int[][] res = new int[3][preRes.size()];
        res[0]=toArray(preRes);
        res[1]=toArray(midRes);
        res[2]=toArray(postRes);

        return res;
    }

    private int[] toArray(List<Integer>list) {
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i]=list.get(i);
        }
        return res;
    }

    public void preOrder(TreeNode root,List<Integer>res) {
        if (root==null) return;
        res.add(root.val);
        preOrder(root.left,res);
        preOrder(root.right,res);
    }

    public void midOrder(TreeNode root,List<Integer>res) {
        if (root==null) return;
        midOrder(root.left,res);
        res.add(root.val);
        midOrder(root.right,res);
    }

    public void postOrder(TreeNode root,List<Integer>res) {
        if (root==null) return;
        postOrder(root.left,res);
        postOrder(root.right,res);
        res.add(root.val);
    }
}
