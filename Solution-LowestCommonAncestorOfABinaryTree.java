/*leetcode #236 Lowest Common Ancestor of a Binary Tree
**最近公共祖先问题
**三种情况，pq均在公共祖先左侧，pq在公共祖先两侧，pq在公共祖先右侧
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p) return p;
        if(root == q) return q;
    
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
    
        if(left != null && right != null) return root;
        return left != null ? left : right;
    }
}