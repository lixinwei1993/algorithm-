package leetCode;

/**
 * for each coin j, Vj≤i, look at the minimum number of coins found for the i-Vjsum (we have already
found it previously). Let this number be m. If m+1 is less than the minimum number of coins already found for
current sum i, then we write the new result for it.
 * @author welding
 *
 */
public class CoinChangeDP {
	
	public static void main(String[] args) {
		int[] coins = {1, 3, 5};
		System.out.println(minCoinDynamic1(2, coins));
		System.out.println(minCoinDynamic2(3, coins));
	}

	public static int minCoinDynamic1(int amount, int[] coins) {
		int[] min = new int[amount + 1];
		
		for(int i = 0; i <= amount; i++)
			min[i] = 100;
		
		min[0] = 0;
		for(int i = 1; i <= amount; i++) {
			for(int j = 0; j < coins.length; j++) {
				if(coins[j] <= i && (min[i - coins[j]] + 1 < min[i])) {
					min[i] = min[i - coins[j]] + 1;
				}
			}
		}
		
		return min[amount];
	}
	
	public static int minCoinDynamic2(int amount, int[] coins) {
		int[] min = new int[amount + 1];
		for(int i = 0; i <= amount; i++)
			min[i] = 100;
		min[0] = 0;
		for(int i = 0; i < coins.length; i++) {
			for(int j = 0; j < min.length; j++) {
				if(coins[i] + j < min.length && min[j] + 1 < min[j + coins[i]])
					min[j + coins[i]] = min[j] + 1;
			}
		}
		
		return min[amount];
		
	}
}



 class xx {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		
		for(int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		
		List<Integer> result = new LinkedList<>();
		result.add(0);
		
		for(int i = 1; i < n; i++) {
			boolean isMax = true;
			//boolean temp = false;
			for(int j : result) {
				int xx = x[j], yy = y[j];
				
				if(xx > x[i] && yy > y[i])
					isMax = false;
				
				if(x[i] > xx && y[i] > yy)
					result.remove(new Integer(j));
				
			}
			
			if(isMax)
				result.add(i);
		}
		
		int count = 0;
		for(int i : result) {
			count++;
			System.out.print(x[i] + " " + y[i]);
			if(count != result.size())
				System.out.println();;
		}
	}

    
}

