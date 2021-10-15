package must.ques;

import java.util.Arrays;

/**
 * @ClassName WC11_singleNumber
 * @Description TODO
 * @Author faro_z
 * @Date 2021/10/14 9:42 上午
 * @Version 1.0
 **/
public class WC11_singleNumber {
    public static void main(String[] args) {

    }

    /**
     * 现在有一个整数类型的数组，数组中只有一个元素只出现一次，其余元素都出现三次。你需要找出只出现一次的元素
     * @param A
     * @return
     */
    public int singleNumber (int[] A) {
        if (A.length==1) return A[0];
        Arrays.sort(A);
        int curr = -1;
        int currCount = 0;
        //for (int i = 0; i < A.length; i++) {
        //    if (currCount==1 || )
        //}

        return -1;
    }
}

