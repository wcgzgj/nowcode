package must.ques;

import must.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.nowcoder.com/practice/512688d2ecf54414826f52df4e4b5693?tpId=202&tqId=38846&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fcode-written-high%2Fquestion-ranking
 */

/**
 * @ClassName WC129_NodeNum
 * @Description 完全二叉树节点个数
 * @Author faro_z
 * @Date 2021/10/10 12:22 下午
 * @Version 1.0
 **/
public class WC129_NodeNum {
    public static void main(String[] args) {
        WC129_NodeNum solu = new WC129_NodeNum();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left=node2;
        System.out.println(solu.nodeNum(node1));

    }
    public int nodeNum(TreeNode head) {
        if (head==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int count=0;
        queue.offer(head);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            count++;
            if (tmp.left!=null) queue.offer(tmp.left);
            if (tmp.right!=null) queue.offer(tmp.right);
        }
        return count;
    }
}
