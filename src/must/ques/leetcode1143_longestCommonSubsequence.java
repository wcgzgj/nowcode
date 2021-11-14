package must.ques;

/**
 * @ClassName leetcode1143_longestCommonSubsequence
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/14 5:58 下午
 * @Version 1.0
 **/
public class leetcode1143_longestCommonSubsequence {
    public static void main(String[] args) {
        leetcode1143_longestCommonSubsequence solu = new leetcode1143_longestCommonSubsequence();
        System.out.println(solu.longestCommonSubsequence("abcde","ace"));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int R = text1.length();
        int C = text2.length();
        int[][] dp = new int[R+1][C+1];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (text1.charAt(i)==text2.charAt(j)) dp[i+1][j+1]=dp[i][j]+1;
                else dp[i+1][j+1]=Math.max(dp[i+1][j],dp[i][j+1]);
                res=Math.max(res,dp[i+1][j+1]);
            }
        }
        outMap(dp);
        return res;
    }

    public static void outMap(int[][]dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
