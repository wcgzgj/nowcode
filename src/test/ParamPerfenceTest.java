package test;

import must.domain.TreeNode;

/**
 * @ClassName ParamPerfenceTest
 * @Description TODO
 * @Author faro_z
 * @Date 2022/7/14 15:22
 * @Version 1.0
 **/
public class ParamPerfenceTest {
    private static TreeNode globalHead = null;
    public static void main(String[] args) {
        TreeNode head = null;
        giveVal(head);
        giveVal(globalHead);
        System.out.println(head);
        System.out.println(globalHead);
        giveGlobalVal();
        System.out.println(globalHead);
    }

    public static void giveVal(TreeNode head) {
        head = new TreeNode(1);
    }
    public static void giveGlobalVal() {
        globalHead = new TreeNode(1);
    }
}
