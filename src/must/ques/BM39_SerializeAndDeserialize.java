package must.ques;

import must.domain.TreeNode;
import must.util.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName BM39_SerializeAndDeserialize
 * @Description TODO
 * @Author faro_z
 * @Date 2022/7/14 18:12
 * @Version 1.0
 **/
public class BM39_SerializeAndDeserialize {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left=n2;
        n1.right=n3;
        n3.left=n4;

        BM39_SerializeAndDeserialize solu = new BM39_SerializeAndDeserialize();
        String seq = solu.Serialize(n1);
        System.out.println(seq);
        TreeUtil.bfsPrint(solu.Deserialize(seq));
    }

    String Serialize(TreeNode root) {
        if (root==null) return "";
        StringBuilder builder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll!=null) {
                builder.append(poll.val).append("_");
                queue.offer(poll.left);
                queue.offer(poll.right);
            } else {
                builder.append("null_");
            }
        }
        return builder.substring(0,builder.length()-1);
    }

    TreeNode Deserialize(String str) {
        if (str.equals("")) return null;
        String[] split = str.split("_");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(buildTreeNode(split[0]));
        TreeNode root = queue.peek();
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            TreeNode left = buildTreeNode(split[index++]);
            TreeNode right = buildTreeNode(split[index++]);
            if (left!=null) {
                queue.offer(left);
                poll.left=left;
            }
            if (right!=null) {
                queue.offer(right);
                poll.right = right;
            }
        }
        return root;
    }

    private TreeNode buildTreeNode(String val) {
        if ("null".equals(val)) return null;
        return new TreeNode(Integer.parseInt(val));
    }
}
