package offer;

public class ListNode<T> {
	public T data;
	public ListNode<T> next;
	
	// post: constructs a node with data 0 and null link
    public ListNode() {
        this(null, null);
    }

    // post: constructs a node with given data and null link
    public ListNode(T data) {
        this(data, null);
    }

    // post: constructs a node with given data and given link
    public ListNode(T data, ListNode<T> next) {
        this.data = data;
        this.next = next;
    }
}
