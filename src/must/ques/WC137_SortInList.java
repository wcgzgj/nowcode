package must.ques;

import must.domain.ListNode;

import java.util.List;

public class WC137_SortInList {

    /**
     * 这道题可以使用归并排序的思路实现
     * 有两个值得注意的地方
     * 1：使用快慢指针找中点
     * 2：使用归并的思想进行单链表排序
     * @param head
     * @return
     */
    public ListNode sortInList (ListNode head) {
        if (head==null || head.next==null) return head;
        // 快慢指针找中点
        ListNode fast = head.next;
        ListNode slow = head;
        // 快慢指针套路：slow 从head 开始，fast 从 head.next 开始
        // fast 的终止判断方式为：fast!=null && fast.next!=null
        //
        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode rhead = slow.next;
        slow.next=null;
        ListNode lhead = sortInList(head);
        rhead = sortInList(rhead);
        // 归并有序链表
        ListNode res = new ListNode(-1);
        ListNode tail = res;
        while (lhead!=null && rhead!=null) {
            if (lhead.val<=rhead.val) {
                tail.next=lhead;
                ListNode tmp = lhead.next;
                lhead.next=null;
                lhead=tmp;
                tail=tail.next;
            } else {
                tail.next=rhead;
                ListNode tmp = rhead.next;
                rhead.next=null;
                rhead=tmp;
                tail=tail.next;
            }
        }
        tail.next=lhead!=null?lhead:rhead;
        return res.next;
    }
}
