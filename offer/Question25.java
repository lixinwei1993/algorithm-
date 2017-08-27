package offer;

import java.util.Deque;
import java.util.LinkedList;
/**
 * 本质上是回溯法，回溯法的常规做法还是要弄懂的，最简单最通用的算法！！
 * @author welding
 *
 */
public class Question25 {
	public static void findPath(BinaryTreeNode root, int expectedSum) {
		if(root == null)
			return;
		
		Deque<Integer> path = new LinkedList<>();
		int currentSum = 0;
		
		findPath(root, expectedSum, path, currentSum);
	}
	
	public static void findPath(BinaryTreeNode root, int expectedSum, Deque<Integer> path, int currentSum) {
		currentSum += root.value;
		path.push(root.value);
		
		boolean isLeaf = root.leftChild == null && root.rightChild == null;
		if(currentSum == expectedSum && isLeaf) {
			System.out.println("a path is found: ");
			
		}
		
		if(root.leftChild != null)
			findPath(root.leftChild, expectedSum, path, currentSum);
		if(root.rightChild != null)
			findPath(root.rightChild, expectedSum, path, currentSum);
		
		path.pop();
		
	}
}
