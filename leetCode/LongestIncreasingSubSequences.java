package leetCode;

/**
 * 
 * @author welding
 *
 */
public class LongestIncreasingSubSequences {
	
	public static void main(String[] args) {
		int[][] matrix = {
				{1 ,2 ,3 ,4 ,5},
				 {16,17,24,23,6},
				 {15,18,25,22,7},
				 {14,19,20,21,8},
				 {13,12,11,10,9}
				
		};
		
		System.out.println(longestIncreasingContinuousSubsequenceII(matrix));
	}

	/**
	 * Question2

Give you an integer matrix (with row size n, column size m)，
find the longest increasing continuous subsequence in this matrix. 
(The definition of the longest increasing continuous subsequence here 
can start at any row or column and go up/down/right/left any direction).
Example
Given a matrix:
[
 [1 ,2 ,3 ,4 ,5],
 [16,17,24,23,6],
 [15,18,25,22,7],
 [14,19,20,21,8],
 [13,12,11,10,9]
]
return 25
	 */
	int[][] dp;
    int[][] flag;
    int M, N;

    int[] dx = new int[] {-1, 0, 1, 0};
    int[] dy = new int[] {0, -1, 0, 1};
    /**
     * @param A an integer matrix
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        M = A.length;
        N = A[0].length;
        dp = new int[M][N];
        flag = new int[M][N];

        int ans = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = search(i, j, A);
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans;
    }

    // Memorized search, recursive
    public int search(int x, int y, int[][] A) {
        if (flag[x][y] != 0) {
            return dp[x][y];
        }

        int ans = 1; // Initialize dp[x][y] = 1 if it's local min compare to 4 directions
        int nx, ny;
        for (int i = 0; i < dx.length; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (insideBoundary(nx, ny) && (A[x][y] > A[nx][ny])) {
                ans = Math.max(ans, search(nx, ny, A) + 1);
            }
        }

        flag[x][y] = 1;
        dp[x][y] = ans;

        return ans;
    }

    public boolean insideBoundary(int x, int y) {
        return (x >=0 && x < M && y >= 0 && y < N);
    }
	
	

	
	
	
	
	/**
	 * Question1
Give an integer array，find the longest increasing continuous subsequence in this array.
An increasing continuous subsequence:
Can be from right to left or from left to right. Indices of the integers in the subsequence should be continuous.
Notice
O(n) time and O(1) extra space.
Example
For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.
For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4
	 * @param arr
	 * @return
	 */
	public static int longestIncreasingContinuousSubsequence(int[] arr) {
		if(arr == null || arr.length == 0) {
			return 0;
		}
		
		int ans = 1;
		int n = arr.length;
		
		//from left to right
		int len = 1;
		for(int i = 1; i < n; i++) {
			if(arr[i] > arr[i  -1])
				len++;
			else
				len = 1;
			ans = Math.max(len, ans);
		}
		
	//from right to left
		len = 1;
		for(int i = n - 1; i > 0; i--) {
			if(arr[i - 1] > arr[i])
				len++;
			else
				len = 1;
			ans = Math.max(len, ans);
		}
		
		return ans;
	}
}

















