package must.ques;

import must.domain.TreeNode;

/**
 * @ClassName NC12_reConstructBinaryTree
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/20 1:36 下午
 * @Version 1.0
 **/
public class NC12_reConstructBinaryTree {
    public static void main(String[] args) {

    }

    /**
     * 输入：
     * [1,2,4,7,3,5,6,8],[4,7,2,1,5,3,8,6]
     *
     * 返回值：
     * {1,2,3,4,#,5,6,#,7,#,#,8}
     *
     * 说明：
     * 返回根节点，系统会输出整颗二叉树对比结果，重建结果如题面图示
     */
    public TreeNode reConstructBinaryTree(int [] pre, int [] vin) {
        if (pre==null || pre.length==0) return null;
        return buildTree(pre,vin,0,pre.length-1,0,vin.length-1);
    }

    public TreeNode buildTree(int[] pre,int[] vin,int preStart,int preEnd,int vinStart,int vinEnd) {
        if (preStart==preEnd) return new TreeNode(pre[preStart]);
        if (preStart>preEnd) return null;
        TreeNode root = new TreeNode(pre[preStart]);
        int vinRootIndex=0;
        for (int i = 0; i < vin.length; i++) {
            if (pre[preStart]==vin[i]) {
                vinRootIndex=i;
                break;
            }
        }
        int lLen=vinRootIndex-vinStart;
        int rLen=vinEnd-vinRootIndex;
        root.left=buildTree(pre,vin,preStart+1,preStart+lLen,vinRootIndex-lLen,vinRootIndex-1);
        root.right=buildTree(pre,vin,preStart+lLen+1,preStart+lLen+rLen,vinRootIndex+1,vinRootIndex+rLen);
        return root;
    }
}
