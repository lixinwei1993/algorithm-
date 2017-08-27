package offer;

import java.util.Deque;
import java.util.LinkedList;

public class Question22 {
	public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop1 = {4, 5, 3, 2, 1};
        int[] pop2 = {3, 5, 4, 2, 1};
        int[] pop3 = {4, 3, 5, 1, 2};
        int[] pop4 = {3, 5, 4, 1, 2};

        System.out.println("true: " + isPopOrder(push, pop1));
        System.out.println("true: " + isPopOrder(push, pop2));
        System.out.println("false: " + isPopOrder(push, pop3));
        System.out.println("false: " + isPopOrder(push, pop4));

        int[] push5 = {1};
        int[] pop5 = {2};
        System.out.println("false: " + isPopOrder(push5, pop5));

        int[] push6 = {1};
        int[] pop6 = {1};
        System.out.println("true: " + isPopOrder(push6, pop6));

        System.out.println("false: " + isPopOrder(null, null));
    }

	
	public static boolean isPopOrder(int[] push, int[] pop) {
		if(push == null || pop == null)
			return false;
		if(push.length != pop.length && push.length != 0) 
			return false;
		
		Deque<Integer> stack = new LinkedList<>();
		int toPush = 0;		
		for(int i = 0; i < pop.length; i++) {
			//编程前不止要想到大体的思路，要缕清循环终止条件，边界条件的处理等等，开始编程前应将问题抽象清楚
			while(toPush < push.length && (stack.isEmpty() || stack.peek() != pop[i])){
				stack.push(push[toPush]);
				toPush++;
			}

			if(stack.pop() != pop[i])
				return false;
				
		}
		
		return true;
	}
}
