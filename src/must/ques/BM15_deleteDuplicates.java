package must.ques;

import must.domain.ListNode;
import must.util.LinkedListUtil;

import java.util.List;

/**
 * @ClassName BM15_deleteDuplicates
 * @Description TODO
 * @Author faro_z
 * @Date 2022/4/30 3:25 下午
 * @Version 1.0
 **/
public class BM15_deleteDuplicates {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        node1.next=node2;
        BM15_deleteDuplicates solu = new BM15_deleteDuplicates();
        System.out.println("删除前，链表信息为:");
        LinkedListUtil.outputList(node1);
        System.out.println("删除后，链表信息Wie：");
        LinkedListUtil.outputList(solu.deleteDuplicates(node1));
    }

    /**
     * 删除链表重复元素（链表元素有序）
     * @param head
     * @return
     */
    public ListNode deleteDuplicates (ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode cursor = head;
        while (cursor!=null && cursor.next!=null) {
            if (cursor.val==cursor.next.val) {
                cursor.next = getNextDiff(cursor);
            }
            cursor=cursor.next;
        }
        return head;
    }

    private ListNode getNextDiff(ListNode start) {
        while (start!=null && start.next!=null) {
            if (start.val!=start.next.val) return start.next;
            start=start.next;
        }
        return null;
    }
}
