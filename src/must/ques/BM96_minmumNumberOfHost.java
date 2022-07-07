package must.ques;

import java.util.Arrays;

/**
 * @ClassName BM96_minmumNumberOfHost
 * @Description TODO
 * @Author faro_z
 * @Date 2022/7/7 16:23
 * @Version 1.0
 **/
public class BM96_minmumNumberOfHost {
    public static void main(String[] args) {

    }

    public int minmumNumberOfHost (int n, int[][] startEnd) {
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = startEnd[i][0];
            ends[i] = startEnd[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        // 结束场次的下标
        int j = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            // 说明当前主持人可以应付当前场次
            if (starts[i]>=ends[j]) {
                j++;
            } else {
                res++;
            }
        }
        return res;
    }
}
