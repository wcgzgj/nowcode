package must.ques;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName NC61_two_sum
 * @Description 要注意，输出的是下标
 * 这个方法，遍历数组时间复杂度是 O(N)，每次遍历还要访问 HashMap，复杂度是 O(logn)
 * 总的时间复杂度是 O(nlogn) 符合要求
 * @Author faro_z
 * @Date 2021/9/19 2:59 下午
 * @Version 1.0
 **/
public class NC61_two_sum {
    public int[] twoSum (int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            // 如果发现了匹配的两个数，直接返回
            if (map.get(target-numbers[i])!=null) {
                return new int[]{map.get(target-numbers[i]),i+1};
            }
            map.put(numbers[i],i+1);
        }
        return new int[2];
    }
}
