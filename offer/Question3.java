package offer;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下的顺序排序。
 * 给定上述这样的一个二维数组，并给定一个数判断数组中是否存在该数字；
 * @author welding
 *思路：从数组的又上角入手，逐步缩小范围。（之所以从右上角入手是因为右上角的判定结果可以直接减掉一行或一列
 *而如果从头即左上角开始的话左上角的判断结果并不能很好地帮助我们缩小范围
 */
public class Question3 {
	public static void main(String[] args) {
		int rows = 4, columns = 4;
		int[][] arr = {
				{1, 2, 8, 9},
				{2, 4, 9, 12},
				{4, 7, 10, 13},
				{6, 8, 11, 15}
		};
		
		System.out.println(find(arr, rows, columns, 5));
		System.out.println(find(arr, rows, columns, 9));
		System.out.println(find(arr, rows, columns, 6));
		System.out.println(find(arr, rows, columns, 1));
	}
	
	private static boolean find(int[][] arr, int rows, int columns, int val) {
		int i = 0;
		int j = columns - 1;
		while(i < rows && j >= 0) {
			if(arr[i][j] == val)
				return true;
			else if(arr[i][j] > val) 
				j--;
			else
				i++;
		}
		
		return false;
	}
}
