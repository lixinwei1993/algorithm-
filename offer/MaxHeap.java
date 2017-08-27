package offer;

public class MaxHeap {

	int[] heap;
	int heapSize;
 
	public MaxHeap(int[] arr) {
		heap = arr;
		heapSize = arr.length;
	}
	
	public void heapSort() {
		buildHeap();
		for(int i = 0; i < heap.length; i++) {
			int temp = heap[0];
			heap[0] = heap[heapSize - 1];
			heap[heapSize - 1] = temp;
			heapSize--;
			maxify(0);
		}
	}
	
	public void buildHeap() {
		for(int i = heapSize / 2 - 1; i >= 0; i--) {
			maxify(i);
		}
	}
	
	public void maxify(int i) {
		int l = left(i);
		int r = right(i);
		int largest;
		
		if(l < heapSize && heap[l] > heap[i])
			largest = l;
		else
			largest = i;
		
		
		if(r < heapSize && heap[r] > heap[largest])
			largest = r;
		
		if(largest == i || largest >= heapSize)
			return;
		
		int temp = heap[i];
		heap[i] = heap[largest];
		heap[largest] = temp;
		maxify(largest);
	}
	
	private int left(int i)
	{
	    return 2*(i+1)-1;
	}
	
	private int right(int i)
	{
	    return 2*(i+1);
	}
	
	public static void main(String[] args) {
		int[] toSort = {5, 4, 1, 2, 9, 6, 7, 3, 8, 0};
		MaxHeap mh = new MaxHeap(toSort);
		mh.heapSort();
		
		for(int i : toSort) {
			System.out.print(i + " ");
		}
	}
}
