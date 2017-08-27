package offer;

public class Sort {
	public static void bubbleSort(int[] arr) {
		for(int j = 0; j < arr.length - 1; j++) {
			for(int i = j + 1; i < arr.length; i++) {
				int temp;
				if(arr[j] > arr[i]) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		
	}
	
	public static void insertionSort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			for(int j = i; j > 0; j--) {
				if(arr[j] >= arr[j - 1])
					break;
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
			}
		}
	}
	
	public static void shellSort(int[] arr) {
		int len = arr.length;
		for(int d = len / 2; d >= 1; d = d / 2) {
			for(int i = 0; i < d; i++) {
				for(int j = i; j < len; j += d) {
					for(int k = j; k >= d; k -= d) {
						if(arr[k] > arr[k - d])
							break;
						int temp = arr[k];
						arr[k] = arr[k - d];
						arr[k - d] = temp;
					}
				}
			}
		}
	}
	
	public static void quickSort(int[] arr) {
		
	}

		
		
		
	}
	
	public static void main(String[] args) {
		int[] toSort = {5, 4, 1, 2, 9, 6, 7, 3, 8, 0};
		//bubbleSort(toSort);
		//insertionSort(toSort);
		shellSort(toSort);
		
		for(int i : toSort) {
			System.out.print(i + " ");
		}
	}
}
