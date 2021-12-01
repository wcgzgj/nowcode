package must.ques;

/**
 * @ClassName NC144_subsequence
 * @Description TODO
 * @Author faro_z
 * @Date 2021/12/1 3:22 下午
 * @Version 1.0
 **/
public class NC144_subsequence {
    public static void main(String[] args) {
        NC144_subsequence solu = new NC144_subsequence();
        System.out.println(solu.subsequence(6,new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647}));
    }

    public long subsequence (int n, int[] array) {
        if (array.length==1) return new Long(Math.max(0,array[0]));
        if (array.length==2) return new Long(Math.max(0,Math.max(array[0],array[1])));
        long pre = array[0];
        long curr = array[1];
        long res = Math.max(0,Math.max(pre,curr));
        for (int i = 2; i <n ; i++) {
            long newPre = Math.max(curr, pre + array[i]);
            res=Math.max(res,newPre);
            pre=curr;
            curr=newPre;
        }
        return new Long(Math.max(0,res));
    }
}
