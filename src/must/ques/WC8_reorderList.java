package must.ques;

import must.domain.ListNode;

/**
 * @ClassName WC8_reorderList
 * @Description TODO
 * @Author faro_z
 * @Date 2021/10/11 11:03 上午
 * @Version 1.0
 **/
public class WC8_reorderList {

    public void reorderList(ListNode head) {
        if (head==null || head.next==null) return;
        ListNode h1 = head;
        ListNode h2 = cutHalf(head);
        h2 = reverse(h2);
        head = merge(h1,h2);
    }

    // 链表折半
    public ListNode cutHalf(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!=null && fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode tmp = slow.next;
        // 一定要断尾
        slow.next=null;
        return tmp;
    }

    // 链表反转
    public ListNode reverse(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode curr = head;
        ListNode pre = null;
        while (curr!=null) {
            ListNode tmp = curr.next;
            curr.next=pre;
            pre=curr;
            curr=tmp;
        }
        return pre;
    }

    // 链表合并
    public ListNode merge(ListNode h1,ListNode h2) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (h1!=null && h2!=null) {
            tail.next=h1;
            tail=tail.next;
            h1=h1.next;
            tail.next=h2;
            tail=tail.next;
            h2=h2.next;
        }
        tail.next=h1!=null?h1:h2;
        return head.next;
    }
}
