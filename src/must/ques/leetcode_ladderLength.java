package must.ques;

import java.util.*;

/**
 * @ClassName leetcode_ladderLength
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/3 2:43 下午
 * @Version 1.0
 **/
public class leetcode_ladderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Boolean> visited = new HashMap<>();
        for (String str : wordList) {
            visited.put(str,false);
        }
        if (!visited.keySet().contains(endWord)) return 0;
        visited.put(beginWord,true);
        int layCount=1;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            // 没有可选项了，说明找不到
            if (!visited.values().contains(true)) return 0;
            int size = queue.size();
            layCount++;
            for (int i = 0; i < size; i++) {
                String tmp = queue.poll();
                if (isChangeable(tmp,endWord)) return layCount;
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
}
