package must.ques;

import must.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName NC14_Print
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/14 5:37 下午
 * @Version 1.0
 **/
public class NC14_Print {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        reverse(list);
        System.out.println(list);
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        int lay=1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> seq = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                seq.add(tmp.val);
                if (tmp.left!=null) queue.offer(tmp.left);
                if (tmp.right!=null) queue.offer(tmp.right);
            }
            if (lay++%2==0) {
                reverse(seq);
            }
            res.add(seq);
        }
        return res;
    }

    private static void reverse(ArrayList<Integer>list) {
        int l=0,r=list.size()-1;
        while (l<r) {
            Integer tmp = list.get(l);
            list.set(l,list.get(r));
            list.set(r,tmp);
            l++;
            r--;
        }
    }
}
