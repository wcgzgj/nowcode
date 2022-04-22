package must.ques;

import java.util.ArrayList;

/**
 * @ClassName BM89_merge
 * @Description TODO
 * @Author faro_z
 * @Date 2022/4/22 9:49 下午
 * @Version 1.0
 **/
public class BM89_merge {
    public static void main(String[] args) {

    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<>();
        if (intervals==null || intervals.size()==0) {
            return res;
        }
        intervals.sort((o1, o2) -> o1.start-o2.start);
        int top = intervals.get(0).end;
        res.add(intervals.get(0));
        for (int i = 1; i < intervals.size() ; i++) {
            Interval curr = intervals.get(i);
            if (curr.start<=top) {
                top = Math.max(curr.end,top);
                res.get(res.size()-1).end = top;
            } else {
                res.add(curr);
                top = Math.max(curr.end,top);
            }
        }
        return res;
    }
}

class Interval {
  int start;
  int end;
  Interval() { start = 0; end = 0; }
  Interval(int s, int e) { start = s; end = e; }
}
