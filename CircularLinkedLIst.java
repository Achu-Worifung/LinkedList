
class CircularLinkedLIst<T> {

	Node<T> head;
	int size = 0;

	class Node<T> {
		Node<T> next;

		T data;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	void addHead(T data) {
		Node<T> node = new Node<>(data);
		if (head == null) {
			head = node;
			return;
		}
		node.next = head.next;
		head.next = node;
		head = node;
		size++;
	}

	void removeHead() {
		if (head == null) {
			return;
		}
		Node<T> currnode = head.next;
		while (currnode.next != head) {
			currnode = currnode.next;
		}
		currnode.next = head.next;
		head = currnode.next;
		size--;
	}

	void add(T data) {
		Node<T> node = new Node<>(data);
		if (head == null) {
			head = node;
			head.next = head;
			size++;
		} else {
			Node<T> currnode = head;
			while (currnode.next != null) {
				currnode = currnode.next;
			}
			// currnode.next = node;
			// currnode.next.next = head;
			node.next = head;
			currnode.next = node;
			size++;
		}
	}

	void removeTail() {

		if (head == null) {
			return;
		} else if (head.next == head) {
			head = null;
			size--;
			return;
		} else if (head.next.next = head) {
			head.next = head;
			size--;

		} else {
			Node<T> currnode = head;
			while (currnode.next.next != head) {
				currnode = currnode.next;

			}
			currnode.next = head;
			size--;
		}
	}

	void add(int index, T data) {

		if (index == 0) {
			addHead(data);

		} else if (index == size + 1) {
			// out of boundexception
		} else {
			int count = 0;
			Node<T> node = new Node<>(data);
			Node<T> currnode = head;
			while (count + 1 < size) {
				currnode = currnode.next;
				count++;
			}
			node.next = currnode.next;
			currnode.next = node;
		}

	}

	void remove(int index) {
		int size = getSize();
		if (index == 0) {
			removeHead();

		} else if (index == (size - 1)) {
			removeTail();
		} else if ((index > 0) && (index < (size - 1))) {
			Node<T> currnode = head;
			int i = 0;
			while (i != index - 2) {
				i++;
				currnode = currnode.next;
			}
			currnode.next = currnode.next.next;
		}

	}

	int getSize() {
		if (head == null)
			return 0;
		Node<T> currnode = head;
		int size = 0;
		while (currnode.next != head) {
			size++;
			currnode = currnode.next;
		}
		return size;
	}

	boolean isEmpty() {
		return head == null;
	}

	void printList() {
		if (head == null)
			return;
		Node<T> currnode = head;

		System.out.println("Circular Linked LIst");
		do {
			System.out.print(currnode.data + " ");
			currnode = currnode.next;
		} while (currnode != head);
	}

	void goInCircles() {
		if (head == null)
			return;
		Node<T> currnode = head;
		int times = 2;
		while (true) {
			if (currnode.next = head) {
				System.out.println(times + ": ");
				System.out.println();
				times++;
			}
			System.out.println(currnode.data);
			currnode = currnode.next;
		}
	}

}
