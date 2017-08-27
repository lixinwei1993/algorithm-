package leetCode;

/**
 * Question

You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is 
that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
Example
Given [3, 8, 4], return 8.
Challenge
O(n) time and O(1) memory.
 * @author welding
 *
 *重点：状态，转移方程，初始化，结束，空间优化（其实计算机上任何问题都是这个流程，只不过根据状态转移方程的特点可选择动态规划，递归，回溯，贪心等算法
 */
public class HouseRobber {
	
	public static void main(String[] args) {
		int[] arr = {3, 8, 4, 10, 1};
		System.out.println(houseRobberRecurisively(arr));
	}
	
	//DP Solution（一维序列型动态规划） with O(n) space, O(n) time
	public static int houseRobberDP(int[] arr) {
		if(arr == null || arr.length == 0)
			return 0;
		
		//Define DP state, dp[i] 表示前i个房子中,偷到的最大价值
		int[] dp = new int[arr.length + 1];
		
		//initialize dp
		dp[0] = 0;
		dp[1] = arr[0];
		
		for(int i = 2; i <= dp.length; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i - 1]);
		}
		
		return dp[dp.length - 1];
	}
	
	/**
	 * 由于每一个状态至于前两个状态有关，因此没有必要保存之前所有哦的状态，通过滚动数组优化可以将空间复杂度缩减为O(1)
	 * dp[i%2] = Math.max(dp[(i-1)%2], dp[(i-2)%2] + A[i-1]);
	 * @param arr
	 * @return
	 */
	public static int houseRobberDPRefact(int[] arr) {
		if(arr == null || arr.length == 0)
			return 0;
		
		int[] dp = new int[2];
		
		dp[0] = 0;
		dp[1] = arr[0];
		
		for(int i = 2; i <= arr.length; i++) {
			dp[i%2] = Math.max(dp[(i - 1) % 2], dp[(i - 2) % 2] + arr[i - 1]);
		}
		
		return dp[arr.length % 2];
	}
	
	public static int houseRobberRecurisively(int[] arr) {
		if(arr == null)
			throw new RuntimeException("the array can not be null");
		
		return houseRobber(arr, arr.length);
	}
	
	public static int houseRobber(int[] arr, int size) {
		if(size == 1)
			return arr[0];
		if(size == 2)
			return Math.max(arr[0], arr[1]);
		
		return Math.max(houseRobber(arr, size - 1), houseRobber(arr, size - 2) + arr[size - 1]);
	}
}
