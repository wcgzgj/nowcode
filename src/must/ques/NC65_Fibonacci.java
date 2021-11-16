package must.ques;

import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;

/**
 * @ClassName NC65_Fibonacci
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/16 7:47 下午
 * @Version 1.0
 **/
public class NC65_Fibonacci {
    public static void main(String[] args) {
        NC65_Fibonacci solu = new NC65_Fibonacci();
        System.out.println(solu.Fibonacci(4));
    }

    public int Fibonacci(int n) {
        if (n<=2) return 1;
        int pre=1,curr=1;
        for (int i = 3; i <=n ; i++) {
            int tmp = curr;
            curr=curr+pre;
            pre=tmp;
        }
        return curr;
    }
}
