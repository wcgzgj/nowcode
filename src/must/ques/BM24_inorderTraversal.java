package must.ques;

import must.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName BM24_inorderTraversal
 * @Description TODO
 * @Author faro_z
 * @Date 2022/5/29 6:49 下午
 * @Version 1.0
 **/
public class BM24_inorderTraversal {

    public static void main(String[] args) {

    }

    // 方法1：使用递归
    //public int[] inorderTraversal (TreeNode root) {
    //    List<Integer> track = new ArrayList<>();
    //    dfs(root,track);
    //    int[] res = new int[track.size()];
    //    for (int i = 0; i < track.size(); i++) {
    //        res[i] = track.get(i);
    //    }
    //    return res;
    //}
    //
    //private void dfs(TreeNode root, List<Integer>track) {
    //    if (root==null) return;
    //    if (root.left!=null) track.add(root.left.val);
    //    track.add(root.val);
    //    if (root.right!=null) track.add(root.right.val);
    //}

    public int[] inorderTraversal (TreeNode root) {
        //添加遍历结果的数组
        List<Integer> list = new ArrayList();
        Stack<TreeNode> s = new Stack<>();
        //空树返回空数组
        if(root == null)
            return new int[0];
        //当树节点不为空或栈中有节点时
        while(root != null || !s.isEmpty()){
            //每次找到最左节点
            while(root != null){
                s.push(root);
                root = root.left;
            }
            //访问该节点
            TreeNode node = s.pop();
            list.add(node.val);
            //进入右节点
            root = node.right;
        }
        //返回的结果
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }
}
