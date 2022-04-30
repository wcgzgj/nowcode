package must.ques;

import must.domain.ListNode;
import must.util.LinkedListUtil;

/**
 * @ClassName BM2_reverseBetween
 * @Description TODO
 * @Author faro_z
 * @Date 2022/4/30 4:49 下午
 * @Version 1.0
 **/
public class BM2_reverseBetween {
    public static void main(String[] args) {
        BM2_reverseBetween solu = new BM2_reverseBetween();
        ListNode head = LinkedListUtil.buildLinkedList(1, 2, 3, 4, 5, 6, 7);
        LinkedListUtil.outputList(head);
        solu.reverseBetween(head,2,4);
        LinkedListUtil.outputList(head);
    }

    public ListNode reverseBetween (ListNode head, int m, int n) {
        if (head==null || head.next==null) return head;
        ListNode ll = new ListNode(-1);
        ll.next=head;
        ListNode lr = head;
        head=ll;
        for (int i = 0; i < m-1; i++) {
            ll=ll.next;
            lr=lr.next;
        }
        ListNode rl = ll;
        ListNode rr = lr;
        for (int i = 0; i <= n-m; i++) {
            rl = rl.next;
            rr = rr.next;
        }
        reverse(lr,rl);
        ll.next = rl;
        lr.next = rr;
        return head.next;
    }

    public void reverse(ListNode head,ListNode tail) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr!=tail) {
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        curr.next = pre;
    }
}
