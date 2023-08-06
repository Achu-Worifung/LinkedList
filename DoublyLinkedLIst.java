
 class DoublyLinkedLIst<T> {
	
	Node head;
	
	class Node<T>
	{
		Node<T> prev, next;
		T data;
		public Node(T data)
		{
			this.data = data;
			prev = null;
			next = null;
		}
	}
	void add(T data)
	{
		Node newNode = new Node<>(data);
		if(head == null)
			head = newNode;
	}

}
