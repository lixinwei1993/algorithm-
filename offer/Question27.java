package offer;

/**
 * 这道题有必要再体会一下，递归专项练习，对递归、分解等应加强
 * @author welding
 *
 */
public class Question27 {

	
	public static BinaryTreeNode convert(BinaryTreeNode root) {
		BinaryTreeNode lastNodeInList = null;
		convertNode(root, lastNodeInList);
		
		BinaryTreeNode headOfList = lastNodeInList;
		while(headOfList != null && headOfList.leftChild != null)
			headOfList = headOfList.leftChild;
		
		return headOfList;
	}

	public static void convertNode(BinaryTreeNode root, BinaryTreeNode lastNodeInList) {
		if(root == null)
			return;
		
		BinaryTreeNode current = root;
		
		if(root.leftChild != null)
			convertNode(current.leftChild, lastNodeInList);
		
		current.leftChild = lastNodeInList;
		
		if(lastNodeInList != null) {
			lastNodeInList.rightChild = current;
		}
		
		lastNodeInList = current;
		if(current.rightChild != null)
			convertNode(current.rightChild, lastNodeInList);
	}
}
