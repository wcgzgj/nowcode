package must.ques;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName CC18_cloneGraph
 * @Description TODO
 * @Author faro_z
 * @Date 2021/10/25 1:49 下午
 * @Version 1.0
 **/
public class CC18_cloneGraph {

    public static void main(String[] args) {
//        {0,1,2#1,2#2,2}.
        UndirectedGraphNode n0 = new UndirectedGraphNode(0);
        UndirectedGraphNode n1 = new UndirectedGraphNode(1);
        UndirectedGraphNode n2 = new UndirectedGraphNode(2);

        n0.neighbors.add(n1);
        n0.neighbors.add(n2);

        n1.neighbors.add(n2);

        // 这里就会出现循环调用 <-- aurora prime 中也出现过类似的问题
        n2.neighbors.add(n2);

        CC18_cloneGraph solu = new CC18_cloneGraph();
        solu.cloneGraph(n0);
    }

    // 这种单纯的 dfs 解法有一个致命的问题，那就是会出现重复新建对象的问题
    //public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    //    UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
    //    if (node.neighbors.size()==0) return newNode;
    //    for (UndirectedGraphNode neighbor : node.neighbors) {
    //        if (node==neighbor) continue;
    //        UndirectedGraphNode newNeighbor = cloneGraph(neighbor);
    //        if (newNeighbor!=null) newNode.neighbors.add(newNeighbor);
    //    }
    //    return newNode;
    //}

    // 我们需要使用 map 存储源对象和新对象的关系，来判断该对象之前有没有被新建过
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node ==null) return null;
        // key: 原图节点对象
        // value: 新图节点对象
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        return dfs(map,node);
    }

    public UndirectedGraphNode dfs(Map<UndirectedGraphNode, UndirectedGraphNode> map,UndirectedGraphNode node) {

        UndirectedGraphNode newNode = null;
        if (map.get(node)==null) {
             newNode = new UndirectedGraphNode(node.label);
             map.put(node,newNode);
        } else {
            newNode = map.get(node);
        }
        if (node.neighbors.size()>0) {
            for (UndirectedGraphNode neighbor : node.neighbors) {
                if (map.get(neighbor)==null) {
                    // 有的话，直接从 map 取出，避免重复创建对象
                    // 无则创建，并且别忘了再放回 map
                    UndirectedGraphNode newNeighbor = new UndirectedGraphNode(node.label);
                    // 注：这里可能会出现循环引用问题 2->2
                    map.put(neighbor,newNeighbor);
                }
                if (newNode.label!= neighbor.label) dfs(map,neighbor);
                newNode.neighbors.add(map.get(neighbor));
            }
        }
        return newNode;
    }
}


class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }

    @Override
    public String toString() {
        return "UndirectedGraphNode{" +
                "label=" + label +
                '}';
    }
};

