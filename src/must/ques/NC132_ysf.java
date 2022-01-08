package must.ques;

import must.domain.ListNode;

import java.util.LinkedList;

/**
 * @ClassName NC132_ysf
 * @Description TODO
 * @Author faro_z
 * @Date 2022/1/8 1:45 下午
 * @Version 1.0
 **/
public class NC132_ysf {
    public static void main(String[] args) {
        NC132_ysf solu = new NC132_ysf();
        System.out.println(solu.ysf(1,1));
    }

    public int ysf (int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <=n ; i++) {
            list.addLast(i);
        }
        int curr = 0;
        for (int i = 0; i < n - 1; i++) {
            curr+=m-1;
            curr=curr%list.size();
            list.remove(curr);
        }
        return list.get(0);
    }

    //// 移动固定步长
    //public int moveStep(int[]arr,int step,int index) {
    //
    //    return -1;
    //}
    //
    //// 获取下一个位置的下标
    //public int nextIndex(int []arr,int index) {
    //    while (arr[(index+1)%arr.length]==-1) index++;
    //    return (index+1)%arr.length;
    //}
}
