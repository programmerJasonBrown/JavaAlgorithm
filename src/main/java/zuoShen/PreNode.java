package zuoShen;

public class PreNode {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node findPreNode(Node node) {
        if (node == null)
            return null;
        if (node.left != null) {
//            如果该结点有左子树，则找到左子树中最右的一个节点
            return getMostRight(node.left);
        } else {
//            如果该节点没有左子树，则找到该结点所在子树 是其右子树的那个节点。
            Node p = node.parent;
            while(p!=null && p.right!=node){
                node = p;
                p = p.parent;
            }
            return p;
        }
    }

    private static Node getMostRight(Node node) {
        while(node.right!=null)
            node = node.right;
        return node;
    }

    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;

        System.out.println("中序遍历结果：1 2 3 4 5 6 7 8 9 10");

        Node test = head.left.left;
        System.out.println(test.value + " next: " + findPreNode(test));
        test = head.left.left.right;
        System.out.println(test.value + " next: " + findPreNode(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + findPreNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + findPreNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + findPreNode(test).value);
        test = head;
        System.out.println(test.value + " next: " + findPreNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + findPreNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + findPreNode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + findPreNode(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + findPreNode(test).value);
    }
}
