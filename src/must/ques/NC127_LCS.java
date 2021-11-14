package must.ques;

/**
 * @ClassName NC127_LCS
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/14 6:21 下午
 * @Version 1.0
 **/
public class NC127_LCS {
    public static void main(String[] args) {
        NC127_LCS solu = new NC127_LCS();
        System.out.println(solu.LCS("1AB2345CD","12345EF"));
    }

    public String LCS (String str1, String str2) {
        int R = str1.length();
        int C = str2.length();
        int[][] dp = new int[R + 1][C + 1];
        int maxValue = Integer.MIN_VALUE;
        int maxValueRow = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (str1.charAt(i)==str2.charAt(j)) dp[i+1][j+1]=dp[i][j]+1;
                if (maxValue<dp[i+1][j+1]) {
                    maxValue=dp[i+1][j+1];
                    maxValueRow=i+1;
                }
            }
        }
        int start = maxValueRow - maxValue;
        return str1.substring(start,maxValueRow);
    }
}
