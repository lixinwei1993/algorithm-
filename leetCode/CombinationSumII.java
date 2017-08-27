package leetCode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 Given a collection of candidate numbers (C) and a target number (T), 
 find all unique combinations in C where the candidate numbers sums to T.
 Each number in C may only be used once in the combination.
 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 A solution set is:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]
 */
public class CombinationSumII {
	public static Set<Set<Integer>> result = new HashSet<>();
	
	public static void main(String[] args) throws Exception
    {
        int[] arr = {1, 1, 2, 2};
        combinationSumII(arr, 8);
        for(Set<Integer> s : result) {
        	for(int i : s)
        		System.out.print(i + " ");
        	System.out.println();;
        }
    }

	
	public static void combinationSumII(int[] arr, int target) {
		Deque<Integer> path = new LinkedList<>();
		int currentSum = 0;
		combinationSumII(arr, 0, target, path, currentSum);
	}
	
	public static void combinationSumII(int[] arr, int begin, int target, Deque<Integer> path, int currentSum) {
		if(currentSum == target) {
			Set<Integer> set = new HashSet<>();
			//TODO 这里的解法有问题，set消去了一个组合中重复的元素，这显然是不对的
			set.addAll(path);
			result.add(set);
		}
		
		for(int i = begin; i < arr.length; i++) {
			if(currentSum + arr[i] <= target) {
				path.push(arr[i]);
				combinationSumII(arr, i + 1, target, path, currentSum + arr[i]);
				path.pop();
			}
		}
	}
}
