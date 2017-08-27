package offer;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
	public int run(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int count = 0;
        while(!queue.isEmpty()) {
            
            TreeNode temp = queue.removeFirst();
            
            if(temp.left == null && temp.right == null)
                return count;
            
            if(temp.left != null)
                queue.addLast(temp.left);
            if(temp.right != null)
                queue.addLast(temp.right);
            count++;
        }
    }
	
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
