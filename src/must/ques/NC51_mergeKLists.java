package must.ques;

import must.domain.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName NC51_mergeKLists
 * @Description 合并 k 个有序序列
 * @Author faro_z
 * @Date 2021/11/26 8:08 下午
 * @Version 1.0
 **/
public class NC51_mergeKLists {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next=n3;
        n2.next=n4;
        n4.next=n5;
        ArrayList<ListNode> lists = new ArrayList<>();
        lists.add(n1);
        lists.add(n2);
        NC51_mergeKLists solu = new NC51_mergeKLists();
        ListNode head = solu.mergeKLists(lists);
        while (head!=null) {
            System.out.print(head.val+" -> ");
            head=head.next;
        }
    }

    //public ListNode mergeKLists(ArrayList<ListNode> lists) {
    //    if (lists==null || lists.size()==0) return null;
    //    ListNode hair = new ListNode(-1);
    //    ListNode tail = hair;
    //    while (!isDone(lists)) {
    //        int minNodeVal = Integer.MAX_VALUE;
    //        int minNodeIndex=0;
    //        for (int i = 0; i < lists.size(); i++) {
    //            if (lists.get(i)!=null && lists.get(i).val<minNodeVal) {
    //                minNodeVal=lists.get(i).val;
    //                minNodeIndex=i;
    //            }
    //        }
    //        tail.next=new ListNode(minNodeVal);
    //        tail=tail.next;
    //        lists.set(minNodeIndex,lists.get(minNodeIndex).next);
    //    }
    //    return hair.next;
    //}
    //
    //private boolean isDone(ArrayList<ListNode> lists) {
    //    for (ListNode node : lists) {
    //        if (node!=null) return false;
    //    }
    //    return true;
    //}


    // 方法2：利用分治的思想
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        return mergeSort(0,lists.size()-1,lists);
    }


    public ListNode mergeSort(int low,int high,ArrayList<ListNode> lists){
        if (low==high) return lists.get(low);
        if (low>high) return null;
        int mid = (low + high)/2;
        return merge(mergeSort(low,mid,lists),mergeSort(mid+1,high,lists));
    }

    public ListNode merge(ListNode n1,ListNode n2) {
        ListNode hair = new ListNode(-1);
        ListNode tail = hair;
        while (n1!=null && n2!=null) {

        }
        return null;
    }
}
