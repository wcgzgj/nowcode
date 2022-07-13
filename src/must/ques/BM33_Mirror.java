package must.ques;

import must.domain.TreeNode;

/**
 * @ClassName BM33_Mirror
 * @Description TODO
 * @Author faro_z
 * @Date 2022/7/13 23:29
 * @Version 1.0
 **/
public class BM33_Mirror {
    public static void main(String[] args) {

    }

    public TreeNode Mirror (TreeNode pRoot) {
        if (pRoot==null) return null;
        TreeNode left = Mirror(pRoot.left);
        TreeNode right = Mirror(pRoot.right);
        pRoot.left = right;
        pRoot.right = left;
        return pRoot;
    }

}

