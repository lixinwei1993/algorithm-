package offer;

/**
 * 位运算，判断一个数字的二进制表示中1的位数
 * @author welding
 *
 */
public class Question10 {
	
	public static void main(String[] args) {
		System.out.println(numberOfOne(-7));
	}
	
	/**
	 * 一般想到的会是从最低位判断，每判断一次将原数右移一次，但是这样一是效率低，二是对于负数右移补1会出现死循环
	 * 虽然Java中有>>>右移补0，但是仍没有下面的解法效率高
	 * 把一个整数减1之后再和原来的数做位与运算得到的结果相当于把原整数最低位二进制中的1置0
	 * @param n
	 * @return
	 */
	private static int numberOfOne(int n) {
		if(n == 0)
			return 0;
		int count = 1;
		n &= (n - 1);
		while(n != 0){
			count++;
			n &= (n - 1);
		}
		
		return count;
	}
}
