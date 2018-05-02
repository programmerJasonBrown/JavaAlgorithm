package SwordToOffer.num11.num26;


import searchProblem.Key;
import searchProblem.Value;

public class HasSubTree {
    public static class Node {
        private Key key;
        private Value value;
        private Node left, right;

        public Node(Key key) {
            this.key = key;
            left = null;
            right = null;
        }
    }

    public boolean hasSubTree(Node rootA, Node rootB) {
        if (rootB == null)
            return true;
        if (rootA == null)
            return false;
        if (rootA.key.getKey() == rootB.key.getKey())
            if (doesTree1hasTree2(rootA, rootB))
                return true;
        if (hasSubTree(rootA.left, rootB))
            return true;
        if (hasSubTree(rootA.right, rootB))
            return true;
        return false;
    }

    private boolean doesTree1hasTree2(Node x, Node y) {
        if (y == null)
            return true;
        if (x == null)
            return false;
        if (y.key.getKey() != x.key.getKey())
            return false;
        return doesTree1hasTree2(x.left, y.left) && doesTree1hasTree2(x.right, y.right);
    }

    public static void main(String[] args) {
        Node rootA = new Node(new Key('8'));
        rootA.left = new Node(new Key('8'));
        rootA.left.left = new Node(new Key('9'));
        rootA.left.left.left = new Node(new Key('2'));
        rootA.left.left.left.left = new Node(new Key('8'));

        Node rootB = new Node(new Key('8'));
        rootB.left = new Node(new Key('9'));
        rootB.left.left = new Node(new Key('2'));

        HasSubTree subTree = new HasSubTree();
        System.out.println(subTree.hasSubTree(null, null));
    }
}
