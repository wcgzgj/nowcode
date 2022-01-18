package must.ques;

import must.domain.ListNode;

/**
 * @ClassName NC189_plusOne
 * @Description TODO
 * @Author faro_z
 * @Date 2022/1/18 11:28 上午
 * @Version 1.0
 **/
public class NC189_plusOne {
    public static void main(String[] args) {

    }

    public ListNode plusOne (ListNode head) {
        if (head==null) return new ListNode(1);
        head = reverse(head);
        ListNode curr = head;
        ListNode pre=null;
        int cache = 1;
        while (curr!=null) {
            int val = curr.val + cache;
            curr.val=val%10;
            cache=val/10;
            pre=curr;
            curr=curr.next;
        }
        if (cache!=0) pre.next=new ListNode(cache);
        return reverse(head);
    }

    public ListNode reverse(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode pre = null;
        ListNode curr = head;
        while (curr!=null) {
            ListNode tmp = curr.next;
            curr.next=pre;
            pre=curr;
            curr=tmp;
        }
        return pre;
    }
}
