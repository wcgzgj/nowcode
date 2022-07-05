package must.ques;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName BM45_maxInWindows
 * @Description TODO
 * @Author faro_z
 * @Date 2022/7/4 18:30
 * @Version 1.0
 **/
public class BM45_maxInWindows {
    public static void main(String[] args) {
        BM45_maxInWindows solu = new BM45_maxInWindows();
        System.out.println(solu.maxInWindows(new int[]{
                2,3,4,2,6,2,5,1
        },3));
    }

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num==null || num.length==0) return res;
        Deque<Integer> deque = new LinkedList<>();
        int l=0,r=size-1;
        for (int i = 0; i < size; i++) {
            while (!deque.isEmpty() && deque.peekLast()<num[i]) {
                deque.pollLast();
            }
            deque.offerLast(num[i]);
        }
        res.add(deque.peekFirst());
        while (r<num.length-1) {
            ++r;
            ++l;
            if (deque.peekFirst()==num[l-1]) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && deque.peekLast()<num[r]) {
                deque.pollLast();
            }
            deque.offerLast(num[r]);
            res.add(deque.peekFirst());
        }
        return res;
    }
}
