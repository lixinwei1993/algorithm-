package offer;

public class Question24 {
	public static void main(String[] args) {
        //           10
        //         /   \
        //        6     14
        //       /\     /\
        //      4  8  12  16
        int[] data = {4, 8, 6, 12, 16, 14, 10};
        System.out.println("true: " + verifySequenceOfBST(data));

        //           5
        //          / \
        //         4   7
        //            /
        //           6
        int[] data2 = {4, 6, 7, 5};
        System.out.println("true: " + verifySequenceOfBST(data2));

        //               5
        //              /
        //             4
        //            /
        //           3
        //          /
        //         2
        //        /
        //       1
        int[] data3 = {1, 2, 3, 4, 5};
        System.out.println("true: " + verifySequenceOfBST(data3));

        // 1
        //  \
        //   2
        //    \
        //     3
        //      \
        //       4
        //        \
        //         5
        int[] data4 = {5, 4, 3, 2, 1};
        System.out.println("true: " + verifySequenceOfBST(data4));

        // 树中只有1个结点
        int[] data5 = {5};
        System.out.println("true: " + verifySequenceOfBST(data5));

        int[] data6 = {7, 4, 6, 5};
        System.out.println("false: " + verifySequenceOfBST(data6));

        int[] data7 = {4, 6, 12, 8, 16, 14, 10};
        System.out.println("false: " + verifySequenceOfBST(data7));
    }
	
	public static boolean verifySequenceOfBST(int[] arr) {
		if(arr == null)
			return false;
		
		return isPostTravel(arr, 0, arr.length - 1);
	}

	public static boolean isPostTravel(int[] arr, int start, int end) {
		if(start >= end)
			return true;
		
		int rightEndIndex = start;
		int root = arr[end];
		
		while(arr[rightEndIndex] < root && rightEndIndex < end - 1) {
			rightEndIndex++;
		}
		
		for(int i = rightEndIndex; i < end - 1; i++) {
			if(arr[i] < root)
				return false;
		}
		
		return isPostTravel(arr, start, rightEndIndex - 1)
				&& isPostTravel(arr, rightEndIndex, end - 1);
		
	}
}

