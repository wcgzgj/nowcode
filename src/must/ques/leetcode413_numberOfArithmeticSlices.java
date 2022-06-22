package must.ques;

/**
 * @ClassName leetcode413_numberOfArithmeticSlices
 * @Description TODO
 * @Author faro_z
 * @Date 2022/6/22 16:05
 * @Version 1.0
 **/
public class leetcode413_numberOfArithmeticSlices {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        leetcode413_numberOfArithmeticSlices solu = new leetcode413_numberOfArithmeticSlices();
        System.out.println(solu.numberOfArithmeticSlices(arr));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums==null || nums.length<3) return 0;
        int[] dp = new int[nums.length];
        for (int i = 2; i <nums.length ; i++) {
            if (nums[i]-nums[i-1]==nums[i-1]-nums[i-2]) dp[i]=dp[i-1]+1;
        }
        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
            sum+=dp[i];
        }
        return sum;
    }
}
