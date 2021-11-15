package must.ques;

import must.domain.ListNode;

import java.util.List;

/**
 * @ClassName NC40_addInList
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/15 1:17 下午
 * @Version 1.0
 **/
public class NC40_addInList {
    public static void main(String[] args) {

    }

    public ListNode addInList (ListNode head1, ListNode head2) {
        head1=reverse(head1);
        head2=reverse(head2);
        ListNode hair = new ListNode(-1);
        ListNode tail = hair;
        int cache=0;
        while (!(head1==null && head2==null)) {
            int tmpVal = getNodeVal(head1) + getNodeVal(head2) + cache;
            cache=tmpVal/10;
            tail=tailInsert(tail,tmpVal%10);
            head1=getNextNode(head1);
            head2=getNextNode(head2);
        }
        if (cache!=0) {
            tailInsert(tail,cache);
        }
        return reverse(hair.next);
    }

    public ListNode tailInsert(ListNode tail,int val) {
        tail.next=new ListNode(val);
        tail=tail.next;
        return tail;
    }

    // 链表反转
    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode pre=null;
        while (curr!=null) {
            ListNode tmp = curr.next;
            curr.next=pre;
            pre=curr;
            curr=tmp;
        }
        return pre;
    }

    public int getNodeVal(ListNode node) {
        if (node==null) return 0;
        return node.val;
    }

    public ListNode getNextNode(ListNode head) {
        if (head==null) return null;
        return head.next;
    }
}
