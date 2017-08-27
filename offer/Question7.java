package offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 用两个栈实现一个队列
 * @author welding
 * 学会画图分析问题，分析问题时不应该仅达到思路理顺位置，应该以写出伪代码为止
 * 对边界条件等应有充分的认识
 */
public class Question7 {
	
	public static void main(String[] args) {
		QueueUsingStacks queue = new QueueUsingStacks();
		queue.enqueue(1);
		queue.enqueue(2);
		System.out.print(queue.dequeue() + " " + queue.dequeue());
	}
	
	
	private static class QueueUsingStacks {
		private Deque<Integer> stack1 = new LinkedList<>();
		private Deque<Integer> stack2 = new LinkedList<>();
		
		public void enqueue(int i) {
			stack1.push(i);;
		}
		
		public int dequeue() {
			if(stack2.isEmpty()) {
				while(!stack1.isEmpty()) {
					stack2.push(stack1.removeFirst());
				}
			}
			if(stack2.isEmpty())	//异常情况处理，注意细节
				throw new RuntimeException("already empty");
			return stack2.pop();
		}
	}
}
