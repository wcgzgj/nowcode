package must.ques;

import java.util.ArrayList;

/**
 * @ClassName NC329_phoneNumber
 * @Description TODO
 * @Author faro_z
 * @Date 2022/7/12 17:35
 * @Version 1.0
 **/
public class NC329_phoneNumber {
    private static final String[] seq = new String[]{
            "",
            "",
            "ABC",
            "DEF",
            "GHI",
            "JKL",
            "MNO",
            "PQRS",
            "TUV",
            "WXYZ"};

    public ArrayList<String> phoneNumber (String num) {
        ArrayList<String> res = new ArrayList<>();
        StringBuilder track = new StringBuilder();
        int depth = num.length();
        backtrack(track,res,0,depth,num);
        return res;
    }

    private void backtrack(StringBuilder track,ArrayList<String>res,int currDepth,int maxDepth,String num) {
        if (currDepth>=maxDepth) {
            res.add(track.toString());
            return;
        }
        int index = (int) num.charAt(currDepth) - '0';
        String currSeq = seq[index];
        for (int i = 0; i < currSeq.length(); i++) {
            track.append(currSeq.charAt(i));
            backtrack(track,res,currDepth+1,maxDepth,num);
            track.deleteCharAt(track.length()-1);
        }
    }
}
