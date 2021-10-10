package must.ques;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName WC134_LRU
 * @Description TODO
 * @Author faro_z
 * @Date 2021/9/24 4:35 下午
 * @Version 1.0
 **/
public class WC134_LRU {

    public static void main(String[] args) {
        WC134_LRU lru = new WC134_LRU();
        lru.LRU(null,3);
        lru.set(1,1);
        lru.set(2,2);
        lru.set(3,3);
        System.out.println(lru);
        lru.get(2);
        System.out.println(lru);
        lru.set(4,4);
        System.out.println(lru);
    }

    private Map<Integer, Node> map = new HashMap<>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    private int k;

    public int[] LRU (int[][] operators, int k) {
        this.k=k;
        head.next=tail;
        tail.pre=head;
        ArrayList<Integer> res = new ArrayList<>();
        // 1 为 set 2 为 get
        for (int[] operator : operators) {
            if (operator[0]==1) {
                set(operator[1],operator[2]);
            } else {
                res.add(get(operator[1]));
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=res.get(i);
        }
        return arr;
    }

    public void set(int key,int val) {
        // 当前 key 已存在
        if (get(key)!=-1) {
            // 更新 value 值
            map.get(key).val=val;
        } else {
            // 超出空间，移除最不常用
            if (k==map.size()) {
                removeLastUse();
            }
            Node node = new Node(key, val);
            map.put(key,node);
            makeRecent(node);
        }
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node!=null) {
            node.pre.next=node.next;
            node.next.pre=node.pre;
            makeRecent(node);
            return node.val;
        }
        return -1;
    }

    // 去除最近不用的元素
    private void removeLastUse() {
        int rk = tail.pre.key;
        tail.pre.pre.next=tail;
        tail.pre=tail.pre.pre;
        map.remove(rk);
    }

    // 设置为最近访问
    private void makeRecent(Node node) {
        node.pre=head;
        node.next=head.next;
        head.next=node;
        node.next.pre=node;
    }

    private class Node {
        public int key;
        public int val;
        public Node next,pre;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public Node() {
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node tmpHead=head.next;
        while (tmpHead!=tail) {
            sb.append(tmpHead.val)
                    .append("->");
            tmpHead=tmpHead.next;
        }
        return sb.toString();
    }
}
