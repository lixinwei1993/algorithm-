package leetCode;

public class StringPermutation {
	public static void main(String[] args) {
		String s = "";
		permutation(s);
	}
	public static void permutation(String s) {
		//List<Character> path = new ArrayList<>();
		char[] arr = s.toCharArray();
		
		permutation(arr, 0);
	}
	
	public static void permutation(char[] arr, int begin) {
		if(begin == arr.length) {
			for(char c : arr) 
				System.out.print(c + " ");
			System.out.println();
		}
		
		for(int i = begin; i < arr.length; i++) {
			char temp = arr[begin];		//执行
			arr[begin] = arr[i];
			arr[i] = temp;
			
			permutation(arr, i + 1);	//递归
			
			temp = arr[begin];			//回退，这里的执行与回退通过交换位置实现了，比较巧妙且代码简洁
			arr[begin] = arr[i];
			arr[i] = temp;
		}
	}
	
}
