package must.ques;

import must.domain.ListNode;

/**
 * @ClassName NC96_isPail
 * @Description 判断回文链表
 * @Author faro_z
 * @Date 2022/1/12 4:09 下午
 * @Version 1.0
 **/
public class NC96_isPail {
    public static void main(String[] args) {
        NC96_isPail solu = new NC96_isPail();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(1);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        System.out.println(solu.isPail(n1));
    }

    // 折半，后一半反转，判断是否一致
    public boolean isPail (ListNode head) {
        if (head==null || head.next==null) return true;
        ListNode head2 = findHalf(head);
        head2 = reverse(head2);
        while (head!=null && head2!=null) {
            if (head.val!=head2.val) return false;
            head=head.next;
            head2=head2.next;
        }
        return true;
    }

    public ListNode findHalf(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null && fast.next.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode newHead = slow.next;
        slow.next=null;
        return newHead;
    }

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
}
