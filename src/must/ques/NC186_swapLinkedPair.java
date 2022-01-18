package must.ques;

import must.domain.ListNode;

/**
 * @ClassName NC186_swapLinkedPair
 * @Description TODO
 * @Author faro_z
 * @Date 2022/1/18 10:29 上午
 * @Version 1.0
 **/
public class NC186_swapLinkedPair {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;

        NC186_swapLinkedPair solu = new NC186_swapLinkedPair();
        solu.swapLinkedPair(n1);
    }

    public ListNode swapLinkedPair (ListNode head) {
        if (head==null || head.next==null) return head;
        // 这里先递归的往后进行交换
        head.next.next=swapLinkedPair(head.next.next);
        // 再将自己进行交换
        ListNode newHead = head.next;
        head.next=newHead.next;
        newHead.next=head;
        return newHead;
    }
}
