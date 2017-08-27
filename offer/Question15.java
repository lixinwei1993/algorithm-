package offer;

/**
 * 思路：在一个链表上使用多个iterator达到我们的目的，这和在解数组时使用多个index进行分组有异曲同工之妙
 * @author welding
 *
 */
public class Question15 {
	
	public static void main(String[] args) {
		ListNode<Integer> node1 = new ListNode<Integer>(1);
		ListNode<Integer> node2 = new ListNode<Integer>(2);
		ListNode<Integer> node3 = new ListNode<>(3);
		ListNode<Integer> node4 = new ListNode<>(4);
		ListNode<Integer> node5 = new ListNode<>(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		System.out.println(findKthToTail(node1, 3).data);
		System.out.println(findKthToTail(node1, 5).data);
		//System.out.println(findKthToTail(node1, 6).data);
		System.out.println(findKthToTail(node1, 0).data);
		//System.out.println(findKthToTail(null, 3).data);
		
		System.out.println(findMidNode(node1).data);
		
		System.out.println(hasCycle(node1));
		//node5.next = node1;
		System.out.println(hasCycle(node1));
		
		ListNode<Integer> newHead = reverseList(node1);
		while(newHead != null) {
			System.out.print(newHead.data + " ");
			newHead = newHead.next;
		}
	}
	
	private static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> list1, ListNode<Integer> list2) {
		if(list1 == null)
			return list2;
		if(list2 == null)
			return list1;
		
		if(list1.data > list2.data) {
			return list2.next = mergeTwoSortedLists(list1, list2.next);
		} else {
			return list1.next = mergeTwoSortedLists(list1.next, list2);
		}
	}
	
	
	private static ListNode<Integer> reverseList(ListNode<Integer> head) {
		if(head == null)
			return null;
		if(head.next == null)
			return head;
		//定义辅助变量不怕多一个，newHead这个量还是要的，否则只有三个量会造成逻辑混乱
		ListNode<Integer> preNode = null, currentNode = head, nextNode = null, newHead = null;
		
		while(currentNode != null) {
			nextNode = currentNode.next;
			currentNode.next = preNode;
			if(nextNode == null)
				newHead = currentNode;
			preNode = currentNode;
			currentNode = nextNode;
		}
		
		return newHead;
	}
	
	private static ListNode<Integer> findMidNode(ListNode<Integer> head) {
		/**
		 * 思路：快慢iterator， 一个iterator是另一个iterator的两倍
		 */
		if(head == null) {
			return null;
		}
		
		ListNode<Integer> slowIterator = head, fastIterator = head;
		while(fastIterator.next != null) {
			fastIterator = fastIterator.next.next;
			slowIterator = slowIterator.next;
		}
		
		return slowIterator;
		
	}
	
	private static boolean hasCycle(ListNode<Integer> head) {
		if(head == null || head.next == null)
			return false;
		
		ListNode<Integer> slowIterator = head, fastIterator = head;
		while(true) {
			if(fastIterator.next == null || fastIterator.next.next == null) //robust
				return false;
			fastIterator = fastIterator.next.next;
			slowIterator = slowIterator.next;
			if(fastIterator == slowIterator)
				return true;
		}
	}
	
	private static ListNode<Integer> findKthToTail(ListNode<Integer> head, int k) {
		ListNode<Integer> iterator1 = head, iterator2 = head;
		if(k < 0 && head == null) 
			return null;
			
		for(int i = 0; i < k - 1; i++) {
			if(iterator1.next == null) 
				throw new RuntimeException("list length can not be less than k!");
			iterator1 = iterator1.next;
		}
		
		while(iterator1.next != null) {
			iterator1 = iterator1.next;
			iterator2 = iterator2.next;
		}
		
		return iterator2;
	}
}
