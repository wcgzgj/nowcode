package must.ques;

import must.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName NC136_solve
 * @Description TODO
 * @Author faro_z
 * @Date 2021/12/31 1:43 下午
 * @Version 1.0
 **/
public class NC136_solve {
    public static void main(String[] args) {
        NC136_solve solu = new NC136_solve();
        int[] xianxu = {1, 2, 4, 5, 3};
        int[] zhongxu = {4,2,5,1,3};
        TreeNode root = solu.buildTree(xianxu, zhongxu);
        outTree(root);
    }

    public int[] solve (int[] xianxu, int[] zhongxu) {
        if (xianxu.length==0) return new int[0];
        // 只有1个或2个节点的情况下，其右视图一定是和先序遍历一样的
        if (xianxu.length<=2) return xianxu;
        TreeNode root = buildTree(xianxu, zhongxu);
        List<Integer> rightView = getRightView(root);
        int[] res = new int[rightView.size()];
        for (int i = 0; i < res.length; i++) {
            res[i]=rightView.get(i);
        }
        return res;
    }

    public TreeNode buildTree(int[] xianxu, int[] zhongxu) {
        if (xianxu==null || xianxu.length==0) return null;
        return buildTree(xianxu,zhongxu,0,xianxu.length-1,0,zhongxu.length-1);
    }

    // 构建二叉树
    private TreeNode buildTree(int[] xianxu, int[] zhongxu,int xl,int xr,int zl,int zr) {
        if (xl>xr) return null;
        int midVal = xianxu[xl];
        TreeNode root = new TreeNode(midVal);
        // 获取左边的长度
        int llen=0;
        for (int i = zl; i <=zr ; i++) {
            if (zhongxu[i]==midVal) {
                llen=i-zl;
                break;
            }
        }
        root.left=buildTree(xianxu,zhongxu,xl+1,xl+llen,zl,zl+llen-1);
        root.right=buildTree(xianxu,zhongxu,xl+llen+1,xr,zl+llen+1,zr);
        return root;
    }


    // 层次遍历，每次获取每层的最后一个元素
    public List<Integer> getRightView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (i==size-1) {
                    rightView.add(tmp.val);
                }
                if (tmp.left!=null) queue.add(tmp.left);
                if (tmp.right!=null) queue.add(tmp.right);
            }
        }
        return rightView;
    }

    public static void outTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                System.out.print(tmp.val+"  ");
                if (tmp.left!=null) queue.add(tmp.left);
                if (tmp.right!=null) queue.add(tmp.right);
            }
            System.out.println();
        }
    }
}
