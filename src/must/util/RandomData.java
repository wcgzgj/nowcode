package must.util;

import java.util.Random;

/**
 * @ClassName RandomData
 * @Description TODO
 * @Author faro_z
 * @Date 2021/10/24 12:43 下午
 * @Version 1.0
 **/
public class RandomData {
    private static Random r = new Random();
    public static int[] getRandomArray(int n,int max) {
        if (n<=0) return new int[0];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=r.nextInt(max);
        }
        return arr;
    }
}
