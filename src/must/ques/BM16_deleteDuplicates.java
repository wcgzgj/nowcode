package must.ques;

import must.domain.ListNode;
import must.util.LinkedListUtil;

/**
 * @ClassName BM16_deleteDuplicates
 * @Description TODO
 * @Author faro_z
 * @Date 2022/4/30 4:03 下午
 * @Version 1.0
 **/
public class BM16_deleteDuplicates {
    public static void main(String[] args) {
        BM16_deleteDuplicates solu = new BM16_deleteDuplicates();
        ListNode head = LinkedListUtil.buildLinkedList(1, 1, 2,3,3);
        LinkedListUtil.outputList(head);
        head = solu.deleteDuplicates(head);
        LinkedListUtil.outputList(head);
    }

    /**
     * 删除链表的有序节点
     * 和 BM15 的区别在于，这次的重复节点一个都不留
     * @param head
     * @return
     */
    public ListNode deleteDuplicates (ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode pre = new ListNode(-114514);
        pre.next=head;
        ListNode cursor = head;
        while (cursor!=null && cursor.next!=null) {
            if (cursor.val==cursor.next.val) {
                pre.next = getNextDiff(cursor);
                //pre=pre.next;
                cursor = pre.next;
                if (pre.val==-114514) {
                    head=pre.next;
                }
            } else {
                cursor=cursor.next;
                pre=pre.next;
            }
        }
        return pre.val==-114514?pre.next:head;
    }

    private ListNode getNextDiff(ListNode start) {
        while (start!=null && start.next!=null) {
            if (start.val!=start.next.val) return start.next;
            start=start.next;
        }
        return null;
    }
}
