package offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树层次遍历
 * @author welding
 *
 */
public class Question23 {
	
	 public static void main(String[] args) {

	        //       8
	        //    /    \
	        //   6     10
	        //  / \   / \
	        // 5   7 9  11
	        BinaryTreeNode root = new BinaryTreeNode();
	        root.value = 8;
	        root.leftChild = new BinaryTreeNode();
	        root.leftChild.value = 6;
	        root.leftChild.leftChild = new BinaryTreeNode();
	        root.leftChild.leftChild.value = 5;
	        root.leftChild.rightChild = new BinaryTreeNode();
	        root.leftChild.rightChild.value = 7;
	        root.rightChild = new BinaryTreeNode();
	        root.rightChild.value = 10;
	        root.rightChild.leftChild = new BinaryTreeNode();
	        root.rightChild.leftChild.value = 9;
	        root.rightChild.rightChild = new BinaryTreeNode();
	        root.rightChild.rightChild.value = 11;
	        treeTravelFromTopToBottom(root);

	        //         1
	        //        /
	        //       3
	        //      /
	        //     5
	        //    /
	        //   7
	        //  /
	        // 9
	        BinaryTreeNode root2 = new BinaryTreeNode();
	        root2.value = 1;
	        root2.leftChild = new BinaryTreeNode();
	        root2.leftChild.value = 3;
	        root2.leftChild.leftChild = new BinaryTreeNode();
	        root2.leftChild.leftChild.value = 5;
	        root2.leftChild.leftChild.leftChild = new BinaryTreeNode();
	        root2.leftChild.leftChild.leftChild.value = 7;
	        root2.leftChild.leftChild.leftChild.leftChild = new BinaryTreeNode();
	        root2.leftChild.leftChild.leftChild.leftChild.value = 9;
	        System.out.println("\n");
	        treeTravelFromTopToBottom(root2);

	        // 0
	        //  \
	        //   2
	        //    \
	        //     4
	        //      \
	        //       6
	        //        \
	        //         8
	        BinaryTreeNode root3 = new BinaryTreeNode();
	        root3.value = 0;
	        root3.rightChild = new BinaryTreeNode();
	        root3.rightChild.value = 2;
	        root3.rightChild.rightChild = new BinaryTreeNode();
	        root3.rightChild.rightChild.value = 4;
	        root3.rightChild.rightChild.rightChild = new BinaryTreeNode();
	        root3.rightChild.rightChild.rightChild.value = 6;
	        root3.rightChild.rightChild.rightChild.rightChild = new BinaryTreeNode();
	        root3.rightChild.rightChild.rightChild.rightChild.value = 8;
	        System.out.println("\n");
	        treeTravelFromTopToBottom(root3);

	        // 1
	        BinaryTreeNode root4 = new BinaryTreeNode();
	        root4.value = 1;
	        System.out.println("\n");
	        treeTravelFromTopToBottom(root4);

	        // null
	        System.out.println("\n");
	        treeTravelFromTopToBottom(null);

	    }

	public static void treeTravelFromTopToBottom(BinaryTreeNode root) {
		if(root == null)
			return;
		
		Deque<BinaryTreeNode> queue = new LinkedList<>();
		queue.addLast(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode node = queue.removeFirst();
			System.out.println(node.value + " ");
			if(node.leftChild != null)
				queue.addLast(node.leftChild);
			if(node.rightChild != null)
				queue.addLast(node.rightChild);
		}
	}
}
