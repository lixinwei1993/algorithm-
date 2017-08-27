package offer;

import java.util.Arrays;

public class Question31 {	
	public static void main(String[] args) {
		int[] arr = {1, 2, -3, -1};
		
		System.out.print(maxSubArray(arr));
	}
	
	public static int maxSubArray(int[] arr) {
		int len = arr.length;
		int[] dp = new int[len];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		maxSubArray(arr, len - 1, dp);
		
		
		int max = dp[0];
		for(int i : dp) {
			if(max < i)
				max = i;
		}
		return max;
	}
	
	private static int maxSubArray(int[] arr, int end, int[] dp) {
		if(dp[end] < Integer.MAX_VALUE)
			return dp[end];
		
		if(end == 0) {
			dp[end] = arr[end];
			return dp[end];
		}
		
		
		
		return dp[end] = Math.max(arr[end], maxSubArray(arr, end - 1, dp) + arr[end]);	
	}
}
