package searchProblem;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int N;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return get(x.left, key);
        else if (cmp > 0)
            return get(x.right, key);
        else
            return x.value;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null)
            return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, value);
        else if (cmp > 0)
            x.right = put(x.right, key, value);
        else
            x.value = value;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null)
            return x;
        return min(x.left);
    }

    public Key floor(Key key) {   //小于等于key的最大键 向下取整
        Node x = floor(root, key);
        if (x == null)
            return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
//一定在左子树
            return floor(x.left, key);
        } else if (cmp > 0) {
//判断右子树中是否存在小于key键的值
            Node t = null;
            t = floor(x.right, key);
            if (t == null)
                return x;
            else
                return t;
        } else
            return x;
    }

    public Key ceiling(Key key) {   //大于等于key的键  向上取整
        Node x = ceiling(root, key);
        if (x == null)
            return null;
        return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)
            return x;
        else if (cmp > 0) {
//则大于等于key的最小值肯定在右子树中
            return ceiling(x.right, key);
        } else {
//则判断左子树中是否有大于等于key的键
            Node t = null;
            t = ceiling(x.left, key);
            if (t == null)
                return x;
            else
                return t;
        }
    }

    public Key select(int k) {  //返回排名为k的结点
        Node x = select(root, k);
        if (x == null)
            return null;
        return x.key;
    }

    /*
     * 排序为k 表示左边有k个元素。
     * 令t为根节点左边的元素数，
     * 若t大于k，表示排序在k的左边，递归
     * 若t小于k，表示排序在跟结点的右边 递归
     * */
    private Node select(Node x, int k) {
        if (x == null)
            return null;
        int t = size(x.left);
        if (t == k)
            return x;
        else if (t > k)
            return select(x.left, k);
        else
            return select(x.right, k - t - 1);
    }

    /*
     * 先于根节点比较，如果等于根节点则排序为根节点左边的结点数（不包括根节点）
     * 若大于根节点，则往右找，并且加上根节点左边的结点数+1（根节点）
     * 若小于根节点，则往左边找。
     * */
    public int rank(Key key) {    //返回key的排名
        return rank(root, key);
    }

    private int rank(Node x, Key key) {
        if (x == null) return 0;
        int cmp = key.compareTo(x);
        if (cmp == 0)
            return size(x.left);
        else if (cmp > 0)
            return size(x.left) + 1 + rank(x.right, key);
        else
            return rank(x.left, key);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    public Node deleteMin(Node x) {
        if (x == null)
            return null;
        if (x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMax() {
        root = deleteMax(root);
    }

    public Node deleteMax(Node x) {
        if (x == null)
            return null;
        if (x.right == null)
            return x.left;
        x.right = deleteMax(x.right);
        x.N = size(x.right) + size(x.left) + 1;
        return x;
    }

    public void delete(Key key) {
        delete(root, key);
    }

    public Node delete(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.left == null)
                return x.right;
            if (x.right == null)
                return x.left;
            Node t = min(x.right);
            t.right = deleteMin(x.right);
            t.left = x.left;
            x = t;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    private void orderShow(Node root) {
        if (root == null)
            return;
        orderShow(root.left);
        System.out.print(root.key.getKey() + " ");
        orderShow(root.right);
    }

    public void orderShow() {
        orderShow(root);
    }

    public Iterable<Key> rangeSearch(Key x, Key y) {
        //打印 树中 键大于x小于y的键
        Queue<Key> queue = new LinkedList<Key>();
        rangeSearch(root, queue, x, y);
        return queue;
    }
    private void rangeSearch(Node node, Queue<Key> queue, Key x, Key y) {
        if (node == null)
            return;
        int cmpLo = x.compareTo(node.key);
        int cmpHi = y.compareTo(node.key);
        if (cmpLo < 0)
            rangeSearch(node.left, queue, x, y);
        if (cmpLo <= 0 && cmpHi >= 0)
            queue.add(node.key);
        if (cmpHi > 0)
            rangeSearch(node.right, queue, x, y);
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.put(new Key('S'), new Value(0));
        bst.put(new Key('E'), new Value(1));
        bst.put(new Key('A'), new Value(2));
        bst.put(new Key('R'), new Value(3));
        bst.put(new Key('C'), new Value(4));
        bst.put(new Key('H'), new Value(5));
        bst.put(new Key('E'), new Value(6));
        bst.put(new Key('X'), new Value(7));
        bst.put(new Key('A'), new Value(8));
        bst.put(new Key('M'), new Value(9));
        bst.put(new Key('P'), new Value(10));
        bst.put(new Key('L'), new Value(11));

        for (Key x : bst.rangeSearch(new Key('A'),new Key('E'))) {
            System.out.print(x.getKey()+" ");
        }
        System.out.println();
        bst.orderShow();
        System.out.println();
    }
}



