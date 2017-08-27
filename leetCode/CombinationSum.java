package leetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 Given a set of candidate numbers (C) (without duplicates) and a target number (T), 
 find all unique combinations in C where the candidate numbers sums to T.
 The same repeated number may be chosen from C unlimited number of times.
 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:
 [
 [7],
 [2, 2, 3]
 ]
 */
public class CombinationSum {
	
	public static void main(String[] args) {
		int[] arr = {2, 3, 6, 1, 7};
		combinationSum(arr, 7);
	}

	public static void combinationSum(int[] arr, int target) {
		Deque<Integer> path = new LinkedList<>();
		int currentSum = 0;
		
		combinationSum(arr, 0, target, path, currentSum);
	}
	
	public static void combinationSum(int[] arr, int begin, int target, Deque<Integer> path, int currentSum) {
		if(currentSum == target) {
			for(int i : path) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
		for(int i = begin; i < arr.length; i++) {
			if(currentSum + arr[i] <= target) {
				path.push(arr[i]);
				combinationSum(arr, i, target, path, currentSum + arr[i]);
				path.pop();
			}
				
		}
	}
	
}
