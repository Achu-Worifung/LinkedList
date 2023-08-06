
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

	void remove() {
		if (head != null) {
			Node<T> currnode = head;
			while (currnode.next != null) {
				currnode = currnode.next;
			}
			currnode = null;
		}
	}

	void add(int index, T data) {
		int size = getSize();
		if (index == 0) {
			addHead(data);
		} else if (index == size - 1) {
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
		}
	}

	void remove(int index) {
		int size = getSize();
		if (index == 0) {
			deleteHead();
		}
	}

	void addHead(T data) {
		Node<T> newNode = new Node<>(data);
		if (head == null) {
			head = newNode;
		} else {
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		}
	}

	void deleteHead() {
		if (head != null) {
			head = head.next;
		}
	}

	int getSize() {
		int size = 0;
		Node<T> currNode = head;
		while (currNode != null) {
			currNode = currNode.next;
			size++;
		}
		return size;
	}

	boolean isEmpty() {
		return head == null;
	}

}
