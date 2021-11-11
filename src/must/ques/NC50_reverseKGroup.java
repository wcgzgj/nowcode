package must.ques;

import must.domain.ListNode;

/**
 * @ClassName NC50_reverseKGroup
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/11 11:00 上午
 * @Version 1.0
 **/
public class NC50_reverseKGroup {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        NC50_reverseKGroup solu = new NC50_reverseKGroup();
        outList(n1);
        ListNode head = solu.reverseKGroup(n1, 3);
        outList(head);
    }

    public static void outList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head!=null) {
            sb.append(head.val).append(" -> ");
            head=head.next;
        }
        System.out.println(sb.toString());
    }

    public ListNode reverseKGroup (ListNode head, int k) {
        ListNode hair = new ListNode(-1);
        hair.next=head;
        ListNode pre = hair;
        while (head!=null) {
            ListNode next = move(head, k);
            if (next==null && countNode(head)<k) break;
            ListNode[] pair = reverse(head, k);
            pre.next=pair[0];
            pair[1].next=next;
            pre=pair[1];
            head=pre==null?null:pre.next;
        }
        return hair.next;
    }

    // 反转+断尾操作，返回值是新的头和尾的引用
    private ListNode[] reverse(ListNode head,int k) {
        ListNode pre=null,curr=head;
        ListNode[] res = new ListNode[2];
        // 存储新的尾
        res[1]=head;
        while (curr!=null && k-->0) {
            ListNode tmp = curr.next;
            curr.next=pre;
            pre=curr;
            curr=tmp;
        }
        res[0]=pre;
        return res;
    }

    // 将当前节点向后移动 k 位，遇到空停止
    private ListNode move(ListNode head, int k) {
        if (head==null) return null;
        while (head!=null && k-->0) head=head.next;
        return head;
    }

    private int countNode(ListNode head) {
        int count=0;
        while (head!=null) {
            ++count;
            head=head.next;
        }
        return count;
    }
}
