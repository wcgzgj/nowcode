package test;

import must.util.RandomData;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * @ClassName MaxQueueTest
 * @Description TODO
 * @Author faro_z
 * @Date 2022/7/17 16:19
 * @Version 1.0
 **/
public class MaxQueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        int[] randomArray = RandomData.getRandomArray(10, 100);
        for (int elem : randomArray) {
            queue.offer(elem);
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
