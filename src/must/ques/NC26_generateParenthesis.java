package must.ques;

import java.util.ArrayList;

/**
 * @ClassName NC26_generateParenthesis
 * @Description TODO
 * @Author faro_z
 * @Date 2022/1/1 3:00 下午
 * @Version 1.0
 **/
public class NC26_generateParenthesis {
    public static void main(String[] args) {
        NC26_generateParenthesis solu = new NC26_generateParenthesis();
        System.out.println(solu.generateParenthesis(1));
        System.out.println(solu.generateParenthesis(2));
        System.out.println(solu.generateParenthesis(3));
        System.out.println(solu.generateParenthesis(4));
    }

    public ArrayList<String> generateParenthesis (int n) {
        ArrayList<String> res = new ArrayList<>();
        backTrack(n,n,new StringBuilder(),res);
        return res;
    }

    public void backTrack(int ls,int rs,StringBuilder track,ArrayList<String> res) {
        // 递归终止条件
        if (ls==0 && rs==0) {
            res.add(track.toString());
            return;
        }
        if (ls==rs) {
            track.append("(");
            backTrack(ls-1,rs,track,res);
            track.replace(track.length()-1,track.length(),"");
        } else {
            if (ls>0) {
                track.append("(");
                backTrack(ls-1,rs,track,res);
                track.replace(track.length()-1,track.length(),"");
            }
            track.append(")");
            backTrack(ls,rs-1,track,res);
            track.replace(track.length()-1,track.length(),"");
        }
    }
}
