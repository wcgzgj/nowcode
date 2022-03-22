package must.ques;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DumnQues
 * @Description TODO
 * @Author faro_z
 * @Date 2022/3/21 9:59 下午
 * @Version 1.0
 **/
public class DumnQues {
    private static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        solve(6);
        System.out.println(res);
    }

    /**
     * 5 -> 1 1 2 1
     */
    public static void solve(int num) {
        List<Integer> track = new ArrayList<>();
        backTrack(num,track);
    }

    private static void backTrack(int remain,List<Integer>track) {
        if (remain==0) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 1; i <= remain; i++) {
            if (track.size()==0 || i>=track.get(track.size()-1)) {
                track.add(i);
                backTrack(remain-i,track);
                track.remove(track.size()-1);
            }
        }
    }
}
