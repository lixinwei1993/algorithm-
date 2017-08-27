package offer;

public class Question20 {
	 public static void main(String[] args) {
	        int[][] numbers = {
	                {1, 2, 3, 4, 5},
	                {16, 17, 18, 19, 6},
	                {15, 24, 25, 20, 7},
	                {14, 23, 22, 21, 8},
	                {13, 12, 11, 10, 9},
	        };
	        clockwisePrint(numbers, 0, 4, 0, 4);
	        System.out.println();

	        int[][] numbers2 = {
	                {1, 2, 3, 4, 5, 6, 7, 8},
	                {22, 23, 24, 25, 26, 27, 28, 9},
	                {21, 36, 37, 38, 39, 40, 29, 10},
	                {20, 35, 34, 33, 32, 31, 30, 11},
	                {19, 18, 17, 16, 15, 14, 13, 12},

	        };
	        clockwisePrint(numbers2, 0, 4, 0, 7);
	        System.out.println();

	}

	public static void clockwisePrint(int[][] matrix, int rowsStart, int rowsEnd, int columnsStart, int columnsEnd) {
		if(matrix == null || rowsStart > rowsEnd || columnsStart > columnsEnd)
			return;
		
		if(rowsStart == rowsEnd) {
			for(int i = columnsStart; i <= columnsEnd; i++) 
				System.out.println(matrix[rowsStart][i]);
			return;
		}
			
		if(columnsStart == columnsEnd) {
			for(int i = rowsStart; i <= rowsEnd; i++) {
				System.out.println(matrix[i][columnsEnd]);
			}
			return;
		}
		
		
		System.out.println("hello");
		for(int i = columnsStart; i <= columnsEnd; i++) {
			System.out.println(matrix[rowsStart][i]);
		}
		rowsStart++;
		for(int i = rowsStart; i <= rowsEnd; i++) {
			System.out.println(matrix[i][columnsEnd]);
		}
		columnsEnd--;
		for(int i = columnsEnd; i >= columnsStart; i--) {
			System.out.println(matrix[rowsEnd][i]);
		}
		rowsEnd--;
		for(int i = rowsEnd; i >= rowsStart; i--) {
			System.out.println(matrix[i][columnsStart]);
		}
		columnsStart++;
		
		clockwisePrint(matrix, rowsStart, rowsEnd, columnsStart, columnsEnd);
		
	}
}
