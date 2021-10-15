package must.ques;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName WC3_maxPoints
 * @Description 二维平面上有几个点在同一条直线上
 * 这道题难点不在怎么写出来，难点在于怎么存储斜率（java 除法的时候，会出现精度丢失的问题）
 *
 * @Author faro_z
 * @Date 2021/10/15 2:17 下午
 * @Version 1.0
 **/
public class WC3_maxPoints {
    public static void main(String[] args) {
        //System.out.println(gcd(-3,-3));
        //Map<Integer, Integer> map = new HashMap<>();

        //{new Point(-4,-4),(-8,-582),(-3,3),(-9,-651),(9,591)}
        //Point[] points = {new Point(-4,-4),
        //        new Point(-8,-582),
        //        new Point(-3,-3),
        //        new Point(-9,-651),
        //        new Point(9,591)};
        //[(2,3),(3,3),(-5,3)][(4,0),(4,-1),(4,5)]
        Point[] points = {new Point(2,3),
                new Point(3,3),
                new Point(-5,3)};
        WC3_maxPoints solu = new WC3_maxPoints();
        System.out.println(solu.maxPoints(points));
    }

    /**
     * 找寻同一直线上最多的点的个数
     * @param points
     * @return
     */
    public int maxPoints (Point[] points) {
        if (points.length<3) return points.length;
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            // 统计同一个位置的点
            int dup = 0;

            // 用来统计，当前点的情况下，不同斜率对应的点的个数
            // 咱们的斜率表示，可以将 x,y 的二维，转换为一维进行存储
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i+1; j < points.length; j++) {
                int x = points[i].x-points[j].x;
                int y = points[i].y-points[j].y;
                if (x==0 && y==0) {
                    dup++;
                    continue;
                }
                // 最大公约数
                int d = gcd(Math.abs(x),Math.abs(y));
                x/=d;
                y/=d;
                // 将二维信息降维为一维 <---- 降维这个操作，如果其中某个值是负数，就不好使了
                // 比如 (-2,3) 和 (2,-3) 两个值，斜率应该是一样的，但是，降维之后，其 key 值就是不一样的
                // 所以要进行下面这个操作
                if (y<0) {
                    // 这样，如果 x,y 全负，其对应的 key 和 x,y 全正是一样的
                    // 如果 x正 y负，其 key 和 x负 y正 是一样的
                    x=-x;
                    y=-y;
                }
                // 除了考虑降维之外，还要注意斜率不存在，或者斜率为 0 的情况(因为我们有一个降维操作)
                // (2,3),(3,3),(-5,3)  这三个斜率都不存在，但是都在同一条直线上，可以其 key 算出来有完全不一样
                if (x==0) y=1;
                if (y==0) x=1;

                int key = x*200001+y;
                // 默认初始化为1，因为要把自己也算进去
                map.put(key,map.getOrDefault(key,1)+1);
            }
            int tmpMax = -1;
            for (Integer key : map.keySet()) {
                tmpMax=Math.max(tmpMax,map.get(key));
            }
            // 重复的点 也要加上
            max = Math.max(max,tmpMax+dup);
        }
        return max;
    }

    public static int gcd(int a,int b) {
        return b!=0?gcd(b,a%b):a;
    }
}

class Point {
    public int x;
    public int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
