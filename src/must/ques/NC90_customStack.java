package must.ques;

import java.util.Arrays;

/**
 * @ClassName NC90_customStack
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/26 7:43 下午
 * @Version 1.0
 **/
public class NC90_customStack {
    public static void main(String[] args) {
        //int[] origin = {1,2,3,4};
        //int[] dist = new int[10];
        //System.arraycopy(origin,0,dist,0,origin.length);
        //System.out.println(Arrays.toString(dist));
        System.out.println((10>>1)+10);
    }

    // 存储元素的数组
    private int[]elems = new int[10];

    // 栈顶的位置
    private int top=-1;

    // 存储栈中最小的元素的值
    //private int min = Integer.MAX_VALUE;

    public void push(int node) {
        ensureCapacity();
        elems[++top]=node;
    }

    public void pop() {
        if (top>=0) {
            top--;
        }
    }

    // 返回栈顶元素
    public int top() {
        if (top<0) return -1;
        return elems[top];
    }

    public int min() {
        if (top<0) return -1;
        if (top==0) return elems[top];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= top; i++) {
            min=Math.min(min,elems[i]);
        }
        return min;
    }

    private void ensureCapacity() {
        if (top>=elems.length-1) {
            // 新的数组扩容 1.5 倍
            int[] newElems = new int[elems.length + (elems.length >> 1)];
            System.arraycopy(elems,0,newElems,0,elems.length);
            elems=newElems;
        }
    }
}
