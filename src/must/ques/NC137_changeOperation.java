package must.ques;

import sun.font.DelegatingShape;

import java.util.LinkedList;

/**
 * @ClassName NC137_changeOperation
 * @Description TODO
 * @Author faro_z
 * @Date 2022/3/16 8:38 下午
 * @Version 1.0
 **/
public class NC137_changeOperation {
    public static void main(String[] args) {

    }

    public int solve (String s) {
        char[] token = s.toCharArray();
        return -1;
    }

    private String calculateFromLeftBracket(int index,char[] token) {
        LinkedList<String> stack = new LinkedList<>();
        while (token[index]!=')' || index<token.length) {

        }
        return null;
    }

    // 进行计算
    private String doOp(String num1Str,String op,String num2Str) {
        Integer num1 = Integer.valueOf(num1Str);
        Integer num2 = Integer.valueOf(num2Str);
        if (op.equals("+")) return String.valueOf(num1+num2);
        else if (op.equals("-")) return String.valueOf(num1-num2);
        else return String.valueOf(num1*num2);
    }
}
