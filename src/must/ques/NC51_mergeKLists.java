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


    // 方法2：利用二分的思想
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists==null || lists.size()==0) return null;
        return mergeSort(lists,0,lists.size()-1);
    }

    private ListNode mergeSort(ArrayList<ListNode> lists,int l,int r) {
        if (l==r) return lists.get(l);
        if (l>r) return null;
        int mid = (l + r) / 2;
        return merge(mergeSort(lists,l,mid),mergeSort(lists,mid+1,r));
    }

    // 归并两个有序链表
    private ListNode merge(ListNode n1,ListNode n2) {
        ListNode hair = new ListNode(-1);
        ListNode tail = hair;
        while (n1!=null && n2!=null) {
            if (n1.val<=n2.val) {
                tail.next=n1;
                n1=n1.next;
            } else {
                tail.next=n2;
                n2=n2.next;
            }
            tail=tail.next;
        }
        if (n1 == null) {
            tail.next = n2;
        } else {
            tail.next = n1;
        }
        return hair.next;
    }
}
