/*leetcode #199 Binary Tree Right Side View*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 class Solution{
	int maxLvl;
	List<Integer> result = new ArrayList<Integer>();
	public List<Integer> rightSideView(TreeNode root){
		rightView(root,1);
		return result;
	}
	
	public void rightView(TreeNode root,int lvl){
		if(root == null){
			return;
		}
		if(lvl>maxLvl){
			result.add(root.val);
			maxLvl = lvl;
		}
		rightView(root.right,lvl+1);
		rightView(root.left,lvl+1);
	}
 }