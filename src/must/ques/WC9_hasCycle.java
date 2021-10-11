package must.ques;

import must.domain.ListNode;

/**
 * @ClassName WC9_hasCycle
 * @Description 判断链表是否有环
 * @Author faro_z
 * @Date 2021/10/11 11:15 上午
 * @Version 1.0
 **/
public class WC9_hasCycle {
    public boolean hasCycle(ListNode head) {
        if (head==null || head.next==null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow) return true;
        }
        return false;
    }
}
