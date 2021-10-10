package must.ques;

/**
 * @ClassName NC68_Jump_Floor
 * @Description 跳台阶
 * @Author faro_z
 * @Date 2021/9/21 2:40 下午
 * @Version 1.0
 **/
public class NC68_Jump_Floor {
    public int jumpFloor(int target) {
        // dp[n] = dp[n-2] + dp[n-1]

        // 当台阶数小于等于2,个数刚好等于台阶数
        if (target<=2) return target;
        int pre = 1; // 只有一级台阶的情况
        int curr = 2; // 只有二级台阶的情况
        for (int i = 3; i <= target; i++) {
            int tmp = pre + curr;
            pre=curr;
            curr=tmp;
        }
        return curr;
    }
}
