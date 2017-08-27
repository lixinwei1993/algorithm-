package offer;

/**
 * 打印从1到最大的n位数
 * @author welding
 * 由于n的大小不限，显然用Java中现有的数据类型是可能会出现问题，只能另辟蹊径，使用char数组或各个位上可能的数的排列组合去处理
 * 一般的使用char[]处理“大数”问题是常用手段
 */
public class Question12 {
	
	public static void main(String[] args) {
		printNumbers(5);
	}
	
	private static void printNumbers(int n) {
		if(n <= 0)
			return;
		
		char[] arr = new char[n+1];
		arr[n] = ' ';

		for(int i = 0; i < 10; i++) {
			arr[0] = (char)('0' + i);

			printNumbersRecursively(arr, n, 0);
		}
	}
	
	/**
	 * 利用递归实现排列组合！！套路要掌握
	 * @param arr
	 * @param length
	 * @param index
	 */
	private static void printNumbersRecursively(char[] arr, int length, int index) {
		if(index == length - 1) {	
			printCharArray(arr);
			return;
		}
		for(int i = 0; i < 10; i++) {	
			arr[index + 1] = (char)(i + '0');
			printNumbersRecursively(arr, length, index + 1);
		}
	}
	
	private static void printCharArray(char[] arr) {
		StringBuilder sb = new StringBuilder();
		int zeroCount = 0;
		for(; zeroCount < arr.length; zeroCount++) {
			if(arr[zeroCount] != '0')
				break;
		}
		for(; zeroCount < arr.length; zeroCount++) {
			sb.append(arr[zeroCount]);
		}
		
		System.out.println(sb);
	}
}
