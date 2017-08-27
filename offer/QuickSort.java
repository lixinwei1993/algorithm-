package offer;

public class QuickSort {
	
	public static void main(String[] args) {
		int[] arr = {3, 5, 1, 6, 2, 10};
		quickSort(arr, 0, 5);
		
		for(int i : arr) {
			System.out.println(i);
		}
	}
	
	private static void quickSort(int[] arr, int low, int high) {
		if(low > high) 
			return;
		int index = partion(arr, low, high);
		quickSort(arr, low, index-1);
		quickSort(arr, index+1, high);
	}

	/**
	 * 始终选取第一个元素作为划分标准
	 * 此方法也适用与选取其他任意位置处元素作为pivot的方法，将选定元素交换的数组首位便可进行按如下进行计算了（但是这样丢失了稳定性）
	 * @param arr 	要划分的数组
	 * @param s		要划分的子数组的起始index
	 * @param e		要划分的子数组的终止index
	 * 思想：对数组进行分区，可以避免依赖辅助空间！类似TCP/IP中滑动窗口
	 */
	private static int partion(int[] arr, int low, int high) {
		int pivot = arr[low];
		
		while(low < high) {
			while(arr[high] >= pivot && high > low) //不移动=pivot的值保持稳定性
				high--;
			arr[low] = arr[high];
			while(arr[low] <= pivot && low < high) //不移动=pivot的值保持稳定性
				low++;
			arr[high] = arr[low];
		}
		
		arr[low] = pivot;
		
		return low;
	}
}
