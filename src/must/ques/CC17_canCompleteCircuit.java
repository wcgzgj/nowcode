package must.ques;

/**
 * @ClassName CC17_canCompleteCircuit
 * @Description TODO
 * @Author faro_z
 * @Date 2021/10/25 1:33 下午
 * @Version 1.0
 **/
public class CC17_canCompleteCircuit {
    public static void main(String[] args) {
        CC17_canCompleteCircuit solu = new CC17_canCompleteCircuit();
        System.out.println(solu.canCompleteCircuit(new int[]{1,2},new int[]{2,1}));
    }
    public int canCompleteCircuit (int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j <i+n ; j++) {
                // 我们通过取模的方式，保证下标不会超过数组范围
                int index = j % n;
                sum+=gas[index];
                sum-=cost[index];
                if (sum<0) break;
                if (j==i+n-1 && sum>=0) return i;
            }
        }
        return -1;
    }
}
