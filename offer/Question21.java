package offer;

import java.util.Deque;
import java.util.LinkedList;

public class Question21 {
	
	public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        stack.push(3);
        System.out.println(stack.min() == 3);
        stack.push(4);
        System.out.println(stack.min() == 3);
        stack.push(2);
        System.out.println(stack.min() == 2);
        stack.push(3);
        System.out.println(stack.min() == 2);
        stack.pop();
        System.out.println(stack.min() == 2);
        stack.pop();
        System.out.println(stack.min() == 3);
        stack.push(0);
        System.out.println(stack.min() == 0);
    }

	private static class StackWithMin {
		private Deque<Integer> dataStack = new LinkedList<>();
		private Deque<Integer> minStack = new LinkedList<>();
		
		public void push(int i) {
			dataStack.push(i);
			if(minStack.isEmpty() || i <= minStack.peek())
				minStack.push(i);
			else {
				minStack.push(minStack.peek());
			}
		}
		
		public int pop() {
			
			minStack.pop();
			
			return dataStack.pop();
		}
		
		public int min() {
			return minStack.peek();
		}
	}
}
