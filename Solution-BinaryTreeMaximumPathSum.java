/*leetcode #124 Binary Tree Maximum Path Sum
**注意：路径要求不能有分叉，即可以一次遍历完路径中包含的所有节点
**动态规划
*/
class Solution {
	int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getSum(root);
        return sum;
    }
    
    public int getSum(TreeNode node){
        if(node == null){
            return 0;
        }
        int lsum = getSum(node.left);
        int rsum = getSum(node.right);
        int val = node.val;
        if(lsum > 0){
            val += lsum;
        }
        if(rsum > 0){
            val += rsum;
        }
        if(val > sum){
            sum = val;
        }
        return Math.max(node.val,Math.max(lsum+node.val,rsum+node.val));
    }
}