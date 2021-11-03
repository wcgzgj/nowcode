package must.ques;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName CC23_longestConsecutive
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/2 4:13 下午
 * @Version 1.0
 **/
public class CC23_longestConsecutive {
    public static void main(String[] args) {

    }

    public int longestConsecutive (int[] num) {
        Set<Integer> set = new HashSet<>();
        for (int n : num) {
            set.add(n);
        }
        int res = Integer.MIN_VALUE;
        for (Integer n : set) {
            // 保证该元素之前的元素没有进行过判断
            // 避免重复劳动
            int count = 1;
            if (!set.contains(n-1)) {
                while (set.contains(++n)) count++;
            }
            res = Math.max(res,count);
        }
        return res;
    }
}
