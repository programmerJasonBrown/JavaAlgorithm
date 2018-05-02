package jiaojiao;

public class SwapLinkedList {
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            next = null;
        }
    }

    public static Node swap(Node root) {
        if (root == null && root.next == null) return root;
        Node pre = root;
        Node cur = root.next;
        Node cNext = cur.next;

        pre.next = null;
        cur.next = pre;
        while (cNext != null) {
            pre = cur;
            cur = cNext;
            cNext = cur.next;
            cur.next = pre;
        }
        return cur;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root = swap(root);
        System.out.println();
    }
}
