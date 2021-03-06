package must.ques;

import must.domain.ListNode;

/**
 * @ClassName NC66_FindFirstCommonNode
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/15 12:46 下午
 * @Version 1.0
 **/
public class NC66_FindFirstCommonNode {
    public static void main(String[] args) {

    }

    // 方法1：统计链表长度，让长的那个先走完差值
    //public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    //    int len1 = countListLength(pHead1);
    //    int len2 = countListLength(pHead2);
    //    int len = Math.abs(len1 - len2);
    //    ListNode[] nodes = new ListNode[2];
    //    if (len1>=len2) {
    //        nodes[0]=pHead1;
    //        nodes[1]=pHead2;
    //    } else {
    //        nodes[0]=pHead2;
    //        nodes[1]=pHead1;
    //    }
    //    ListNode longHead = nodes[0];
    //    ListNode shortHead = nodes[1];
    //    while (len-->0) {
    //        longHead=longHead.next;
    //    }
    //    while (longHead!=null) {
    //        if (longHead==shortHead) return longHead;
    //        longHead=longHead.next;
    //        shortHead=shortHead.next;
    //    }
    //    return null;
    //}
    //
    //private int countListLength(ListNode head) {
    //    if (head==null) return 0;
    //    int count=0;
    //    while (head!=null) {
    //        ++count;
    //        head=head.next;
    //    }
    //    return count;
    //}



    // 相互补上两个链表的长度，让二者的长度一致
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode ta = pHead1;
        ListNode tb = pHead2;
        while (ta!=tb) {
            ta=ta==null?pHead2:ta.next;
            tb=tb==null?pHead1:tb.next;
        }
        return ta;
    }
}
