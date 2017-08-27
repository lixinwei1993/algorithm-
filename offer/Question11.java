package offer;

/**
 * 实现函数double power(double base, int exponent), 求base的exponent次方，不得使用库函数
 * @author welding
 * 补充：由于计算机表示小数都有误差，因此不能直接用==判断两个小数是否相等，合理的做法应该是判断两小数差的绝对值是否足够小（自己设定一个精度）
 */
public class Question11 {
	
	public static void main(String[] args) {
		System.out.println( power(0, -2));
	}
	
	private static double power(double base, int exponent) {
		
		if(base - 0 < 0.0000001)	//考虑各种边界条件及负条件，保证程序的完整性和鲁棒性（roubust）
			throw new RuntimeException("can not compute the exponent of 0");
		
		if(exponent < 0)
			return 1.0 / positivePower(base, -exponent);
		else
			return positivePower(base, exponent);
	}
	
	private static double positivePower(double base, int exponent) {
		if(exponent == 0)
			return 1;
		double result = 1;
		int m = exponent % 2;
		if(m == 1) {
			result = positivePower(base, exponent / 2); 	//利用递归而不用连续的乘法可以提高速率！
			return result*result*base;
		} else {
			result = positivePower(base, exponent / 2);
			return result*result;
		}
		
	}
	
}
