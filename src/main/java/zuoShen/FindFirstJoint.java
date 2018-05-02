package zuoShen;

public class FindFirstJoint {
    static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static Node findFirstJoint(Node head1, Node head2) {
        if (head1 == null || head2 == null)
            return null;
        Node loop1 = findLoop(head1);
        Node loop2 = findLoop(head2);
        if (loop1 == null && loop2 == null)
            return noLoop(head1, head2);
        if (loop1 != null && loop2 != null)
            return hasLoop(head1, loop1, head2, loop2);

        return null;
    }

    private static Node findLoop(Node head) {
//        有环则返回第一个入环点，无环则返回null;
        Node fastP = head.next.next;
        Node slowP = head.next;
        while(fastP!=slowP){
            if (fastP.next == null || fastP.next.next == null)
                return null;
            fastP = fastP.next.next;
            slowP = slowP.next;
        }
        fastP = head;
        while (fastP!=slowP){
            fastP = fastP.next;
            slowP = slowP.next;
        }
        return fastP;
    }

    public static Node noLoop(Node head1, Node head2) {
//        返回两个无环单链表第一个相交点
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1 != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            n--;
            cur2 = cur2.next;
        }
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        while (n != 0) {
            cur1 = cur1.next;
            n--;
        }
        while (cur1 != null) {
            if (cur1 == cur2)
                return cur1;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return null;
    }

    private static Node hasLoop(Node head1, Node loop1, Node head2, Node loop2) {
//        返回两个有环单链表的第一个相交点。 有三种有环结构
        if (loop1 == loop2) {
//            共享一个环 且入环点是同一个
            return loop1;
        } else {
            Node cur = loop2.next;
            while (cur != loop2) {
                if (loop1 == cur) {
//                    共享一个环，只是入环点不一样
                    return loop1;
                }
            }
//           不共享一个环
            return loop2;

        }
    }
}
