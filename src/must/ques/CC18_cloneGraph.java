package must.ques;

import java.util.ArrayList;

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

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        if (node.neighbors.size()==0) return newNode;
        for (UndirectedGraphNode neighbor : node.neighbors) {
            if (node==neighbor) continue;
            UndirectedGraphNode newNeighbor = cloneGraph(neighbor);
            if (newNeighbor!=null) newNode.neighbors.add(newNeighbor);
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

