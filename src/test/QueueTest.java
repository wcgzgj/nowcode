package test;

import must.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName QueueTest
 * @Description TODO
 * @Author faro_z
 * @Date 2022/7/14 17:30
 * @Version 1.0
 **/
public class QueueTest {
    public static void main(String[] args) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(null);
        System.out.println(queue.size());
    }
}
