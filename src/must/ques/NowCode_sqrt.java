package must.ques;

/**
 * @ClassName NowCode_sqrt
 * @Description TODO
 * @Author faro_z
 * @Date 2022/6/19 17:34
 * @Version 1.0
 **/
public class NowCode_sqrt {
    public static void main(String[] args) {
        NowCode_sqrt solu = new NowCode_sqrt();
        System.out.println(solu.sqrt(2));
    }

    public int sqrt (int x) {
        int l = 1;
        int r = x;
        int mid = 0;
        while (l<=r) {
            mid = (l + r) / 2;
            int tmp = x / mid;
            if (tmp==mid) return mid;
            else if (tmp>mid) l++;
            else r--;
        }
        return mid;
    }
}
