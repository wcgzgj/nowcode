package must.ques;

/**
 * @ClassName BM53_minNumberDisappeared
 * @Description TODO
 * @Author faro_z
 * @Date 2022/7/7 15:44
 * @Version 1.0
 **/
public class BM53_minNumberDisappeared {
    public static void main(String[] args) {

    }

    public int minNumberDisappeared (int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int elem : nums) {
            max = Math.max(max,elem);
        }
        int[] map = new int[max + 2];
        for (int elem : nums) {
            if (elem>0) {
                map[elem]=1;
            }
        }
        for (int i = 1; i <=max+1 ; i++) {
            if (map[i]==0) return i;
        }
        return -1;
    }
}
