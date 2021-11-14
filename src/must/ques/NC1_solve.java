package must.ques;

/**
 * @ClassName NC1_solve
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/14 5:14 下午
 * @Version 1.0
 **/
public class NC1_solve {
    public static void main(String[] args) {
        //StringBuilder sb = new StringBuilder("123");
        //sb.reverse();
        NC1_solve solu = new NC1_solve();
        System.out.println(solu.solve("99",""));
    }

    public String solve (String s, String t) {
        int len = Math.max(s.length(), t.length());
        if (len==0) return "0";
        StringBuilder ssb = new StringBuilder(s);
        StringBuilder tsb = new StringBuilder(t);
        ssb.reverse();
        tsb.reverse();
        StringBuilder sb = new StringBuilder();
        int cache=0;
        for (int i = 0; i < len; i++) {
            int tmp = getNum(ssb, i) + getNum(tsb, i) + cache;
            cache=tmp/10;
            sb.append(tmp%10);
        }
        if (cache>0) sb.append(cache);
        return sb.reverse().toString();
    }

    private static int getNum(StringBuilder str,int index) {
        if (index>=str.length()) return 0;
        return str.charAt(index)-'0';
    }
}
