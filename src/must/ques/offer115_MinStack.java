package must.ques;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName offer115_MinStack
 * @Description https://leetcode.cn/problems/min-stack/
 * 小进队，取尾部
 * @Author faro_z
 * @Date 2022/7/5 15:57
 * @Version 1.0
 **/
public class offer115_MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        System.out.println("添加完后的deque是:"+minStack.deque);
        minStack.pop();
        System.out.println(minStack.deque);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.deque);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.deque);
        System.out.println(minStack.getMin());
    }

    static class MinStack {
        private Deque<Integer> deque = new LinkedList<>();
        MyStack<Integer> stack = new MyStack<>();

        public MinStack() {

        }

        public void push(int val) {
            stack.push(val);
            if (deque.isEmpty() || deque.peekLast()>=val) {
                deque.offerLast(val);
            }
        }

        public void pop() {
            if (stack.pop().intValue()==deque.peekLast().intValue()) {
                deque.pollLast();
            }
        }

        public int top() {
            return stack.top();
        }

        public int getMin() {
            return deque.peekLast();
        }
    }

    static class MyStack<T> {

        LinkedList<T> list = new LinkedList<T>();

        public void push(T val) {
            list.offerLast(val);
        }

        public T pop() {
            return list.pollLast();
        }

        public T top() {
            return list.peekLast();
        }
    }
}
