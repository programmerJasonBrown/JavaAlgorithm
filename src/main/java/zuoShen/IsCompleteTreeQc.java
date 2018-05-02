package zuoShen;

import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteTreeQc {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public boolean isCompleteTree(Node head) {
        boolean lastNodeIsLeaf = false;
        if (head == null)
            return false;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            if ((lastNodeIsLeaf && (head.left != null || head.right != null))
                    ||
                    head.left == null && head.right != null) {
                return false;
            }
            if (head.left != null)
                queue.add(head.left);
            if (head.right != null) {
                queue.add(head);
            } else {
                lastNodeIsLeaf = true;
            }
        }
        return true;
    }
}
