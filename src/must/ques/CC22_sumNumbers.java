package must.ques;

import must.domain.TreeNode;
import must.util.MyTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CC22_sumNumbers
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/2 2:52 下午
 * @Version 1.0
 **/
public class CC22_sumNumbers {
    public static void main(String[] args) {
        //TreeNode root = MyTree.getRoot();
        TreeNode root = new TreeNode(1);
        root.right=new TreeNode(5);

        CC22_sumNumbers solu = new CC22_sumNumbers();
        solu.sumNumbers(root);
    }

    public int sumNumbers (TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root,new StringBuilder(),res);
        System.out.println(res);
        int sum = 0;
        for (String re : res) {
            sum+=Integer.parseInt(re);
        }
        return sum;
    }

    public void dfs(TreeNode root, StringBuilder track, List<String> res) {
        if (root==null) return;
        if (root.left==null && root.right==null) {
            track.append(root.val);
            res.add(track.toString());
            removeLast(track);
            return;
        }
        track.append(root.val);
        if (root.left!=null) dfs(root.left,track,res);
        if (root.right!=null) dfs(root.right,track,res);
        // 回溯
        removeLast(track);
    }

    // 将 StringBuilder 的最后一个元素移除，方便后面的回溯操作
    private static void removeLast(StringBuilder sb) {
        sb.replace(sb.length()-1,sb.length(),"");
    }

}
