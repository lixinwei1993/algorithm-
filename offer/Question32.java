package offer;

import java.util.*;

public class Question32 {
	
	   public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        
	        System.out.print(numbersOf(n));
	    }
	    
	    private static long numbersOf(int n) {
	        long[] dp = new long[n + 1];
	        dp[0] = 1;
	        int[] money = {1, 5, 10, 20, 100};
	        
	        for(int i = 1; i <= n; i++) {
	            for(int m : money) {
	                if(i - m > 1)
	                    dp[i] += dp[i - m];
	            }
	        }
	        
	        return dp[n] + 1;
	    }
}
