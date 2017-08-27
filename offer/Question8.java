package offer;

/**
 * 旋转数组的最小数字
 * @author welding
 * 
 */
public class Question8 {
	
	public static void main(String[] args) {
		int[] arr = {
				3, 4, 5, 0, 0, 0, 0, 1, 2, 2, 3
		};
		
		System.out.println(minRotation(arr));
	}
	
	private static int minRotation(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		int mid = low;
		while(arr[mid] >= arr[high]) {
			if(high - low == 1) {
				mid = high;
				break;
			}
			
			mid = (low + high) / 2;
			
			if(arr[low] == arr[high] && arr[low] == arr[mid])
				return minInorder(arr, low, mid, high);
			
			if(arr[mid] >= arr[low])
				low = mid;
			else if(arr[mid] <= arr[high])
				high = mid;
		}
		
		return arr[mid];
	}
	
	private static int minInorder(int[] arr, int low, int mid, int high) {
		int result = arr[low];
		
		for(int i = low + 1; i <= high; i++) {
			if(result > arr[i])
				result = arr[i];
		}
		
		return result;
	}
}











