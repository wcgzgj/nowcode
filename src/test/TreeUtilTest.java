package test;

import must.domain.TreeNode;
import must.util.TreeUtil;

/**
 * @ClassName TreeUtilTest
 * @Description TODO
 * @Author faro_z
 * @Date 2022/6/6 14:08
 * @Version 1.0
 **/
public class TreeUtilTest {
    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTreeBySeq("1,2,3,4,#,5,#,#,6,#,#,7");
        TreeUtil.bfsPrint(root);
    }
}
