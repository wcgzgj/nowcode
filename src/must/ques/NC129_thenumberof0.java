package must.ques;

/**
 * @ClassName NC129_thenumberof0
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/28 2:39 下午
 * @Version 1.0
 **/
public class NC129_thenumberof0 {
    public static void main(String[] args) {

    }

    public long thenumberof0 (long n) {
        long count=0;
        while (n>0) {
            count+=n/5;
            n/=5;
        }
        return count;
    }
}
