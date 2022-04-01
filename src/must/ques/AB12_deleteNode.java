package must.ques;

import must.domain.ListNode;

/**
 * @ClassName AB12_deleteNode
 * @Description TODO
 * @Author faro_z
 * @Date 2022/4/1 4:32 下午
 * @Version 1.0
 **/
public class AB12_deleteNode {
    public static void main(String[] args) {

    }

    public ListNode deleteNode (ListNode head, int val) {
        if (head==null) return head;
        ListNode pre = null;
        ListNode curr = head;
        while (curr!=null && curr.val!=val) {
            pre = curr;
            curr=curr.next;
        }
        // 没找到要删除的节点
        if (curr==null) return head;
        // 要删除的是第一个节点
        if (pre==null) return curr.next;
        pre.next = curr.next;
        curr=null;
        return head;
    }

}
