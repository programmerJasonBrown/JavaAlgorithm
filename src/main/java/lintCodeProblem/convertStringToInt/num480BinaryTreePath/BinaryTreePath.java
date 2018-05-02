package lintCodeProblem.convertStringToInt.num480BinaryTreePath;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if (root == null)
            return list;
        addPathTolist(list, root, Integer.toString(root.val));
        return list;
    }

    public void addPathTolist(List<String> list, TreeNode root, String s) {
        if (root.left == null && root.right == null)
            list.add(s);
        if (root.left != null) {
            addPathTolist(list, root.left, s + "->" + Integer.toString(root.left.val));
        }
        if (root.right != null) {
            addPathTolist(list, root.right, s + "->" + Integer.toString(root.right.val));
        }
    }
}
