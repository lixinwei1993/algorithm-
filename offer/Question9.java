package offer;

/**
 * 斐波那契数列
 * 教科书上给出的递归算法并不十分契合该数列，因为数列计算过程中存在大量子问题重叠，因此为了效率应选用动态规划
 * @author welding
 * 斐波那契数列有很多应用，不过最重要的还是递归思想和动态规划的思想，实际上动态规划可以看成是对递归的一种改进
 * 当一个问题的解能由其子问题的解组合而成时即可考虑用递归算法，而当不同规模的问题在划分时子问题有重叠时可以考虑用动态规划
 * 使用动态规划一般是建立个存储问题解的数组或矩阵，然后自下而上去解
 *
 */
public class Question9 {
	
	public static void main(String[] args) {
		System.out.println(fibonacciRecursive(10));
		System.out.println(fibonacciDynamicProgramming(10));
	}
	
	private static long fibonacciRecursive(int n) {
		if(n == 0) {
			return 0;
		}
		
		if(n == 1) {
			return 1;
		}
		
		return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
	}
	
	private static long fibonacciDynamicProgramming(int n) {
		int[] arr = new int[n + 1];
		arr[0] = 0;
		arr[1] = 1;
		for(int i = 2; i <= n; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		
		return arr[n];
	}
}
