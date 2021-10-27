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
        System.out.println(solu.minCut("abbab"));
    }

    public int minCut (String s) {
        int[] dp = new int[s.length()];
        for (int i = 0; i < dp.length; i++) {
            // 获得
            int startIndex = getMinDPStartIndex(s, i,dp);
            // 从头部到e 就是一个回文串，说明直到 e 都不需要进行分割
            if (startIndex==0) dp[i]=0;
            // 状态转移方程
            else dp[i]=dp[startIndex-1]+1;
        }
        return dp[dp.length-1];
    }

    // 在所有 s-e 可能形成回文的情况中，选出 dp[s-1] 最小的那一个
    public int getMinDPStartIndex(String s,int e,int[] dp) {
        int res = 0;
        int minDP = Integer.MAX_VALUE;
        for (int i = 0; i <= e; i++) {
            if (isHui(s,i,e)) {
                // 如果和第一个元素就能形成回文串，那么都不用考虑了，这种情况就是最优的
                // ，因为连拆都不用拆
                if (i==0) return 0;
                if (dp[i-1]<minDP) {
                    minDP=dp[i-1];
                    res = i;
                }
            }
        }
        // 最差情况，就是返回 e
        return res;
    }

    public boolean isHui(String str,int l,int r) {
        while (l<r) {
            if (str.charAt(l++)!=str.charAt(r--)) return false;
        }
        return true;
    }
}
