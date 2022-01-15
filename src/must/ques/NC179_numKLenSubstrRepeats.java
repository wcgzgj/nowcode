package must.ques;

import java.util.HashSet;

/**
 * @ClassName NC179_numKLenSubstrRepeats
 * @Description TODO
 * @Author faro_z
 * @Date 2022/1/15 3:26 下午
 * @Version 1.0
 **/
public class NC179_numKLenSubstrRepeats {
    public static void main(String[] args) {
        NC179_numKLenSubstrRepeats solu = new NC179_numKLenSubstrRepeats();
        System.out.println(solu.numKLenSubstrRepeats("yokagames",3));
    }

    //public int numKLenSubstrRepeats (String s, int k) {
    //    if (k>s.length()) return 0;
    //    int l=0,r=l+k-1;
    //    int count = 0;
    //    while (r<s.length()) {
    //        if (hasSameWords(s,l++,r++)) count++;
    //    }
    //    return count;
    //}
    //
    //public boolean hasSameWords(String s,int l,int r) {
    //    HashSet<Character> set = new HashSet<>();
    //    for (int i = l; i <=r ; i++) {
    //        if (set.contains(s.charAt(i))) return true;
    //        set.add(s.charAt(i));
    //    }
    //    return false;
    //}

    private static final HashSet<Character> set = new HashSet<>();

    public int numKLenSubstrRepeats (String s, int k) {
        if (k>s.length()) return 0;
        int l=0,r=l+k-1;
        int count = 0;
        while (r<s.length()) {
            if (hasSameWords(s,l++,r++)) count++;
        }
        return count;
    }

    public boolean hasSameWords(String s,int l,int r) {
        HashSet<Character> set = new HashSet<>();
        for (int i = l; i <=r ; i++) {
            if (set.contains(s.charAt(i))) return true;
            set.add(s.charAt(i));
        }
        return false;
    }
}
