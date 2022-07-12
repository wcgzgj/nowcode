package must.ques;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName BM90_minWindow
 * @Description TODO
 * @Author faro_z
 * @Date 2022/7/7 16:59
 * @Version 1.0
 **/
public class BM90_minWindow {
    public static void main(String[] args) {
    }

    public String minWindow (String S, String T) {
        char[] source = S.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < T.length(); i++) {
            map.putIfAbsent(T.charAt(i),0);
            map.put(T.charAt(i),map.get(T.charAt(i))+1);
        }
        int l=0,r=-1;
        int minLen = Integer.MAX_VALUE;
        String res = "";
        while (r<source.length) {
            if (check(map)) {
                if (r-l+1<minLen) {
                    res = S.substring(l,r+1);
                    minLen = r-l+1;
                }
                ++l;
                if (map.keySet().contains(source[l-1])) {
                    map.put(source[l-1],map.get(source[l-1])+1);
                }
            } else {
                ++r;
                if (r < source.length && map.keySet().contains(source[r])) {
                    map.put(source[r],map.get(source[r])-1);
                }
            }
        }
        return res;
    }

    /**
     * 检查现有子串是否符合要求，即使有冗余也在要求内
     * 如 source: AAAAAAB ，匹配字符为 AB,那 AAAAB 也是符合的
     *
     * @param map
     * @return
     */
    private boolean check(Map<Character,Integer>map) {
        for (Integer value : map.values()) {
            if (value>0) return false;
        }
        return true;
    }

}
