package must.ques;

/**
 * @ClassName BM19_findPeakElement
 * @Description TODO
 * @Author faro_z
 * @Date 2022/6/4 14:36
 * @Version 1.0
 **/
public class BM19_findPeakElement {
    public static void main(String[] args) {

    }

    // 方法一：暴力解法 O(n)
    //public int findPeakElement (int[] nums) {
    //    if (nums.length==1 || nums[0]>nums[1]) return 0;
    //    if (nums[nums.length-1]>nums[nums.length-2]) return nums.length-1;
    //    for (int i = 1; i < nums.length-1; i++) {
    //        if (nums[i]>nums[i-1] && nums[i]>nums[i+1]) return i;
    //    }
    //    return nums[nums.length-1];
    //}

    // 方法二：二分查找
    public int findPeakElement (int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while (l<r) {
            mid = (l + r) / 2;
            // 1、mid 处于某个峰的下坡，说peak可能在mid左边，也可能就是 mid，r边界需要向中间收
            if (nums[mid]>nums[mid+1]) {
                r = mid;
            }
            // 2、mid 处于某个峰的上坡，说明 peak 在 mid 的右边，
            // 这里之所以 mid 不可能是 peak，是因为 mid 是与 mid+1 比较的，是 peak 的话也只有 mid+1有机会成为 peak
            else {
                l = mid+1;
            }
        }
        return r;
    }

}
