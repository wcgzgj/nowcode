package must.util;

import must.domain.ListNode;

/**
 * @ClassName LinkedListUtil
 * @Description TODO
 * @Author faro_z
 * @Date 2022/4/30 3:34 下午
 * @Version 1.0
 **/
public class LinkedListUtil {
    public static void outputList(ListNode node) {
        if (node==null) {
            System.out.println("null");
            return;
        }
        StringBuilder builder = new StringBuilder();
        while (node!=null && node.next!=null) {
            builder.append(node.val).append(" -> ");
            node=node.next;
        }
        builder.append(node.val);
        System.out.println(builder.toString());
    }

    public static ListNode buildLinkedList(int...vals) {
        ListNode head = new ListNode();
        ListNode tail = head;
        for (int val : vals) {
            tail.next=new ListNode(val);
            tail=tail.next;
        }
        return head.next;
    }
}
