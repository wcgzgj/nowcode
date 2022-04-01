package must.ques;

import com.sun.jdi.PrimitiveValue;

import javax.management.loading.PrivateClassLoader;
import java.util.LinkedList;

/**
 * @ClassName AB3_isValid
 * @Description 有效括号序列
 * @Author faro_z
 * @Date 2022/4/1 3:05 下午
 * @Version 1.0
 **/
public class AB3_isValid {
    public boolean isValid (String s) {
        LinkedList<Character> stack = new LinkedList<>();
        char[] token = s.toCharArray();
        if (!isLeftOp(token[0])) return false;
        for (int i = 0; i < token.length; i++) {
            if (isLeftOp(token[i])) stack.addLast(token[i]);
            else {
                if (stack.isEmpty() || !isPair(stack.getLast(),token[i])) {
                    return false;
                } else {
                    stack.removeLast();
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isLeftOp(char c) {
        return c=='(' || c=='[' || c=='{';
    }

    private boolean isPair(char c1,char c2) {
        if (c1=='(') return c2==')';
        if (c1=='[') return c2==']';
        if (c1=='{') return c2=='}';
        return false;
    }


}
