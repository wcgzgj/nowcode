package must.ques;

/**
 * @ClassName leetcode_26
 * @Description TODO
 * @Author faro_z
 * @Date 2021/9/23 1:04 上午
 * @Version 1.0
 **/
// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
public class leetcode_26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length<=1) return nums.length;
        int l=1,r=1;
        while (r<nums.length) {
            if (nums[r]!=nums[r-1]) {
                nums[l]=nums[r];
                l++;
            }
            r++;
        }
        return l;
    }
}
