package must.ques;

/**
 * @ClassName NC35_midEditCost
 * @Description TODO
 * @Author faro_z
 * @Date 2022/3/27 9:18 下午
 * @Version 1.0
 **/
public class NC35_midEditCost {
    public static void main(String[] args) {

    }

    /**
     * 给定两个字符串str1和str2，再给定三个整数ic，dc和rc，
     * 分别代表插入、删除和替换一个字符的代价，请输出将str1编辑成str2的最小代价。
     * @param str1
     * @param str2
     * @param ic 插入代价
     * @param dc 删除代价
     * @param rc 替换代价
     * @return
     */
    public int minEditCost (String str1, String str2, int ic, int dc, int rc) {
        int R = str1.length() + 1;
        int C = str2.length() + 1;
        int[][] dp = new int[R][C];
        dp[0][0] = 0;
        for (int i = 1; i < C; i++) {
            dp[0][i] = dp[0][i - 1] + ic;
        }
        for (int i = 1; i < R; i++) {
            dp[i][0] = dp[i - 1][0] + dc;
        }
        for (int i = 1; i <R ; i++) {
            for (int j = 1; j < C; j++) {
                int del = dp[i - 1][j] + dc;
                int ins = dp[i][j - 1] + ic;
                int cha = dp[i - 1][j - 1] +rc;
                int min = Math.min(Math.min(del, ins), cha);
                if (str1.charAt(i-1)==str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = min;
                }
            }
        }
        return dp[R-1][C-1];
    }
}
