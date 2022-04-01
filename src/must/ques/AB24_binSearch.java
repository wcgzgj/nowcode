package must.ques;

/**
 * @ClassName AB24_binSearch
 * @Description TODO
 * @Author faro_z
 * @Date 2022/4/1 1:40 下午
 * @Version 1.0
 **/
public class AB24_binSearch {
    public static void main(String[] args) {
        AB24_binSearch solu = new AB24_binSearch();
        System.out.println(solu.search(new int[]{-1,1},-1));
    }

    /**
     * 二分查找，没找到返回-1
     * @param nums
     * @param target
     * @return target 在数组中的下标
     */
    public int search (int[] nums, int target) {
        if (nums==null || nums.length==0) return -1;
        int l = 0;
        int r = nums.length - 1;
        while (l<=r) {
            int mid = (l + r) / 2;
            if (nums[mid]==target) return mid;
            if (nums[mid]<target) l=mid+1;
            else r=mid-1;
        }
        return -1;
    }
}
