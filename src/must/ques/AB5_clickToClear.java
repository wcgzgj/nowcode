package must.ques;

import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName AB5_clickToClear
 * @Description TODO
 * @Author faro_z
 * @Date 2022/4/1 3:30 下午
 * @Version 1.0
 **/
public class AB5_clickToClear {
    private static Scanner sc =  new Scanner(System.in);
    public static void main(String[] args) {
        String str = sc.next();
        System.out.println(doClickClear(str));
    }

    /**
     * 进行点击消除操作
     * @param str
     * @return
     */
    public static String doClickClear(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (stack.isEmpty() || stack.peek()!=str.charAt(i)) {
                stack.push(str.charAt(i));
            } else {
                stack.pop();
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) builder.append(stack.pop());
        builder.reverse();
        if (builder.length()==0) return "0";
        else return builder.toString();
    }
}
