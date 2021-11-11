package must.ques;

/**
 * @ClassName NC68_jumpFloor
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/11 10:50 上午
 * @Version 1.0
 **/
public class NC68_jumpFloor {
    public int jumpFloor(int target) {
        if (target<=2) return target;
        int pre=1,curr=2;
        for (int i = 3; i <=target; i++) {
            int tmp = pre + curr;
            pre=curr;
            curr=tmp;
        }
        return curr;
    }
}
