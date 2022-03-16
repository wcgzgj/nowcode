package must.ques;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName NC122_changeNum
 * @Description TODO
 * @Author faro_z
 * @Date 2022/3/16 8:24 下午
 * @Version 1.0
 **/
public class NC122_changeNum {
    public static void main(String[] args) {
        NC122_changeNum solu = new NC122_changeNum();
        System.out.println(solu.solve(100,16));
    }

    public String solve (int M, int N) {
        // 记录符号位
        int op = M;
        M = Math.abs(M);
        StringBuilder builder = new StringBuilder();
        while (M>=1) {
            builder.insert(0,numToAlpha(M%N));
            M = M/N;
        }
        if (op<0) {
            builder.insert(0,"-");
        }
        return builder.toString();
    }

    public String numToAlpha(int num) {
        if (num<10) return String.valueOf(num);
        char res = (char) (num + 55);
        return String.valueOf(res);
    }
}
