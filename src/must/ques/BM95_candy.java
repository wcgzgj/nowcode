package must.ques;

/**
 * @ClassName BM95_candy
 * @Description TODO
 * @Author faro_z
 * @Date 2022/7/7 15:55
 * @Version 1.0
 **/
public class BM95_candy {
    public static void main(String[] args) {
        BM95_candy solu = new BM95_candy();
        // {1,2,2,1,3,1,2} -> {1,2,2,1,2,1,2} = 11
        System.out.println(solu.candy(new int[]{1,2,3,1}));

    }

    public int candy (int[] arr) {
        if (arr==null || arr.length==0) return 0;
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ++res[i];
            if (i>0 && arr[i]>arr[i-1]) {
                res[i] = res[i-1]+1;
            }
        }
        int sum = 0;
        for (int i = arr.length-1; i >=0 ; i--) {
            // 第三个判断条件 && res[i]<=res[i+1] 必须加上，不然从右往左的时候，可能覆盖掉之前从左往右时更大的答案
            // 比如 1,2,3,1 ，正确分法应该是 1,2,3,1，但是不加上最后一个条件的话，就会变成 1,2,2,1
            if (i<arr.length-1 && arr[i]>arr[i+1] && res[i]<=res[i+1]) {
                res[i] = res[i+1]+1;
            }
            sum = sum + res[i];
        }
        return sum;
    }
}
