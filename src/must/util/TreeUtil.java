package must.util;

import must.domain.TreeNode;

import java.util.*;

/**
 * @ClassName TreeUtil
 * @Description TODO
 * @Author faro_z
 * @Date 2022/6/6 13:18
 * @Version 1.0
 **/
public class TreeUtil {
    /**
     * 根据字符串序列，构造树
     * 合法的序列 1,2,3,4,#,5
     *      1
     *     / \
     *    2   3
     *   /    /
     *  4    5
     * @param seq
     * @return
     */
    public static TreeNode buildTreeBySeq(String seq) {
        Queue<String> pool = new LinkedList<>(Arrays.asList(seq.split(",")));
        Queue<TreeNode> queue = new LinkedList<>();
        String rootVal = pool.poll();
        if (rootVal==null || "#".equals(rootVal)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(rootVal));
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            String lVal = pool.poll();
            String rVal = pool.poll();
            if (lVal!=null && !"#".equals(lVal)) {
                tmp.left=new TreeNode(Integer.parseInt(lVal));
                queue.offer(tmp.left);
            }
            if (rVal!=null && !"#".equals(rVal)) {
                tmp.right=new TreeNode(Integer.parseInt(rVal));
                queue.offer(tmp.right);
            }
        }
        return root;
    }

    //private static TreeNode createTreeNode(String str) {
    //    int res = 0;
    //    try {
    //        res = Integer.parseInt(str);
    //    } catch (Exception e) {
    //        return null;
    //    }
    //    return new TreeNode(res);
    //}

    /**
     * 根据 bfs ，打印树的序列
     * @param root
     */
    public static void bfsPrint(TreeNode root) {
        if (root==null) System.out.println("#");
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        queue.add(root);
        while (!queue.isEmpty()) {
            int currRowSize = queue.size();
            for (int i = 0; i < currRowSize; i++) {
                TreeNode tmp = queue.poll();
                builder.append(tmp.val).append(",");
                if (tmp.left!=null) queue.add(tmp.left);
                if (tmp.right!=null) queue.add(tmp.right);
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }


}
