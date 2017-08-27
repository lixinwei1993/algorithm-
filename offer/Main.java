package offer;

import java.util.*;

public class Main {

    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	int[] arr = new int[n];
    	for(int i = 0; i < n; i++) {
    		arr[i] = sc.nextInt();
    	}
    	
    	int[] dp = new int[n];
    	Arrays.fill(dp, 0);
    	
    	for(int i = 1; i < n; i++) {
    		for(int j = i - 1; j >= 0; j--) {
    			if(arr[i] < arr[j])
    				dp[i]++;
    		}
    	}
    	
    	for(int i = 0; i < n; i++) {
    		System.out.print(dp[i]);
    		if(i != n - 1) {
    			System.out.print(" ");
    		}
    	}
    }
           
}