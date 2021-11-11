package must.ques;

import java.util.Stack;

/**
 * @ClassName NC76_stackToQueue
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/11 10:40 上午
 * @Version 1.0
 **/
public class NC76_stackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.isEmpty()) return stack2.pop();
        while (!stack1.isEmpty()) stack2.push(stack1.pop());
        return stack2.pop();
    }
}
