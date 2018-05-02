package zuoShen;

import java.util.Stack;

public class PrintBinaryTree {
     static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void inOrderUnRecur(Node head) {
        if (head == null)
            return;
        Stack<Node> stack = new Stack<Node>();
        stack.push(head);
        head = head.left;
        while (head != null || !stack.isEmpty()) {
            if (head != null) {
//                如果当前节点不空，压栈，将当前节点指向左子节点
                stack.push(head);
                head = head.left;
            } else {
//                当前节点为空，出栈并打印，将当前节点指向右子结点
                head = stack.pop();
                System.out.print(head.value + " ");
                head = head.right;
            }
        }
    }
    public static void postOrderUnRecur(Node head){

    }
    public static void inOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }


    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);
        System.out.println("==============recursive==============");
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.println("============unrecursive=============");
        inOrderUnRecur(head);
    }


}
