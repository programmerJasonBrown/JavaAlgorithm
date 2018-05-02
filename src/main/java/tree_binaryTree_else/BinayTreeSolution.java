package tree_binaryTree_else;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//前序遍历 先根节点在左节点再右节点。
public class BinayTreeSolution {
    static List<Integer> list = new ArrayList<Integer>();

    public static List<Integer> preorderTraversal(BinaryTree root) {
        if (root == null)
            return null;
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }

    public static List<Integer> inorderTraversal(BinaryTree root) {
        if (root == null)
            return null;
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }

    public static List<Integer> postorderTraversal(BinaryTree root) {
        // write your code here
        if (root == null) {
            return null;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }

    public List<List<Integer>> levelOrder(BinaryTree root) {
        //层次遍历
        List<List<Integer>> list_list = new ArrayList<List<Integer>>();
        if (root == null)
            return list_list;
        LinkedList<BinaryTree> queue = new LinkedList<BinaryTree>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            while (length > 0) {
                BinaryTree node = queue.poll();
                length--;
                list.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            list_list.add(list);
        }
        return list_list;
    }

    public List<List<Integer>> levelOrderBottom(BinaryTree root) {
        List<List<Integer>> list_list = new ArrayList<List<Integer>>();
        if (root == null)
            return list_list;
        Stack<BinaryTree> stackBinaryTree = new Stack<BinaryTree>();
        LinkedList<BinaryTree> queue = new LinkedList<BinaryTree>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            while (length > 0) {
                BinaryTree node = queue.poll();
                stackBinaryTree.push(node);
                length--;
                if (node.right != null)
                    queue.add(node.right);
                if (node.left != null)
                    queue.add(node.left);
            }
            //null是分层的标志
            if (queue.size() != 0)
                stackBinaryTree.push(null);
        }
        while (!stackBinaryTree.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();

            while (!stackBinaryTree.isEmpty() && stackBinaryTree.peek() != null) {
                list.add(stackBinaryTree.pop().val);
            }
            //将null放出去
            if (!stackBinaryTree.isEmpty())
                stackBinaryTree.pop();
            list_list.add(list);
        }
        return list_list;
    }

    public List<List<Integer>> zigzagLevelOrder(BinaryTree root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (root == null) {
            return lists;
        }
        LinkedList<BinaryTree> queue = new LinkedList<BinaryTree>();
        int flag = 1; //偶数先左后右，奇数先右后左
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();
            List<BinaryTree> list_tree = new ArrayList<BinaryTree>();

            int length = queue.size();
            while (length > 0) {
                BinaryTree node = queue.poll();
                list.add(node.val);
                list_tree.add(node);
                length--;
            }
            int list_length = list_tree.size()-1;
            while (list_length >= 0) {
                BinaryTree node = list_tree.get(list_length--);
                if (flag % 2 == 0) {
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                } else {
                    if (node.right != null)
                        queue.add(node.right);
                    if (node.left != null)
                        queue.add(node.left);
                }
            }
            flag++;
            lists.add(list);
        }
        return lists;
    }


    //给定一个二叉树，找出其最大深度。
    public int maxDepth(BinaryTree root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    //给定一个二叉树，找出其最小深度。
    public int minDepth(BinaryTree root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        //初始化树
        BinaryTree root = new BinaryTree(1);
        BinaryTree left = new BinaryTree(2);
        BinaryTree right = new BinaryTree(3);
        BinaryTree right2 = new BinaryTree(4);
        root.right = right;
        root.left = left;
        root.right.right = right2;
        BinayTreeSolution BinayTreeSolution = new BinayTreeSolution();

/*        List<Integer> list = BinayTreeSolution.inorderTraversal(root);
        for (Integer x : list) {
            System.out.println(x);
        }*/

        //System.out.println(BinayTreeSolution.minDepth(root));
        List<List<Integer>> lists = BinayTreeSolution.zigzagLevelOrder(root);

        System.out.println(lists);
    }
}
