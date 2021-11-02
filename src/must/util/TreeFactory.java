package must.util;

import must.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName TreeFactory
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/2 3:16 下午
 * @Version 1.0
 **/
public class TreeFactory {
    // 建树序列
    private String treeSeq;

    // 根节点
    private TreeNode root;

    public TreeFactory(String treeSeq) {
        this.treeSeq = treeSeq;
    }

    private void buildTree() {
        char[] token = treeSeq.toCharArray();
        if (token.length==0) return;
        if (token[0]=='#') return;
        root=new TreeNode(token[0]-'0');
        if (token.length==1) return;
        root.left=bfs(token,1);
        root.right=bfs(token,2);
    }

    private TreeNode bfs(char[] token,int index) {
        if (index>=token.length) return null;
        if (token[index]=='#') return null;
        TreeNode root = new TreeNode(token[index] - '0');
        int l = index * 2 + 1;
        int r = l + 1;
        root.left=bfs(token,l);
        root.right=bfs(token,r);
        return root;
    }

    // 根据序列，创建树
    public TreeNode getTree() {
        buildTree();
        return root;
    }

    // 广度遍历树的结构
    public void bfs() {
        if (root==null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                System.out.print(tmp.val+"  ");
                if (tmp.left!=null) queue.offer(tmp.left);
                if (tmp.right!=null) queue.offer(tmp.right);
            }
            System.out.println();
        }
    }
}
