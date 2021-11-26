package must.ques;

/**
 * @ClassName NC32_sqrt
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/26 4:46 下午
 * @Version 1.0
 **/
public class NC32_sqrt {
    public static void main(String[] args) {
        NC32_sqrt solu = new NC32_sqrt();
        System.out.println(solu.sqrt(9));
    }

    // 求平方根
    public int sqrt (int x) {
        if (x<=1) return x;
        int l=0,r=x;
        while (l<=r) {
            int mid = (l + r) / 2;
            if (mid<=x/mid && (mid+1)>x/(mid+1)) return mid;
            if (mid>x/mid) r=mid-1;
            else l=mid+1;
        }
        return -1;
    }
}
