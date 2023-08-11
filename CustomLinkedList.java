import java.util.*;

class CustomLinkedList<T> {

	Node<T> head;
	int size = 0;

	class Node<T> {
		Node<T> next;

		T data;

		Node(T value) {
			this.data = value;
			next = null;
		}
	}

	void add(T data) {
		Node<T> node = new Node<>(data);
		if (head == null) {
			head = node;
			size++;
		} else {
			Node<T> currnode = head;
			while (currnode.next != null) {
				currnode = currnode.next;
			}
			currnode.next = node;
			size++;
		}
	}

	void add(int index, T data) {
		Node<T> node = new Node<>(data);
		if (index == 0) {
			head = node;
			size++;

		}

		else {
			int count = 0;
			Node<T> currnode = head;
			while (currnode != null) {
				if (index == count + 1) {
					node.next = currnode.next;
					currnode.next = node;
					size++;

				}
				currnode = currnode.next;
				count++;
			}
		}

	}

	void removeLast() {
		if (head != null) {
			Node<T> curNode = head;
			while (curNode.next != null) {
				curNode = curNode.next;
			}
			curNode = null;
		}
		throw new NullPointerException("Empty Linked List");
	}

	void addAll(Collection<? extends T> list) {
		for (T data : list) {
			add(data);
			size++;
		}
	}

	void addFirst(T data) {
		Node<T> node = new Node<>(data);
		if (head == null) {
			head = node;
			size++;
		} else {
			Node<T> preHead = head;
			head = node;
			head.next = preHead;
			size++;
		}
	}

	void removeFirst() {
		if (head != null) {
			head = head.next;
		} else {
			// list is empty can't remove
			throw new NullPointerException("Empty Linked List");
		}
	}

	void clear() {
		head = null;
	}

	boolean isEmpty() {
		return size < 0;
	}

	boolean contains(Object value) {
		if (isEmpty()) {
			return false;
		} else {
			Node<T> currnode = head;
			while (currnode != null) {
				if (currnode.data.equals(value)) {
					return true;
				}
				currnode = currnode.next;
			}
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

	T getLast() {
		if (isEmpty())
			return null;
		Node<T> currnode = head;
		while (currnode.next != null) {
			currnode = currnode.next;
		}
		return currnode.data;
	}

	int indexOf(Object value) {
		int index = 0;
		if (isEmpty()) {
			return -1;
		} else {
			Node<T> currnode = head;
			while (currnode != null) {
				if (currnode.data.equals(value)) {
					return index;
				}
				currnode = currnode.next;
				index++;
			}
		}
		return -1;
	}

	void printList() {
		if (head == null) {
			System.out.println("Custome Linked List is EMPTY!");
			return;
		} else {
			System.out.println("Custome Doubly Linked List: ");
			Node<T> currnode = head;
			while (currnode != null) {
				System.out.print(currnode.data+ " ");
				currnode = currnode.next;
			}
		}
	}

	Node<T> peekFirst() {
		if (isEmpty())
			return null;
		else
			return head;
	}

	Node<T> peekLast() {
		if (isEmpty())
			return null;
		else {
			Node<T> currnode = head;
			while (currnode.next != null) {

				currnode = currnode.next;
			}
			return currnode;
		}

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
		else {
			Node<T> currnode = head;
			while (currnode.next != null) {
				currnode = currnode.next;
			}
			Node<T> temp = currnode;
			currnode = null;
			return temp;
		}
	}

	Object[] toArray() {
		Object[] array = new Object[size];
		for (int i = 0; i < array.length; i++) {
			Node<T> currnode = pollFirst();
			array[i] = currnode.data;
		}
		return array;
	}

	void set(int index, T value) {
		// It replaces the element at the specified position in a list with the
		// specified element.
		if (isEmpty())
			return;
		if (index > size) throw new IndexOutOfBoundsException("Index Out of Bounds");
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

	int size() {
		return size;
	}


}
