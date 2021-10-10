package must.ques;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @ClassName WC2_evalRPN
 * @Description TODO
 * @Author faro_z
 * @Date 2021/10/10 2:17 下午
 * @Version 1.0
 **/
public class WC2_evalRPN {

    public static void main(String[] args) {
        WC2_evalRPN solu = new WC2_evalRPN();
        String[] arr = {"40", "130", "50", "/", "+"};
        //String[] arr = {"40"};
        System.out.println(solu.evalRPN(arr));
    }

    public int evalRPN (String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = tokens.length-1; i >=0; i--) {
            String token = tokens[i];
            doStackPush(token,stack);
        }
        return Integer.parseInt(stack.pop());
    }

    public void doStackPush(String token,Stack<String>stack) {
        if (stack.size()==0) {
            stack.push(token);
            return;
        }
        // token 是运算符
        if (!isNum(token)) {
            stack.push(token);

        } else { // token 是数字
            if (!isNum(stack.peek())) {
                stack.push(token);
            } else {
                String num1 = token;
                String num2 = stack.pop();
                String op = stack.pop();
                String val = String.valueOf(calaulate(num1, op, num2));
                if (stack.size()>0 && isNum(stack.peek())) {
                    doStackPush(val,stack);
                } else {
                    stack.push(val);
                }
            }
        }
    }

    public boolean isNum(String str) {
        if (!str.equals("+") && !str.equals("-") && !str.equals("*") && !str.equals("/")) return true;
        return false;
    }

    public int calaulate(String num1,String op,String num2) {
        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);
        switch (op) {
            case "+": return n1+n2;
            case "-": return n1-n2;
            case "*": return n1*n2;
            case "/": return n1/n2;
        }
        return -1;
    }
}
