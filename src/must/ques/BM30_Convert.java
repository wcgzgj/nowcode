package must.ques;

import must.domain.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName BM30_Convert
 * @Description 查找树转双向链表
 * @Author faro_z
 * @Date 2022/7/13 23:39
 * @Version 1.0
 **/
public class BM30_Convert {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n2.left = n1;
        n2.right = n3;
        BM30_Convert solu = new BM30_Convert();
        TreeNode head = solu.Convert(n2);
        outDueList(head);
    }

    public static void outDueList(TreeNode head) {
        System.out.println("从左到右：");
        while (head.right!=null) {
            System.out.print(head.val+"->");
            head = head.right;
        }
        System.out.print(head.val);
        System.out.println();
        System.out.println("——————————————");
        System.out.println("从右到左：");
        while (head.left!=null) {
            System.out.print(head.val+"->");
            head = head.left;
        }
        System.out.print(head.val);
    }

    // 方法1：迭代
    //public TreeNode Convert(TreeNode pRootOfTree) {
    //    if (pRootOfTree==null) return null;
    //    TreeNode hair = new TreeNode();
    //    // 免去 head == null 的判断
    //    TreeNode tail = hair;
    //    // 中序遍历（迭代）
    //    Deque<TreeNode> stack = new LinkedList<>();
    //    TreeNode curr = pRootOfTree;
    //    while (curr!=null || !stack.isEmpty()) {
    //        while (curr!=null) {
    //            stack.offerLast(curr);
    //            curr = curr.left;
    //        }
    //        curr = stack.pollLast();
    //        tail.right = curr;
    //        curr.left = tail;
    //        tail = tail.right;
    //        curr = curr.right;
    //    }
    //    // 卸磨杀驴
    //    TreeNode head = hair.right;
    //    hair.right = null;
    //    head.left = null;
    //    return head;
    //}

    // 方法2：递归
    // 全局变量
    private TreeNode tail = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree==null) return null;
        TreeNode hair = new TreeNode();
        tail = hair;
        dfs(pRootOfTree);
        TreeNode head = hair.right;
        hair.right = null;
        head.left = null;
        return head;
    }

    private void dfs(TreeNode root) {
        if (root.left==null && root.right==null) {
            tail.right = root;
            root.left = tail;
            // tail 作为局部变量，其修改是不会带到其他函数里的！！
            tail = tail.right;
            return;
        }
        if (root.left!=null) {
            dfs(root.left);
        }
        tail.right = root;
        root.left = tail;
        tail = tail.right;
        if (root.right!=null) {
            dfs(root.right);
        }
    }

}
