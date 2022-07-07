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
        intervals.sort((o1,o2) -> o1.start - o2.start);
        ArrayList<Interval> res = new ArrayList<>();
        for (Interval interval : intervals) {
            if (res.isEmpty()) {
                res.add(interval);
            } else {
                if (interval.start<=res.get(res.size()-1).end) {
                    res.get(res.size()-1).end = Math.max(interval.end,res.get(res.size()-1).end);
                } else {
                    res.add(interval);
                }
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
