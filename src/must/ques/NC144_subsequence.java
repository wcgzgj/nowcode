package must.ques;

/**
 * @ClassName NC144_subsequence
 * @Description TODO
 * @Author faro_z
 * @Date 2021/12/1 3:22 下午
 * @Version 1.0
 **/
public class NC144_subsequence {
    public static void main(String[] args) {
        NC144_subsequence solu = new NC144_subsequence();
        System.out.println(solu.subsequence(6,new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647}));
    }

    public long subsequence (int n, int[] array) {
        if (array.length==1) return new Long(Math.max(0,array[0]));
        if (array.length==2) return new Long(Math.max(0,Math.max(array[0],array[1])));
        long[] dp = new long[n];
        dp[0]=array[0];
        dp[1]=array[1];
        long res = Math.max(0,Math.max(dp[0], dp[1]));
        for (int i = 2; i <n ; i++) {
            long tmp = Long.MIN_VALUE;
            for (int j = 0; j <=i-2 ; j++) {
                tmp = Math.max(tmp,dp[j]);
            }
            dp[i]=tmp+array[i];
            res = Math.max(res,dp[i]);
        }
        return new Long(Math.max(0,res));
    }
}
