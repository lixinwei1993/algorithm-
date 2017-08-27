package offer;

import java.util.Deque;
import java.util.LinkedList;

public class Question19 {

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
	        printTree(root);
	        System.out.println();
	        mirrorTree(root);
	        printTree(root);
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
	        printTree(root2);
	        System.out.println();
	        mirrorTree(root2);
	        printTree(root2);

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
	        printTree(root3);
	        System.out.println();
	        mirrorTree(root3);
	        printTree(root3);


	}
	

	private static void mirrorTree(BinaryTreeNode root) {
		if(root == null)
			return;
		
		BinaryTreeNode temp = root.leftChild;
		root.leftChild = root.rightChild;
		root.rightChild = temp;
		
		mirrorTree(root.leftChild);
		mirrorTree(root.rightChild);
	}
	
	private static void mirrorTreeLoop(BinaryTreeNode root) {
		if(root == null)
			return;
		
		Deque<BinaryTreeNode> stack = new LinkedList<>();
		
	}
	
	 public static void printTree(BinaryTreeNode node) {
	        if (node != null) {
	            printTree(node.leftChild);
	            System.out.print(node.value + " ");
	            printTree(node.rightChild);
	        }
	    }

}
