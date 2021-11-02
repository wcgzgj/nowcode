package test;

import must.domain.TreeNode;
import must.util.TreeFactory;

/**
 * @ClassName TreeFactoryTest
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/2 3:28 下午
 * @Version 1.0
 **/
public class TreeFactoryTest {
    public static void main(String[] args) {
        TreeFactory factory = new TreeFactory("1#2345#67");
        TreeNode root = factory.getTree();
        factory.bfs();
    }
}
