package offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 输入两颗二叉树A和B，判断B是不是A的子结构
 * @author welding
 *
 */
public class Question18 {
	
	 public static void main(String[] args) {
	        BinaryTreeNode root1 = new BinaryTreeNode();
	        root1.value = 8;
	        root1.rightChild = new BinaryTreeNode();
	        root1.rightChild.value = 7;
	        root1.leftChild = new BinaryTreeNode();
	        root1.leftChild.value = 8;
	        root1.leftChild.leftChild = new BinaryTreeNode();
	        root1.leftChild.leftChild.value = 9;
	        root1.leftChild.rightChild = new BinaryTreeNode();
	        root1.leftChild.rightChild.value = 2;
	        root1.leftChild.rightChild.leftChild = new BinaryTreeNode();
	        root1.leftChild.rightChild.leftChild.leftChild = new BinaryTreeNode();
	        root1.leftChild.rightChild.leftChild.leftChild.value = 4;
	        root1.leftChild.rightChild.leftChild.rightChild = new BinaryTreeNode();
	        root1.leftChild.rightChild.leftChild.rightChild.value = 7;

	        BinaryTreeNode root2 = new BinaryTreeNode();
	        root2.value = 8;
	        root2.leftChild = new BinaryTreeNode();
	        root2.leftChild.value = 9;
	        root2.rightChild = new BinaryTreeNode();
	        root2.rightChild.value = 2;

	        System.out.println(isSubTree(root1, root2));
	        System.out.println(isSubTree(root2, root1));
	        System.out.println(isSubTree(root1, root1.leftChild));
	        System.out.println(isSubTree(root1, null));
	        System.out.println(isSubTree(null, root2));
	        System.out.println(isSubTree(null, null));
	 }

	private static boolean isSubTree(BinaryTreeNode rootA, BinaryTreeNode rootB) {
		
		boolean result = false;
		
		if(rootA != null && rootB != null) {
			if(rootA.value == rootB.value)
				result = isSame(rootA, rootB);
			if(!result)
				result = isSubTree(rootA.leftChild, rootB);
			if(!result)
				result = isSubTree(rootA.rightChild, rootB);
		}
		
		return result;
		
		/*if(rootB == null)
			return true;
		if(rootA == null)
			return false;
		
		//这里其实没有必要使用BFS，同样使用递归的中前后中的一种遍历就可以了,看上面的解法，怎一个优雅了得
		Deque<BinaryTreeNode> queue = new LinkedList<>();
		queue.addLast(rootA);
		while(!queue.isEmpty()) {
			BinaryTreeNode temp = queue.removeFirst();
			if(temp.value == rootB.value && isSame(temp, rootB)) {
				return true;
			}
			
			if(temp.leftChild != null)
				queue.addLast(temp.leftChild);
			
			if(temp.rightChild != null)
				queue.addLast(temp.rightChild);
		}
		
		return false;*/
	}
	
	private static boolean isSame(BinaryTreeNode rootA, BinaryTreeNode rootB) {
		if(rootB == null)
			return true;
		if(rootA == null)
			return false;
		
		return rootA.value == rootB.value && isSame(rootA.leftChild, rootB.leftChild)
				&& isSame(rootA.rightChild, rootB.rightChild);
	}
}
