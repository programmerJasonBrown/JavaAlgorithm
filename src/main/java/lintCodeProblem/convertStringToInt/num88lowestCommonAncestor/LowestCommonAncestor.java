package lintCodeProblem.convertStringToInt.num88lowestCommonAncestor;

import lintCodeProblem.convertStringToInt.num480BinaryTreePath.TreeNode;

public class LowestCommonAncestor {

    /*
     * 判断AB 是否都在root的左边， 是则将root改为root.left，继续判断。
     * 判断AB 是否都在root的右边， 是则将root改为root.right，继续判断。
     * 若一个在做一个在右，则返回root
     * */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        boolean la = isUnderThisNode(root.left, A);
        boolean ra = isUnderThisNode(root.right, A);
        boolean lb = isUnderThisNode(root.left, B);
        boolean rb = isUnderThisNode(root.right, B);
        if (la && lb) {  //都在左边
            return lowestCommonAncestor(root.left, A, B);
        } else if (ra && rb) {
            return lowestCommonAncestor(root.right,A,B);
        } else {
            return root;
        }
    }

    private boolean isUnderThisNode(TreeNode root, TreeNode x) {
        if (root == null)
            return false;
        if (root == x)
            return true;
        else
            return isUnderThisNode(root.left, x) || isUnderThisNode(root.right, x);
    }
}
