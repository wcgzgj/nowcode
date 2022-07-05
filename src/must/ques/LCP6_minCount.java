package must.ques;

/**
 * @ClassName LCP6_minCount
 * @Description TODO
 * @Author faro_z
 * @Date 2022/7/5 16:37
 * @Version 1.0
 **/
public class LCP6_minCount {
    public static void main(String[] args) {

    }

    public int minCount(int[] coins) {
        int count = 0;
        for (int coin : coins) {
            count+=coin/2+coin%2;
        }
        return count;
    }
}
