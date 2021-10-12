package test;

import java.util.Scanner;

/**
 * @ClassName FrogJump
 * @Description TODO
 * @Author faro_z
 * @Date 2021/10/12 5:08 下午
 * @Version 1.0
 **/
public class FrogJump {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        System.out.println(getRes(n));
    }

    public static int getRes(int n) {
        if (n<=2) return n;
        int[] dp = new int[n + 1];
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <=n; i++) {
            dp[i]=dp[i-2]+dp[i-1];
        }
        return dp[n];
    }

}
