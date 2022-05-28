package must.ques;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName leetcode202_isHappy
 * @Description TODO
 * @Author faro_z
 * @Date 2022/5/15 12:52 上午
 * @Version 1.0
 **/
public class leetcode202_isHappy {
    public static void main(String[] args) {
        leetcode202_isHappy solu = new leetcode202_isHappy();
        System.out.println(solu.isHappy(19));
    }

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(set,n);
    }

    private boolean dfs(Set<Integer>pool,int num) {
        if (num==1) return true;
        if (pool.contains(num)) return false;
        pool.add(num);
        num = doHappyOp(num);
        return dfs(pool,num);
    }

    private int doHappyOp(int num) {
        int res = 0;
        while (num>=1) {
            res+=pow(num%10);
            num = num/10;
        }
        return res;
    }

    private int pow(int num) {
        return num*num;
    }
}

