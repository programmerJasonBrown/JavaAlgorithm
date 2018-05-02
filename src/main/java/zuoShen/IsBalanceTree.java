package zuoShen;

public class IsBalanceTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    static class ResultData {
        boolean isBalanced;
        int h;

        ResultData(boolean isBalanced, int h) {
            this.isBalanced = isBalanced;
            this.h = h;
        }
    }

    public static Boolean isBT(Node head) {
        if (head == null)
            return true;
        return isBTActualize(head).isBalanced;
    }

    public static ResultData isBTActualize(Node head) {
        if (head == null)
            return new ResultData(true, 0);
        ResultData resultLeftData = isBTActualize(head.left);
        if (!resultLeftData.isBalanced)
            return new ResultData(false, 0);
        ResultData resultRightData = isBTActualize(head.right);
        if (!resultRightData.isBalanced)
            return new ResultData(false, 0);
        if (Math.abs(resultLeftData.h-resultRightData.h)>1){
            return new ResultData(false,0);
        }
        return new ResultData(true, Math.max(resultLeftData.h, resultRightData.h) + 1);

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
       // head.right.left = new Node(6);
       // head.right.right = new Node(7);

        System.out.println(isBT(head));
    }
}
