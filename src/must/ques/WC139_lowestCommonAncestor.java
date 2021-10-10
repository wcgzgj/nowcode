package must.ques;

import must.domain.TreeNode;

import java.util.Stack;

/**
 * @ClassName WC139_lowestCommonAncestor
 * @Description TODO
 * @Author faro_z
 * @Date 2021/9/25 2:43 下午
 * @Version 1.0
 **/
public class WC139_lowestCommonAncestor {
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // 记录 o1 o2 对应的路径，要用栈，因为后面我们会从根部进行遍历
        Stack<Integer> o1Path = new Stack<>();
        Stack<Integer> o2Path = new Stack<>();
        getPath(o1,root,o1Path);
        getPath(o2,root,o2Path);
        int father = 0;
        while (!o1Path.isEmpty() && !o2Path.isEmpty()) {
            Integer vo1 = o1Path.pop();
            Integer vo2 = o2Path.pop();
            if (vo1==vo2) father=vo1;
            // 当第一次出现两个路径上不同的点时，说明前一次是最近父节点
            else break;
        }
        return father;
    }

    public boolean getPath(int target,TreeNode root,Stack<Integer>path) {
        if (root==null) return false;
        if (root.val==target || getPath(target,root.left,path) || getPath(target,root.right,path)) {
            path.add(root.val);
            return true;
        }
        return false;
    }
}
