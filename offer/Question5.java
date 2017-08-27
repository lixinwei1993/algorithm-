package offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 从尾到头打印单链表
 * @author welding
 * 对循环、递归、栈三者的关联应熟练运用，对Java Deque interface应有一定认识
 */
public class Question5 {
	public static void main(String[] args) {
		ListNode<Integer> first = new ListNode<>(1);
		ListNode<Integer> second = new ListNode<>(2);
		ListNode<Integer> third = new ListNode<>(3);
		ListNode<Integer> forth = new ListNode<>(4);
		
		first.next = second;
		second.next = third;
		third.next = forth;
		
		reverseUsingStack(first);
		reverseRecursively(first);
	}
	
	/**
	 * 思路由于单链表只能从前往后遍历，要想实现从后往前，比较容易想到的思路就是使用一个栈存储遍历结果，遍历完成后再一次出栈就可以了
	 * 值得注意的是Java中没有单链表的collections所以这里实现了一个，在实际做题时可以使用linkedList只使用其向后功能即可
	 * @param head
	 * Java中stack与queue中对应的接口是Dequeue，对Java Collections的应用应多加熟悉
	 */
	private static void reverseUsingStack(ListNode<Integer> head) {
		Deque<Integer> stack = new ArrayDeque<>();
		
		while(head != null) {
			stack.addFirst(head.data);
			head = head.next;
		}
		
		while(stack.peekFirst() != null) {
			System.out.println(stack.removeFirst());
		}
	}
	
	/**
	 * 能用stack的情况一般都可以转化为递归形式，而且代码更为简洁
	 * @param head
	 */
	private static void reverseRecursively(ListNode<Integer> head) {
		if(head.next != null) {
			reverseRecursively(head.next);
		}
		
		System.out.println(head.data);
	}
	
}
