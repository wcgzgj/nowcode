package must.ques;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName NC180_plusOne
 * @Description TODO
 * @Author faro_z
 * @Date 2022/1/15 3:40 下午
 * @Version 1.0
 **/
public class NC180_plusOne {
    public static void main(String[] args) {
        NC180_plusOne solu = new NC180_plusOne();
        System.out.println(Arrays.toString(solu.plusOne(new int[]{9,9,9})));
    }

    public int[] plusOne (int[] nums) {
        int cache = 0;
        for (int i = nums.length-1; i >=0 ; i--) {
            if (i==nums.length-1) {
                nums[i]+=1;
            }
            nums[i]+=cache;
            cache=nums[i]/10;
            nums[i]=nums[i]%10;
        }
        if (cache!=0) {
            nums = copyAndAddOnePos(nums);
        }
        return nums;
    }

    public int[] copyAndAddOnePos(int[]arr) {
        int[] res = new int[arr.length + 1];
        for (int i = arr.length-1; i >=0 ; i--) {
            res[i+1]=arr[i];
        }
        res[0]=1;
        return res;
    }
}
