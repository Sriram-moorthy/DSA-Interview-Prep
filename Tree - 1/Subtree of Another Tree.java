/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        if(isSymmetric(root, subRoot)) return true;
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);

    }
    private boolean isSymmetric(TreeNode leftTree, TreeNode rightTree){
        if(leftTree == null || rightTree == null) return leftTree == rightTree;
        if(leftTree.val != rightTree.val) return false;
        return isSymmetric(leftTree.left,rightTree.left) && isSymmetric(leftTree.right, rightTree.right);
    }
}
