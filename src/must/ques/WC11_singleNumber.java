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
        WC11_singleNumber solu = new WC11_singleNumber();
        solu.singleNumber(new int[]{2,2,3,2});
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
        for (int i = 0; i < A.length; i++) {
            if (curr!=A[i] && currCount==1) return curr;
            if (i==A.length-1) return A[A.length-1];
            if (curr==A[i]) {
                currCount++;
            } else {
                currCount=1;
            }
            curr=A[i];
        }
        return -1;
    }
}

