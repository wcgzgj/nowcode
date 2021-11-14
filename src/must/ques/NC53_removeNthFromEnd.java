package must.ques;

import must.domain.ListNode;

/**
 * @ClassName NC53_removeNthFromEnd
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/12 4:45 下午
 * @Version 1.0
 **/
public class NC53_removeNthFromEnd {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd (ListNode head, int n) {
        if (head==null) return head;
        ListNode pre = head;
        ListNode curr = head;
        while (n-->0) curr=curr.next;
        // 后置指针如果超出范围，说明要删除的是第一个节点
        if (curr==null) return head.next;
        while (curr.next!=null) {
            curr=curr.next;
            pre=pre.next;
        }
        pre.next=pre.next.next;
        return head;
    }
}
