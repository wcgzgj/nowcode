package must.ques;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName NC54_threeSum
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/17 4:40 下午
 * @Version 1.0
 **/
public class NC54_threeSum {
    public static void main(String[] args) {
        NC54_threeSum solu = new NC54_threeSum();
        //System.out.println(solu.threeSum(new int[]{0,0,0}));
        System.out.println(solu.threeSum(new int[]{-2,0,1,1,2}));
    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (num.length<3) return res;
        Arrays.sort(num);
        int k=0;
        while (k>=0 && k<num.length-2) {
            if (num[k]>0) return res;
            int l=k+1,r=num.length-1;
            while (l<r) {
                int sum = getSum(num, k, l, r);
                if (sum==0) {
                    res.add(collectAsList(num[k],num[l],num[r]));
                    r=removeWithoutSame(num,r,-1);
                    l=removeWithoutSame(num,l,1);
                }
                else if (sum>0) r=removeWithoutSame(num,r,-1);
                else l=removeWithoutSame(num,l,1);
            }
            k=removeWithoutSame(num,k,1);
        }
        return res;
    }

    // 一直后移，直到当前值与原来位置的值不一样
    public int removeWithoutSame(int[]num,int k,int step) {
        int originVal = num[k];
        while (k<num.length && k>=0 && num[k]==originVal) k+=step;
        if (k<0 || k>=num.length) return -1;
        return k;
    }

    // 将传入的元素组成新的数组
    public ArrayList<Integer> collectAsList(int ...args) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int arg : args) {
            res.add(arg);
        }
        return res;
    }

    public int getSum(int[]num,int ...indices) {
        int sum=0;
        for (int index : indices) {
            sum+=num[index];
        }
        return sum;
    }
}
