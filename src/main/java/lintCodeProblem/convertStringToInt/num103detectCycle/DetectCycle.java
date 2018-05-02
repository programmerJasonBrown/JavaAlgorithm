package lintCodeProblem.convertStringToInt.num103detectCycle;

import lintCodeProblem.convertStringToInt.num102hasCycle.ListNode;

public class DetectCycle {

    /*O(n^2)*/
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }
        if (fast == null || fast.next == null)
            return null;
        ListNode temp = head;

        while (temp != null) {
            do {
                if (temp == fast)
                    return temp;
                fast = fast.next;
            } while (fast != slow);
            temp = temp.next;
            fast = slow;
        }
        return null;
    }

    /*思想： 若无环 返回null，若有环则将环拆开转化为求第一个公共节点
     * */
    public ListNode detectCycleO_n(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
                break;
        }
        if (fast == null || fast.next == null) {
            //若无环
            return null;
        }
        ListNode nodeA = head;
        ListNode nodeB = fast.next;
        fast.next = null;  //拆开环
        ListNode endA = nodeA;
        ListNode endB = nodeB;
        int lenA = 0, lenB = 0;
        while (endA != null) {
            endA = endA.next;
            lenA++;
        }
        while (endB != null) {
            endB = endB.next;
            lenB++;
        }
        if (lenA >= lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                nodeA = nodeA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                nodeB = nodeB.next;
            }
        }
        while (nodeA != null) {
            if (nodeA == nodeB)
                return nodeA;
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return null;
    }
}

