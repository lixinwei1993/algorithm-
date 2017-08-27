package offer;

/**
 * 给定单向链表的头node和要删除的node，定义一个能在O(1)时间内删除制定node的方法
 * @author welding
 * 思路：头结点其实是迷惑条件，要想完成O(1)时间内删除，显然不能遍历找到要删除结点的上一个结点
 * 但我们可以另辟蹊径时待删除结点被覆盖为其下一个结点，这样通过覆盖完成了节点删除
 */
public class Question13 {
	//注意代码的完整性与鲁棒性，考虑空链表，删除节点为最后一个结点，删除节点为第一个节点，链表中只有一个节点等情况
	private static void nodeDelete(ListNode<Integer> head, ListNode<Integer> toDelete) {
		if(head == null || toDelete == null)
			return;
		
		if(head == toDelete)
			head = null;
		
		if(toDelete.next != null) {
			ListNode<Integer> nextNode = toDelete.next;
			toDelete.data = nextNode.data;
			toDelete.next = nextNode.next;
		} else {
			//对于要删除结点为最后一个结点的情况只能采用遍历方法，复杂度为O(n)，但该情况毕竟较少，故本方法提供的方式总体上还是O(1)
			ListNode<Integer> preNode = head;
			while(preNode.next != toDelete) {
				preNode = preNode.next;
			}
			preNode.next = null;
		}
			
	}
}
