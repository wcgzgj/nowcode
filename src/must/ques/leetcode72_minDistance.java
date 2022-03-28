package must.ques;

/**
 * @ClassName leetcode72_minDistance
 * @Description TODO
 * @Author faro_z
 * @Date 2022/3/28 12:52 下午
 * @Version 1.0
 **/
public class leetcode72_minDistance {
    public static void main(String[] args) {
        String word1 = "zoologicoarchaeologist";
        String word2 = "zoogeologist";
        leetcode72_minDistance solu = new leetcode72_minDistance();
        System.out.println(solu.minDistance(word1,word2));
    }

    /**
     * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
     *
     * 你可以对一个单词进行如下三种操作：
     *
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int R = word1.length() + 1;
        int C = word2.length() + 1;
        int[][] dp = new int[R][C];
        // dp 数组初始化
        // 含义是空字符串变成对应字符串要进行的操作
        for (int i = 0; i < C; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < R; i++) {
            dp[i][0]=i;
        }
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
                min = Math.min(min,dp[i-1][j-1]);
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = min+1;
                }
            }
        }
        return dp[R-1][C-1];
    }
}
