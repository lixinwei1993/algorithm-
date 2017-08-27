package leetCode;

import java.util.Deque;
import java.util.LinkedList;

public class Combinations {
	/**
	 *
	 Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
	 For example,
	 If n = 4 and k = 2, a solution is:
	 [
	 [2,4],
	 [3,4],
	 [2,3],
	 [1,2],
	 [1,3],
	 [1,4],
	 ]
	 */
	public static void main(String[] args) {
		combinations(4, 2);
	}
	public static void combinations(int n, int k) {
		Deque<Integer> path = new LinkedList<>();
		
		combinations(n, k, path);
	}
	
	public static void combinations(int n, int k, Deque<Integer> path) {
		if(path.size() == k) {
			for(int i : path)
				System.out.print(i + " ");
			System.out.println();
		}
		
		for(int i = 1; i < k; i++) {
			if(path.size() < 2) {
				path.push(i);
				combinations(i + 1, k, path);
				path.pop();
			}
		}
	}
}
