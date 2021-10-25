package must.ques;

/**
 * @ClassName CC19_minCut
 * @Description TODO
 * @Author faro_z
 * @Date 2021/10/25 3:02 下午
 * @Version 1.0
 **/
public class CC19_minCut {
    public static void main(String[] args) {
        CC19_minCut solu = new CC19_minCut();
        System.out.println(solu.isHui("abcba",0,3));
    }

    public int minCut (String s) {
        return -1;
    }

    // 获取末尾为 e 的最长的回文子串的头部的 index
    public int getMaxHuiStartIndex(String s,int e) {
        for (int i = 0; i <= e; i++) {
            if (isHui(s,i,e)) return i;
        }
        // 最差情况，就是返回 e
        return e;
    }

    public boolean isHui(String str,int l,int r) {
        while (l<r) {
            if (str.charAt(l++)!=str.charAt(r--)) return false;
        }
        return true;
    }
}
