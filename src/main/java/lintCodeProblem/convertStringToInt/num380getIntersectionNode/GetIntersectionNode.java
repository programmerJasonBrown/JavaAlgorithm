package lintCodeProblem.convertStringToInt.num380getIntersectionNode;

import lintCodeProblem.convertStringToInt.num102hasCycle.ListNode;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int lenA = 1;
        int lenB = 1;
        while (nodeA.next != null) {
            nodeA = nodeA.next;
            lenA++;
        }
        while (nodeB.next != null) {
            nodeB = nodeB.next;
            lenB++;
        }
        if (nodeA != nodeB)
            return null;
        nodeA = headA;
        nodeB = headB;
        if (lenA >= lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                nodeA = nodeA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                nodeB = nodeB.next;
            }
        }
        while(nodeA!=null){
            if (nodeA == nodeB)
                return nodeA;
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return null;
    }
}