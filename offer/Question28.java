package offer;

public class Question28 {

	public static void permutation(char[] str) {
		if(str == null || str.length < 1)
			return;
		
		permutation(str, 0);
	}
	
	public static void permutation(char[] str, int begin) {
		if(str.length - 1 == begin) {
			System.out.print(new String(str) + " ");
		} else {
			char temp;
			for(int i = begin; i < str.length; i++) {
				//交换
				temp = str[begin];
				str[begin] = str[i];
				str[i] = temp;
				
				permutation(str, begin + 1);
				
				//还原
				temp = str[begin];
				str[begin] = str[i];
				str[i] = temp;
			}
		}
	}
}
