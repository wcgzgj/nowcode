package must.ques;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName vijos_4_2_maxUpSequence
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/10 7:41 下午
 * @Version 1.0
 **/
public class vijos_4_2_maxUpSequence {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        System.out.println(getMaxUpSeq(list));
    }

    public static int getMaxUpSeq(List<Integer>list) {
        // 状态转移方程：dp[i]=max(dp[k])+1 dp[k] 表示 0~i-1 中所有 list[k]<list[i] 的情况
        if (list.size()==0) return 0;
        int res = Integer.MIN_VALUE;
        int[] dp = new int[list.size()];
        dp[0]=1;
        for (int i = 1; i < list.size(); i++) {
            int currMax=0;
            for (int j = 0; j < i; j++) {
                // 找到 dp[k]
                if (list.get(j)<list.get(i)) currMax=Math.max(currMax,dp[j]);
            }
            dp[i]=currMax+1;
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
