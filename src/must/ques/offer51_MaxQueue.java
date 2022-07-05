package must.ques;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName offer51_MaxQueue
 * @Description https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof/
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value需要返回 -1
 *
 * 用两个队列，一个是一般队列，存储所有值，一个是双端队列，提供最大值的操作
 * @Author faro_z
 * @Date 2022/7/5 15:42
 * @Version 1.0
 **/
public class offer51_MaxQueue {

    public static void main(String[] args) {

    }

    class MaxQueue {

        private Deque<Integer> deque = new LinkedList<>();
        private Queue<Integer> queue = new LinkedList<>();

        public MaxQueue() {

        }

        public int max_value() {
            if (deque.isEmpty()) return -1;
            return deque.peekFirst();
        }

        public void push_back(int value) {
            queue.offer(value);
            while (!deque.isEmpty() && deque.peekLast()<value) {
                deque.pollLast();
            }
            deque.offerLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) return -1;
            int poll = queue.poll();
            if (poll==deque.peekFirst()) {
                deque.pollFirst();
            }
            return poll;
        }

    }

}
