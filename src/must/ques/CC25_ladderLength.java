package must.ques;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

/**
 * @ClassName CC25_ladderLength
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/3 1:47 下午
 * @Version 1.0
 **/
public class CC25_ladderLength {

    public static void main(String[] args) {
        /*
            目标单词end ="tax"。
            单词字典dict =["ted","tex","red","tax","tad","den","rex","pee"]
         */
        CC25_ladderLength solu = new CC25_ladderLength();
        HashSet<String> set = new HashSet<>();
        set.add("ted");
        set.add("tex");
        set.add("red");
        set.add("tax");
        set.add("tad");
        set.add("den");
        set.add("rex");
        set.add("pee");
        set.add("hot");
        set.add("dog");
        System.out.println(solu.ladderLength("red","tax",set));
    }

    public int ladderLength(String start, String end, HashSet<String> dict) {
        Map<String, Boolean> visited = new HashMap<>();
        for (String str : dict) {
            visited.put(str,false);
        }
        if (!visited.keySet().contains(end)) return 0;
        visited.put(start,true);
        int layCount=1;
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            // 没有可选项了，说明找不到
            if (!visited.values().contains(true)) return 0;
            int size = queue.size();
            layCount++;
            for (int i = 0; i < size; i++) {
                String tmp = queue.poll();
                if (isChangeable(tmp,end)) return layCount;
                for (String key : visited.keySet()) {
                    if (!visited.get(key) && isChangeable(tmp,key)) {
                        queue.offer(key);
                        visited.put(key,true);
                    }
                }
            }
        }
        return 0;
    }

    // 检查两个单词是否可以相互转换
    // 只有相等或者只相差一个字母，且长度相等的单词才可以相互转换
    private boolean isChangeable(String from,String to) {
        if (from.length()!=to.length()) return false;
        if (from.length()==0) return true;
        int diffCount = 0;
        for (int i = 0; i < from.length(); i++) {
            if (from.charAt(i)!=to.charAt(i)) diffCount++;
        }
        if (diffCount<=1) return true;
        return false;
    }


    /*
    rad  -    kad     -      tax

            pad

            qad
     */
}
