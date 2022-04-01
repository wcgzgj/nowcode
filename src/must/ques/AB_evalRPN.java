package must.ques;

import java.util.Stack;

/**
 * @ClassName AB_evalRPN
 * @Description TODO
 * @Author faro_z
 * @Date 2022/4/1 3:16 下午
 * @Version 1.0
 **/
public class AB_evalRPN {
    public static void main(String[] args) {

    }

    public int evalRPN (String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (!isOp(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(doOp(num1,tokens[i],num2));
            }
        }
        return stack.pop();
    }

    private boolean isOp(String str) {
        if ("+".equals(str) ||
                "-".equals(str) ||
                "*".equals(str) ||
                "/".equals(str)) return true;
        return false;
    }

    private int doOp(int num1,String op,int num2) {
        if ("+".equals(op)) return num1+num2;
        else if ("-".equals(op)) return num1-num2;
        else if ("*".equals(op)) return num1*num2;
        else return num1/num2;
    }
}
