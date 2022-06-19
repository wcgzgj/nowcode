package test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName DequeTest
 * @Description TODO
 * @Author faro_z
 * @Date 2022/6/6 15:20
 * @Version 1.0
 **/
public class DequeTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Deque<Integer> dq = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        while (!dq.isEmpty()) {
            System.out.println(dq.pollLast());
        }
    }
}
