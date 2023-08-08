
import java.util.Collection;

class DoublyLinkedLIst<T> {

	Node<T> head;

	class Node<T> {
		Node<T> prev, next;
		T data;

		public Node(T data) {
			this.data = data;
			prev = null;
			next = null;
		}
	}

	void add(T data) {
		Node<T> newNode = new Node<>(data);

		if (head == null) {
			head = newNode;
		} else {
			Node<T> currnode = head;
			while (currnode.next != null) {
				currnode = currnode.next;
			}
			currnode.next = newNode;
			newNode.prev = currnode;
		}
	}
	void add(int index, T data) {
		int size = getSize();
		if (index == 0) {
			addFirst(data);
		} else if (index == size) {
			add(data);
		} else if ((index > 0) && (index < size - 1)) {
			int i = 0;
			Node<T> node = new Node<>(data);
			Node<T> currNode = head;
			while (i != index) {
				currNode = currNode.next;
				i++;
			}
			currNode.prev.next = node;
			node.prev = currNode.prev;
			currNode.prev = node;
			node.next = currNode;
		} else 
		{
			throw new IndexOutOfBoundsException(" Index out of bound");
		}
	}

	void removeLast() {
		if (head != null) {
			Node<T> currnode = head;
			while (currnode.next != null) {
				currnode = currnode.next;
			}
			currnode = null;
		}
		throw new NullPointerException("Empty Linked List");
	}

	void addAll(Collection<? extends T> list)
	{
		for (T data: list)
		{
			add(data);
		}
	}
	void addFirst(T data) {
		Node<T> newNode = new Node<>(data);
		if (head == null) {
			head = newNode;
		} else {
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		}
	}
	void removeFirst() {
		if (head != null) {
			head = head.next;
			return;
		}
		throw new NullPointerException("Empty Linked List");
	}
	void clear()
	{
		head = null;
	}
	boolean isEmpty() {
		return head == null;
	}
	boolean contains(Object value)
	{
		if(isEmpty())
		{
			return false;
		}
		Node<T> currNode = head;
		while(currNode != null)
		{
			if(currNode.data.equals(value))
			{
				return true;
			}
			currNode = currNode.next;
		}
		return false;
	}
	T getFirst()
	{
		if(head == null)
		{
			throw new NullPointerException("Linked List Is Empty");
		}
		return  head.data;
	}
	T getLast()
	{
		if(isEmpty()) return null;
		
		Node<T> currNode = head;
		while (currNode.next != null)
		{
			currNode = currNode.next;
		}
		return currNode.data;
		
	}
	
	int indexOf(Object value)
	{
		int index = 0;
		if(isEmpty()) return -1;
		else {
			Node<T> currNode = head;
			while(currNode != null)
			{
				if(currNode.data.equals(value)) return index;
				currNode = currNode.next;
				index++;
			}
			return -1;
		}
	}
	void printList() {
		if (head == null) {
			System.out.println("Custom Doubly Linked List is EMPTY!");
			return;
		} else {
			System.out.println("Custom Doubly Linked List: ");
			Node<T> currnode = head;
			while (currnode != null) {
				System.out.print(currnode.data+ " ");
				currnode = currnode.next;
			}
		}
	}
	void forwardThenBackward() {
		if (head == null) {
			System.out.println("Custom Doubly Linked List is EMPTY!");
			return;
		} else {
			System.out.println("Custom Doubly Linked List: ");
	
			// Forward traversal
			Node<T> currnode = head;
			while (currnode != null) {
				System.out.print(currnode.data + " ");
				currnode = currnode.next;
			}
	
			// Backward traversal
			currnode = head;
			while (currnode.next != null) {
				currnode = currnode.next;
			}
			while (currnode != null) {
				System.out.print(currnode.data + " ");
				currnode = currnode.prev;
			}
		}
	}
	
	Node<T> peekFirst()
	{
		if(isEmpty()) return null;
		return head;
	}
	Node<T> peekLast()
	{
		if(isEmpty()) return null;
		Node<T> currNode = head;
		while(currNode.next!= null)
		{
			currNode= currNode.next;
		}
		return currNode;
	}
	Node<T> pollFirst() {
		if (isEmpty())
			return null;
		else {
			Node<T> temp = head;
			head = head.next;
			return temp;
		}
	}
	Node<T> pollLast() {
		if (isEmpty())
			return null;
		
		Node<T> currnode = head;
		while (currnode.next != null) {
			currnode = currnode.next;
		}
		Node<T> temp = currnode;
		currnode = null;
		return temp;
		
	}
	
	Object[] toArray() {
		Object[] array = new Object[getSize()];
		for (int i = 0; i < array.length; i++) {
			Node<T> currnode = pollFirst();
			array[i] = currnode.data;
		}
		return array;
	}

	int getSize() {
		int size = 0;
		Node<T> currNode = head;
		while (currNode != null) {
			size++;
			currNode = currNode.next;
			
		}
		return size;
	}
	void set(int index, T value)
	{
		if(isEmpty()) return;
		if(index > getSize())  throw new IndexOutOfBoundsException("Index Out of Bounds");
		int count = 0;
		Node<T> currnode = head;
		while (currnode != null) {
			if (count == index) {
				currnode.data = value;
				return;
			} else {
				count++;
				currnode = currnode.next;
			}
		}
	}

}
