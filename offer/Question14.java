package offer;

/**
 * 调整数组顺序使奇数位于偶数前面
 * @author welding
 * 思路：和快排中partion思路一致，使用多index对数组进行区域划分
 */
public class Question14 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5 ,6, 7, 8, 9};
		partion(arr);
		for(int i : arr) {
			System.out.println(i);
		}
	}
	
	private static void partion(int[] arr) {
		if(arr == null)
			return;
		int length = arr.length;
		int oddIndex = 0, evenIndex = length -1;
		
		while(oddIndex < evenIndex) {
			if(arr[oddIndex] % 2 == 0) {
				int temp = arr[oddIndex];
				arr[oddIndex] = arr[evenIndex];
				arr[evenIndex] = temp;
				evenIndex--;
			} else {
				oddIndex++;
			}
		}
		
	}
}
