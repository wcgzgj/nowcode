package must.ques;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName CC12_wordBreak
 * @Description TODO
 * @Author faro_z
 * @Date 2021/10/24 12:16 下午
 * @Version 1.0
 **/
public class CC12_wordBreak {

    public static void main(String[] args) {
        CC12_wordBreak solu = new CC12_wordBreak();
        Set<String> set = new HashSet<>();
        //set.add("now");
        //set.add("cod");
        set.add("a");
        System.out.println(solu.wordBreak("a",set));
    }

    /**
     *
     * @param s
     * @param dict
     * @return
     */
    public boolean wordBreak(String s, Set<String> dict) {
        return backTrack(s,dict,0,0);
    }

    public boolean backTrack(String str,Set<String> dict,int l,int r) {
        // 递归终止条件
        if (r>=str.length()) return true;
        boolean res = false;
        for (int i = l; i <str.length(); i++) {
            if (dict.contains(subString(str,l,i))) {
                res = res || backTrack(str,dict,i+1,i+1);
            }
        }
        return res;
    }

    // 包头包尾的 subString 函数
    public static String subString(String str,int l,int r) {
        return str.substring(l,r+1);
    }
}
