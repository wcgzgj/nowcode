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
        set.add("now");
        set.add("code");
        //set.add("a");
        System.out.println(solu.wordBreak("nowcode",set));
    }

    /**
     *
     * @param s
     * @param dict
     * @return
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // 方法一：单纯回溯，直接超时（时间复杂度为 O(n^n)）
        //return backTrack(s,dict,0,0);

        // 状态转移方程 dp[i] = 对于任意j dp[j] && dict.contains(str.subString(j+1,i))
        boolean[] dp = new boolean[s.length() + 1];
        dp[0]=true;
        for (int i = 1; i <=s.length() ; i++) {
            for (int j = 0; j < i; j++) {
                String curr = s.substring(j, i);
                if (dict.contains(curr) && dp[j]) {
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    // 方法一：单纯回溯，直接超时（时间复杂度为 O(n^n)）
    //public boolean backTrack(String str,Set<String> dict,int l,int r) {
    //    // 递归终止条件
    //    if (r>=str.length()) return true;
    //    boolean res = false;
    //    for (int i = l; i <str.length(); i++) {
    //        if (dict.contains(subString(str,l,i))) {
    //            res = res || backTrack(str,dict,i+1,i+1);
    //        }
    //    }
    //    return res;
    //}
    //
    //// 包头包尾的 subString 函数
    //public static String subString(String str,int l,int r) {
    //    return str.substring(l,r+1);
    //}

}
