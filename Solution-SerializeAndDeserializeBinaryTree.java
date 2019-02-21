/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /*leetcode #297 Serialize and Deserialize Binary Tree
 **序列化及反序列化一棵树
 **其实就是树的BFS遍历
 **利用队列实现
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "[]";
        }
        List<String> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        String string = "[";
        queue.add(root);
        while(!queue.isEmpty()){
        	TreeNode node = queue.poll();
        	if(node != null){
        		queue.offer(node.left);
            	queue.offer(node.right);
        		result.add(String.valueOf(node.val));
        	}else{
        		result.add("null");
        	}
        	
        }
        int i = result.size()-1;
        while(result.get(i).equals("null")){
        	result.remove(i);
        	i--;
        }
        for(int j=0;j<result.size();j++){
        	if(j == result.size()-1){
        		string += result.get(j);
        	}else{
        		string += result.get(j)+",";
        	}
        }
        return string+"]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]")){
            return null;
        }
        data = data.substring(1,data.length()-1);
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int i=1;
        while(!queue.isEmpty()){
        	TreeNode node = queue.poll();
        	if(i<arr.length && !arr[i].equals("null")){
        		node.left = new TreeNode(Integer.parseInt(arr[i]));
        		queue.offer(node.left);
        	}
        	i++;
        	if(i<arr.length && !arr[i].equals("null")){
        		node.right = new TreeNode(Integer.parseInt(arr[i]));
        		queue.offer(node.right);
        	}
        	i++;
        }
        return root;
    }
}
