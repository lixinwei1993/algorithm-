package offer;

/**
 * 求一个数组最小的K个数
 * @author welding
 *
 */
public class Question30 {
	
	public static void main(String[] args) {
		int[] arr = {11, 9, 8, 12, 10, 7, 6, 5, 4, 3, 2, 1};
		//getLeastNumbers(arr, 5);
		getLeastNumbersHeap(arr, 5);
	}
	
	/**
	 * 借助最大堆,O(N*logK),适用于处理海量数据即不对原数组进行改变
	 * @param arr
	 */
	public static void getLeastNumbersHeap(int[] arr, int k) {
		if(arr == null || k > arr.length || k <= 0 || arr.length <= 0)
			return;
		
		int[] result = new int[k];
		for(int i = 0; i < k; i++) {
			result[i] = arr[i];
		}
		
		buildMaxHeap(result);
		
		for(int i = k; i < arr.length; i++) {
			if(arr[i] < result[0]) {
				result[0] = arr[i];
				maxify(result, 0);
			}
		}
		
		for(int i : result) {
			System.out.print(i + " ");
		}
	}
	
	private static void buildMaxHeap(int[] arr) {
		
		int len = arr.length;
		
		for(int i = len / 2 - 1; i >= 0; i--) {
			maxify(arr, i);
		}
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
		
		System.out.println();
	}
	
	private static void maxify(int[] arr, int i) {
		int largest = i;
		int len = arr.length;
		
		while(i < arr.length / 2) {
			if(arr[largest] < arr[2 * i + 1] && (2 * i + 1) < len)
				largest = 2 * i + 1;
			if(arr[largest] < arr[2 * i + 2] && (2 * i + 2) < len)
				largest = 2 * i + 2;
			
			
			if(i == largest)
				break;
			
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			
			i = largest;
		}
		
	}

	/**
	 * O(n*logK)算法，利用快排中的partion，改变了原数组，即要对原数组进行整体的操作，不适用于海量数据
	 */
	public static void getLeastNumbers(int[] arr, int k) {
		if(arr == null || k > arr.length || k <= 0 || arr.length <= 0)
			return;
		
		int high = arr.length - 1;
		int low = 0;
		int pivotPos = partion(arr, low, high);
		
		while(pivotPos != k - 1) {
			if(pivotPos > k - 1) {
				high = pivotPos - 1;
				pivotPos = partion(arr, low, high);
			} else {
				low = pivotPos + 1;
				pivotPos = partion(arr, low, high);
			}
		}
		
		for(int i = 0; i < k; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	private static int partion(int[] arr, int low, int high) {
		int pivot = arr[low];
		
		while(low < high) {
			while(low < high && arr[high] >= pivot) {
				high--;
			}
			
			arr[low] = arr[high];
			//low++;不能加这句，这样虽然每步多比较了一次，但是很好的处理了low与high相等时不增加或减少low与high的问题
			
			while(low < high && arr[low] <= pivot) {
				low++;
			}
			
			arr[high] = arr[low];
			//high--;
		}
		
		arr[low] = pivot;
		return low;
	}
}










