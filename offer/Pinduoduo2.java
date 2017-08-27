package offer;

import java.util.Deque;
import java.util.LinkedList;

public class Pinduoduo2 {
	
	public static void main(String[] args) {
		int[][] arr = {
				{1, 2, 3, 4 ,5},
				{1, 2, 3, 4 ,5},
				{1, 2, 3, 4 ,5},
				{1, 2, 3, 4 ,5},
				{1, 2, 3, 4 ,5}
		};
		
		int minFirst = arr[0][0];
		for(int i = 0; i < 5; i++) {
			if(arr[i][0] < minFirst)
				minFirst = arr[i][0];
		}
		
		int[] bigger = new int[5];
		for(int i = 0; i < 5; i++) {
			bigger[i] = minFirst;
			for(int j = 0; j < 5; j++) {
				if(arr[i][j] > minFirst)
					bigger[i] = arr[i][j];
			}
		}
		
		int max = bigger[0];
		for(int i = 0; i < 5; i++) {
			if(bigger[i] < max)
				max = bigger[i];
		}
		
		System.out.println("[" + minFirst + ", " + max + "]");
	}
	
}
