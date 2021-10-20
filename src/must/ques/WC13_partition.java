package must.ques;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName WC13_partition
 * @Description TODO
 * @Author faro_z
 * @Date 2021/10/18 11:15 上午
 * @Version 1.0
 **/
public class WC13_partition {
    public static void main(String[] args) {
        WC13_partition solu = new WC13_partition();
        /**
         * [[b, b, a, b],
         *  [b, bab, b],  <--- 错误情况????
         *  [bb, a, b]]
         */
        System.out.println(solu.partition("bbab"));
    }

    private ArrayList<ArrayList<String>> res = new ArrayList<>();

    /**
     * 给定一个字符串s，分割s使得s的每一个子串都是回文串
     * 返回所有的回文分割结果。（注意：返回结果的顺序需要和输入字符串中的字母顺序一致。）
     * 示例1
     * 输入：
     * "dde"
     *
     * 返回值：
     * [["d","d","e"],["dd","e"]]
     *
     * 使用回溯的方法
     *
     * @param s
     * @return
     */
    public ArrayList<ArrayList<String>> partition (String s) {
        if (s==null || s.length()==0) return res;
        ArrayList<String> track = new ArrayList<>();
        backTrack(track,s,0,0);
        return res;
    }

    public void backTrack(ArrayList<String>track,String str,int l,int r) {
        // 递归终止条件
        if (r>=str.length()) {
            res.add(new ArrayList<>(track));
            return;
        }
        List<Integer> possiblePos = getPossiblePos(str, l, r);
        for (Integer R : possiblePos) {
            int originL = l;
            track.add(subString(str,l,R));
            l=r+1;
            r=l;
            backTrack(track,str,l,r);
            track.remove(track.size()-1);
            l=originL;
        }
    }

    // 找寻在 l 不变的情况下，能过获得回文串的所有 r 的可能
    // 照理说，这个方法应该没有问题..
    private List<Integer> getPossiblePos(String str, int l , int r) {
        List<Integer> list = new ArrayList<>();
        while (r<str.length()) {
            if (isHuiWen(str,l,r)) list.add(r);
            r++;
        }
        return list;
    }

    // 为了避免和后面的逻辑混淆，这里重写一个 subString方法，其终止位置是包含的
    private static String subString(String str,int l,int r) {
        return str.substring(l,r+1);
    }

    public boolean isHuiWen(String str,int l,int r) {
        while (l<r) {
            if (str.charAt(l++)!=str.charAt(r--)) return false;
        }
        return true;
    }
}
