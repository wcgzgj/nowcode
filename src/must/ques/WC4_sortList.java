package must.ques;

import must.domain.ListNode;

/**
 * @ClassName WC4_sortList
 * @Description TODO
 * @Author faro_z
 * @Date 2021/10/11 10:40 上午
 * @Version 1.0
 **/
public class WC4_sortList {
    /**
     * 使用归并，对单链表进行排序
     * @param head
     * @return
     */
    public ListNode sortList (ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast!=null && fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        // 获取链表的两个部分
        ListNode h1 = head;
        ListNode h2 = slow.next;
        slow.next=null;

        // 对两个部分递归进行归并排序
        h1 = sortList(h1);
        h2 = sortList(h2);

        // 归并有序链表
        return merge(h1,h2);
    }

    public ListNode merge(ListNode h1,ListNode h2) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (h1!=null && h2!=null) {
            if (h1.val<=h2.val) {
                tail.next=h1;
                tail=tail.next;
                h1=h1.next;
            } else {
                tail.next=h2;
                tail=tail.next;
                h2=h2.next;
            }
        }
        tail.next=h1!=null?h1:h2;
        return head.next;
    }
}
