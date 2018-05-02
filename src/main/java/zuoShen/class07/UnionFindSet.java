package zuoShen.class07;

import java.util.HashMap;
import java.util.List;

public class UnionFindSet {
    //    左边的node指向右边的node
    private HashMap<Node, Node> fatherMap;
    //    表示某个node下面一共挂着几个node
    private HashMap<Node, Integer> sizeMap;

    public static class Node {
        //    各种数据
    }

    public UnionFindSet(List<Node> nodes) {
        fatherMap.clear();
        sizeMap.clear();
        for (Node node : nodes) {
            fatherMap.put(node, node);
            sizeMap.put(node, 1);
        }
    }

    //    查询代表节点
    private Node findHead(Node node) {
        if (node == null)
            return null;
        Node father = fatherMap.get(node);
        if (father != node) {
            father = findHead(father);
        }
        fatherMap.put(node, father);
        return father;
    }

    //    判断是否在同一个集合中
    public boolean isSameSet(Node a, Node b) {
        return findHead(a) == findHead(b);
    }

    //    合并2个节点所在的集合
    public void union(Node a, Node b) {
        if (a == null || b == null)
            return;
        Node aHead = findHead(a);
        Node bHead = findHead(b);
        int aSetSize = sizeMap.get(a);
        int bSetSize = sizeMap.get(b);
        if (aSetSize!=bSetSize){
            if (aSetSize >= bSetSize) {
                fatherMap.put(bHead, aHead);
                sizeMap.put(aHead, aSetSize + bSetSize);
            } else {
                fatherMap.put(aHead, bHead);
                sizeMap.put(bHead, aSetSize + bSetSize);
            }
        }

    }
}
