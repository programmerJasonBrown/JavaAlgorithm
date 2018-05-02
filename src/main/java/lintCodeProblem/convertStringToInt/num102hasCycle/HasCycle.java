package lintCodeProblem.convertStringToInt.num102hasCycle;

public class HasCycle {
    /*
     * 快慢指针的典型应用，使用块指针 fast 与慢指针 slow，slow每次后移一位，
     * fast 每次后移两位，当fast 与 slow 指向同一节点时，说明存在环。就如同操场跑圈时，领先一圈的人会遇上跑在他后面的人那样。
     *
     * 不用担心会遇不到。 假设当slow到达碰撞点时（位置设为0），fast的位置是0+a，环的长度是L
     * 设还需要x步fast和slow才能相遇
     * 0+x = (2x + a) mod L  =>   x = L - a
     *
     * */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
}
