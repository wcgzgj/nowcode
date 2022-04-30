package must.ques;

import must.domain.ListNode;

import java.util.List;

/**
 * @ClassName BM14_oddEvenList
 * @Description TODO
 * @Author faro_z
 * @Date 2022/4/30 3:10 下午
 * @Version 1.0
 **/
public class BM14_oddEvenList {
    public static void main(String[] args) {

    }

    /**
     * 链表的奇偶重排
     * 设置两个节点，一奇一偶
     * 获取成功之后再将两个节点合并
     * @param head
     * @return
     */
    public ListNode oddEvenList (ListNode head) {
        ListNode oddHead = new ListNode();
        ListNode evenHead = new ListNode();
        ListNode oddTail = oddHead;
        ListNode evenTail = evenHead;
        boolean isOdd = true;
        while (head!=null) {
            ListNode curr = head;
            head = head.next;
            curr.next=null;
            if (isOdd) {
                oddTail.next=curr;
                oddTail=oddTail.next;
            } else {
                evenTail.next=curr;
                evenTail=evenTail.next;
            }
            isOdd = !isOdd;
        }
        oddTail.next=evenHead.next;
        return oddHead.next;
    }

}
