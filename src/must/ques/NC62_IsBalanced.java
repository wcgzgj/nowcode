package must.ques;

import must.domain.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName NC62_IsBalanced
 * @Description TODO
 * @Author faro_z
 * @Date 2022/3/16 2:50 下午
 * @Version 1.0
 **/
public class NC62_IsBalanced {
    private Map<TreeNode, Integer> map = new HashMap<>();
    private boolean isBalanced = true;
    public static void main(String[] args) {

    }

    // 方案1：计算每个节点左右枝最大高度差，判断差值是否大于1
    // 同时可以使用 HashMap 存储已经计算完成的高度，避免重复计算造成时间浪费
    // 使时间复杂度控制在 O(n) 中
    //public boolean IsBalanced_Solution(TreeNode root) {
    //    if (root==null) return true;
    //    if (Math.abs(getDepth(root.left)-getDepth(root.right))>1) return false;
    //    return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    //}
    //
    //private int getDepth(TreeNode root) {
    //    if (root==null) return 0;
    //    if (map.containsKey(root)) return map.get(root);
    //    int l = getDepth(root.left)+1;
    //    int r = getDepth(root.right)+1;
    //    map.put(root,Math.max(l,r));
    //    return map.get(root);
    //}

    // 方案2：设置额外变量，记录是否超出
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root==null) return true;
        getDepth(root);
        return isBalanced;
    }

    private int getDepth(TreeNode root) {
        if (root==null) return 0;
        if (map.containsKey(root)) return map.get(root);
        // +1 是因为要把自己的深度加上
        // 前面 root==null 返回 0 时，就默认每层的深度都是要当层加上的
        int l = getDepth(root.left);
        int r = getDepth(root.right);
        // 左右枝已经出现不满足条件的情况
        if (l==-1 || r==-1 || Math.abs(l-r)>1) {
            isBalanced=false;
            return -1;
        }
        // 没有问题的情况
        map.put(root,Math.max(l,r)+1);
        return map.get(root);
    }
}
