package offer;

/**
 * 有两个排序数组a1和a2，数组1后方有足够的空余空间容纳数组2,
 * 要求实现一个方法将a2插到a1中并且所有的数字仍是排序的
 * @author welding
 * 合并两个数组时如果从前往后复制每个数字需要重复移动数字多次时，我们可以考虑从后往前，减少移动次数
 * 变例：这说白了就是向一个数组中的某些特定位置插入新的数据，我们可以计算插入完成后新数组的大小，让后从后往前在原数组上进行操作
 * （如果原数组有足够的多余空间的话），减少原数组的移动次数
 */
public class Question4 {
	
	public static void main(String[] args) {
		int size1 = 5;
		int size2 = 5;
		int[] a1 = {
				1, 2, 5, 9, 13, 0, 0, 0, 0, 0, 0
		};
		int[] a2 = {3, 6, 7, 10, 12};
		
		union(a1, a2, size1, size2);
		
		for(int i : a1) {
			System.out.println(i);
		}
	}
	
	/**
	 * 思路：根据合并后总数量的大小从a1的该位置向前进行插入，这样的话只需移动a1中需要移动的位置，无需对1中元素重复一定，类似于Java垃圾回收的复制算法！！
	 * 思路：对于数组和矩阵问题要多动脑子，不要惯性的上来就从前往后处理，有时间从后往前后者斜着来一道都会有不错的效果
	 * @param a1
	 * @param a2
	 * @param size1
	 * @param size2
	 */
	private static void union(int[] a1, int[] a2, int size1, int size2) {
		int i = size1 + size2 - 1;
		for(; i >= 0; i--) {
			if(size2 == 0) {
				break;
			}
			
			if(size1 == 0) {
				a1[i] = a2[size2 - 1];
			}
			else if(a1[size1 - 1] > a2[size2 - 1]) {
				a1[i] = a1[size1 - 1];
				size1--;
			}
			else {
				a1[i] = a2[size2 - 1];
				size2--;
			}
		}
	}

}
