package test;

import must.domain.ListNode;
import must.util.LinkedListUtil;

/**
 * @ClassName LinkedListUtilTest
 * @Description TODO
 * @Author faro_z
 * @Date 2022/4/30 3:58 下午
 * @Version 1.0
 **/
public class LinkedListUtilTest {
    public static void main(String[] args) {
        ListNode list = LinkedListUtil.buildLinkedList(1, 1, 4, 5, 1, 4);
        LinkedListUtil.outputList(list);
    }
}
