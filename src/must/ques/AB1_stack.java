package must.ques;

import javax.management.loading.PrivateClassLoader;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName AB1_stack
 * @Description
 * push x：将 加x\x 入栈，保证 x\x 为 int 型整数。
 * pop：输出栈顶，并让栈顶出栈
 * top：输出栈顶，栈顶不出栈
 *
 * 如果操作为push，则不输出任何东西。
 * 如果为另外两种，若栈为空，则输出 "error“
 * 否则按对应操作输出。
 *
 * 输入：
 * 6
 * push 1
 * pop
 * top
 * push 2
 * push 3
 * pop
 *
 * 输出：
 * 1
 * error
 * 3
 **/
public class AB1_stack {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Stack stack = new Stack();
        List<String> res = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            if (line.startsWith("push")) {
                stack.push(Integer.parseInt(line.split(" ")[1]));
            } else if ("pop".equals(line)) {
                res.add(stack.pop());
            } else {
                res.add(stack.top());
            }
        }
        for (String elem : res) {
            System.out.println(elem);
        }
    }
}

class Stack {
    // 存储数组
    private int[] innerArr = new int[10];
    // 栈顶
    private int top = -1;

    /**
     * 检查剩余空间是否满足要求
     */
    private boolean checkSize() {
        if (top>=innerArr.length-1) return false;
        return true;
    }

    /**
     * 为 innerArr 重新分配空间
     */
    private void resize() {
        int newSize = innerArr.length * 2;
        int[] newInnerArr = new int[newSize];
        for (int i = 0; i < innerArr.length; i++) {
            newInnerArr[i]=innerArr[i];
        }
        innerArr = newInnerArr;
    }

    /**
     * 栈输入
     * @param num
     */
    public void push(int num) {
        if (!checkSize()) resize();
        innerArr[++top]=num;
    }

    /**
     * 输出栈顶，不出栈
     * @return
     */
    public String top() {
        if (top==-1) return "error";
        return String.valueOf(innerArr[top]);
    }

    /**
     * 出栈
     * @return
     */
    public String pop() {
        if (top==-1) return "error";
        return String.valueOf(innerArr[top--]);
    }

}
