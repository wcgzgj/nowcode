package must.ques;

/**
 * @ClassName WC133_maxsumofSubarray
 * @Description https://www.nowcoder.com/practice/554aa508dd5d4fefbf0f86e5fe953abd?tpId=202&&tqId=38842&rp=1&ru=/activity/oj&qru=/ta/code-written-high/question-ranking
 * @Author faro_z
 * @Date 2021/9/24 6:03 下午
 * @Version 1.0
 **/
public class WC133_maxsumofSubarray {
    public int maxsumofSubarray (int[] arr) {
        // 状态转换方程 : dp[i]=max(dp[i],dp[i-1]+dp[i]) dp[i]表示的是包含当前位置的情况下，累加可以获得的最大值
        int max=arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i]=Math.max(arr[i],arr[i]+arr[i-1]);
            max=Math.max(max,arr[i]);
        }
        return max;
    }
}
