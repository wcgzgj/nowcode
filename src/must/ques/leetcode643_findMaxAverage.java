package must.ques;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName leetcode643_findMaxAverage
 * @Description TODO
 * @Author faro_z
 * @Date 2022/7/6 17:01
 * @Version 1.0
 **/
public class leetcode643_findMaxAverage {
    public static void main(String[] args) {
        leetcode643_findMaxAverage solu = new leetcode643_findMaxAverage();
        System.out.println(solu.findMaxAverage(new int[]{-1},1));
    }

    public double findMaxAverage(int[] nums, int k) {
        if (nums==null || nums.length==0 || nums.length<k) return 0;
        double sum = 0d;
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < k; i++) {
            sum+=nums[i];
        }
        max = Math.max(sum/k,max);
        int r = k;
        while (r<nums.length) {
            sum+=nums[r];
            sum-=nums[r-k];
            max = Math.max(sum/k,max);
            ++r;
        }
        return max;
    }


    //public double findMaxAverage(int[] nums, int k) {
    //    if (nums==null || nums.length==0 || nums.length<k) return 0;
    //
    //}
}
