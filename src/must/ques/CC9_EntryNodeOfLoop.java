package must.ques;

import must.domain.ListNode;

import java.util.ArrayList;

/**
 * @ClassName CC9_EntryNodeOfLoop
 * @Description TODO
 * @Author faro_z
 * @Date 2021/10/24 2:15 下午
 * @Version 1.0
 **/
public class CC9_EntryNodeOfLoop {
    public static void main(String[] args) {

    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead==null || pHead.next==null) return null;
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast!=null && fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
            // 快慢相遇，说明成环
            if (fast==slow) {
                ListNode tmp = pHead;
                while (tmp!=slow) {
                    tmp=tmp.next;
                    slow=slow.next;
                }
                return tmp;
            }
        }
        return null;
    }
}
