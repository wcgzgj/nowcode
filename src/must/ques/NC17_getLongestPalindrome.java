package must.ques;

/**
 * @ClassName NC17_getLongestPalindrome
 * @Description 最长回文子串
 * @Author faro_z
 * @Date 2021/11/16 8:24 下午
 * @Version 1.0
 **/
public class NC17_getLongestPalindrome {
    public static void main(String[] args) {
        NC17_getLongestPalindrome solu = new NC17_getLongestPalindrome();
        System.out.println(solu.getLongestPalindrome("baabccc",7));
    }

    // 方法1：遍历，时间复杂度为 O(n^2)
    //public int getLongestPalindrome(String A, int n) {
    //    int maxLen = Integer.MIN_VALUE;
    //    for (int i = 0; i < n; i++) {
    //        // 这里一定要注意奇数长度和偶数长度的回文串都要考虑
    //        maxLen=Math.max(maxLen,getMaxHui(i-1,i+1,A));
    //        maxLen=Math.max(maxLen,getMaxHui(i,i+1,A));
    //    }
    //    return maxLen;
    //}
    //
    //// 获取指定 l r 开始的最长的回文串长度
    //private int getMaxHui(int l,int r,String A) {
    //    while (l>=0 && r<=A.length()-1 && A.charAt(l)==A.charAt(r)) {
    //        l--;
    //        r++;
    //    }
    //    return r-l-1;
    //}

    // 方法2 动态规划
    public int getLongestPalindrome(String A, int n) {
        int[][] dp = new int[n][n];
        int res = Integer.MIN_VALUE;
        for (int l = 0; l < n; l++) {
            for (int r = l; r <n ; r++) {
                if (l==r) dp[l][r]=1;
                else if (A.charAt(l)==A.charAt(r)) {
                    if (r-l==1) dp[l][r]=2;
                    else {
                        if (dp[l+1][r-1]>0) dp[l][r]=dp[l+1][r-1]+2;
                    }
                }
                res=Math.max(res,dp[l][r]);
            }
        }
        outGrid(dp);
        return res;
    }

    private static void outGrid(int[][]dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+"  ");
            }
            System.out.println();
        }
    }

}
