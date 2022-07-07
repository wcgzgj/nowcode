package must.ques;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName BM52_FindNumsAppearOnce
 * @Description TODO
 * @Author faro_z
 * @Date 2022/7/7 14:21
 * @Version 1.0
 **/
public class BM52_FindNumsAppearOnce {
    public static void main(String[] args) {

    }


    // 方法1：使用 Set
    //public int[] FindNumsAppearOnce (int[] array) {
    //    Set<Integer> set = new HashSet<>();
    //    for (int elem : array) {
    //        if (set.contains(elem)) set.remove(elem);
    //        else set.add(elem);
    //    }
    //    int[] res = new int[2];
    //    int index = 0;
    //    for (Integer elem : set) {
    //        res[index++]=elem;
    //    }
    //    return res;
    //}

    // 方法2：位运算
    /*
        4 ^ 6 = 0100 ^ 0110 = 0010
        也就是说，两个不同的数，异或的结果，为1的是二者不同的位置，为0的是二者相同的位置
        那么，要区分4、6，只要找到他们的不同位置即可
     */
    public int[] FindNumsAppearOnce (int[] array) {
        int tmp = 0;
        // 流程结束后，留下的是数组中唯二两个只出现一次的数
        for (int elem : array) {
            tmp = tmp^elem;
        }
        int mask = 1;
        while ((mask&tmp)==0) {
            mask = mask<<1;
        }
        int a = 0;
        int b = 0;
        for (int elem : array) {
            // 这里必须是要 ==0
            // 因为 & 后的结果不止是当前位为0，而是整个数为 0
            // 不是简单的二元关系！！！
            if ((elem&mask)==0) {
                // 这里还要进行 异或 操作，是为了排除重复的数
                a = a ^ elem;
            } else {
                b = b ^ elem;
            }
        }
        int[] res = new int[2];
        res[0]=Math.min(a,b);
        res[1]=Math.max(a,b);
        return res;
    }
}
