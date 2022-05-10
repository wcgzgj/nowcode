package must.ques;

import must.domain.ListNode;
import must.util.LinkedListUtil;

/**
 * @ClassName BM8_FindKthToTail
 * @Description TODO
 * @Author faro_z
 * @Date 2022/4/30 5:07 下午
 * @Version 1.0
 **/
public class BM8_FindKthToTail {
    public static void main(String[] args) {
        BM8_FindKthToTail solu = new BM8_FindKthToTail();
        ListNode head = LinkedListUtil.buildLinkedList(1, 2, 3, 4, 5);
        LinkedListUtil.outputList(head);
        System.out.println(solu.FindKthToTail(head,0));
    }

    public ListNode FindKthToTail (ListNode pHead, int k) {
        if (pHead==null) return pHead;
        ListNode head = pHead;
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail==null) return null;
            tail=tail.next;
        }
        while (tail!=null) {
            tail=tail.next;
            head = head.next;
        }
        return head;
    }
}
