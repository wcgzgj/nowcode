package must.ques;


import java.util.Stack;

/**
 * @ClassName AB2_IsPopOrder
 * @Description TODO
 * @Author faro_z
 * @Date 2022/4/1 2:26 下午
 * @Version 1.0
 **/
public class AB2_IsPopOrder {
    public static void main(String[] args) {

    }

    /**
     * 栈模拟法
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length==0 && popA.length==0) return true;
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int k = 0; k < pushA.length; k++) {
            stack.push(pushA[k]);
            while (!stack.isEmpty() && stack.peek()==popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

}
