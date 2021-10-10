package must.ques;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName NC41_Max_Length
 * @Description TODO
 * @Author faro_z
 * @Date 2021/9/21 2:49 下午
 * @Version 1.0
 **/
public class NC41_Max_Length {
    public int maxLength (int[] arr) {
        Set<Integer> set = new HashSet<>();
        int l=0,r=0,max=Integer.MIN_VALUE;
        while (r<arr.length) {
            if (set.contains(arr[r])) {
                // 左边会一直缩窄，直到去除了和最右边一样的元素位置
                set.remove(arr[l++]);
            } else {
                set.add(arr[r++]);
                max=Math.max(max,set.size());
            }
        }
        return max;
    }
}
