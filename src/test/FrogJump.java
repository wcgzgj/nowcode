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

        // 因为每次只是固定使用前两个变量，所以，我们可以不使用数组
        // 是、而是开两个参数，存储前两个变量，从而缩减空间消耗
        for (int i = 3; i <=n; i++) {
            dp[i]=dp[i-2]+dp[i-1];
        }
        return dp[n];
    }

}
