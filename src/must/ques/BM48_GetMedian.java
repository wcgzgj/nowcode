package must.ques;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName BM48_GetMedian
 * @Description TODO
 * @Author faro_z
 * @Date 2022/7/17 16:11
 * @Version 1.0
 **/
public class BM48_GetMedian {

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 4, 1, 6, 7, 0, 8};
        BM48_GetMedian solu = new BM48_GetMedian();
        for (int elem : arr) {
            solu.Insert(elem);
            System.out.println(solu.GetMedian());
        }
    }

    // 小根堆记录大值
    private final Queue<Integer> rMinQueue = new PriorityQueue<>((o1, o2) -> o1 - o2);
    // 大根堆记录小值
    private final Queue<Integer> lMaxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
    //private int lLen = 0;
    //private int rLen = 0;

    public void Insert(Integer num) {
        if (lMaxQueue.isEmpty() || num<lMaxQueue.peek()) lMaxQueue.offer(num);
        else rMinQueue.offer(num);
        if (lMaxQueue.size()-rMinQueue.size()==2) {
            rMinQueue.offer(lMaxQueue.poll());
        } else if (rMinQueue.size()-lMaxQueue.size()==2) {
            lMaxQueue.offer(rMinQueue.poll());
        }
    }

    public Double GetMedian() {
        if (rMinQueue.size()==lMaxQueue.size() && rMinQueue.size()==0) return 0D;
        if (rMinQueue.size()>lMaxQueue.size()) return Double.valueOf(rMinQueue.peek());
        else if (lMaxQueue.size()>rMinQueue.size()) return Double.valueOf(lMaxQueue.peek());
        return ((double)(lMaxQueue.peek() + rMinQueue.peek()))/2;
    }

}
