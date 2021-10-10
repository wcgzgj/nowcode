package must.ques;

import must.domain.ListNode;

/**
 * @ClassName WC135_addInList
 * @Description TODO
 * @Author faro_z
 * @Date 2021/9/24 6:29 下午
 * @Version 1.0
 **/
public class WC135_addInList {

    public static void main(String[] args) {
        WC135_addInList wc135_addInList = new WC135_addInList();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next=n2;
        n2.next=n3;

        //n1 = wc135_addInList.reverse(n1);
        //while (n1!=null) {
        //    System.out.println(n1.val);
        //    n1=n1.next;
        //}

        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n4.next=n5;


        ListNode head = wc135_addInList.addInList(n1, n4);
        while (head!=null) {
            System.out.print(head.val+"   ");
            head=head.next;
        }

    }

    public ListNode addInList (ListNode head1, ListNode head2) {
        head1 = reverse(head1);
        head2 = reverse(head2);
        // 保存溢出位
        int cache = 0;
        ListNode head = new ListNode();
        ListNode tail = head;
        while (head1!=null && head2!=null) {
            int sum = head1.val + head2.val + cache;
            cache=sum/10;
            ListNode node = new ListNode();
            node.val=sum%10;
            // 尾插
            tail.next=node;
            tail=tail.next;
            head1=head1.next;
            head2=head2.next;
        }
        while (head1!=null) {
            int sum = head1.val + cache;
            cache=sum/10;
            ListNode node = new ListNode();
            node.val=sum%10;
            // 尾插
            tail.next=node;
            tail=tail.next;
            head1=head1.next;
        }
        while (head2!=null) {
            int sum = head2.val + cache;
            cache=sum/10;
            ListNode node = new ListNode();
            node.val=sum%10;
            // 尾插
            tail.next=node;
            tail=tail.next;
            head2=head2.next;
        }
        if (cache!=0) {
            ListNode node = new ListNode();
            node.val=cache;
            // 尾插
            tail.next=node;
            tail=tail.next;
        }
        ListNode tmp = head.next;
        head.next=null;
        return reverse(tmp);
    }

    public ListNode reverse(ListNode head) {
        ListNode pre=null,curr=head;
        while (curr!=null) {
            ListNode tmp = curr.next;
            curr.next=pre;
            pre=curr;
            curr=tmp;
        }
        return pre;
    }
}
