package offer;


/**
 * 递归，由前序遍历确定根节点，根据根节点在中序遍历中确定左右字数的前序和中序数列，进行递归即可
 * @author welding
 *
 */
public class Question6 {
	public static void main(String[] args) {
		int[] preOrder =  {1, 2, 4, 7, 3, 5, 6, 8};
		int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
		
		TreeNode root = construct(preOrder, inOrder);
		inOrder(root);
	}
	
	private static TreeNode construct(int[] pre, int[] in) {
		if(pre == null || in == null || pre.length != in.length )
		{
			return null;
		}
		
		return constructCore(pre, 0, pre.length-1, in, 0, in.length-1);
	}
	
	private static TreeNode constructCore(int[] pre, int preS, int preE, int[] in, int inS, int inE) {
		if(preS > preE)
			return null;	//使用null作为递归的终止条件往往能使递归变得简单
		
		TreeNode root = new TreeNode();
		root.value = pre[preS];
		
		int pivot = 0; //the number of leftSubTree
		while(in[pivot + inS] != pre[preS] && pivot < inE - inS) {
			pivot++;
		}
		
		root.leftChild = constructCore(pre, preS+1, preS + pivot, in, inS, inS + pivot - 1);
		root.rightChild = constructCore(pre, preS + pivot + 1, preE, in, inS + pivot + 1, inE);
		
		return root;
	}
	
	private static void inOrder(TreeNode root) {
		if(root == null) {  //使用null作为递归终止条件往往能使递归变得简单
			return;
		}
		
		inOrder(root.leftChild);
		System.out.println(root.value);
		inOrder(root.rightChild);
	}
	
	private static class TreeNode {
		public int value;
		public TreeNode leftChild;
		public TreeNode rightChild;
	}
		
}
