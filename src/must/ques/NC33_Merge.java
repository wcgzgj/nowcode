package must.ques;

import must.domain.ListNode;

/**
 * @ClassName NC33_Merge
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/11 10:24 上午
 * @Version 1.0
 **/
public class NC33_Merge {
    public static void main(String[] args) {

    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (list1!=null && list2!=null) {
            if (list1.val<=list2.val) {
                tail.next=list1;
                list1=list1.next;
            } else {
                tail.next=list2;
                list2=list2.next;
            }
            tail=tail.next;
        }
        tail.next=list1==null?list2:list1;
        return head.next;
    }
}
