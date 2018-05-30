package yuanjingAndkujiale;

public class CreatBalanceTree {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    public static Node creatBalanceTree(int[] arr) {
        return creatBalanceTree(arr, 0, arr.length - 1);
    }

    public static Node creatBalanceTree(int[] arr, int lo, int hi) {
        if (hi - lo == 2) {
//            三个数，形成平衡二叉排序树
            Node x = new Node(arr[lo + 1]);
            x.left = new Node(arr[lo]);
            x.right = new Node(arr[hi]);
            return x;
        }
        if (hi - lo == 1) {
//            2个数，形成平衡二叉排序树

            Node x = new Node(arr[lo]);
            x.left = new Node(arr[hi]);
            return x;
        }
        if (lo == hi) {
//            1个数，形成平衡二叉排序树

            return new Node(arr[lo]);
        }
        int mid = lo + (hi - lo) / 2;
        Node root = new Node(arr[mid]); //中点作为根节点
        root.left = creatBalanceTree(arr, lo, mid - 1); //用左半边数组做一个平衡二叉排序树
        root.right = creatBalanceTree(arr, mid + 1, hi);//用右半边数组做一个平衡二叉排序树
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        Node root = creatBalanceTree(arr);
        System.out.println();
    }
}
