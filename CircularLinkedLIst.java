

class CircularLinkedLIst<T> {
	
	 Node<T> head;
	 int size = 0;
	 
	class Node<T>
	{
		Node<T> next;
		
		T data;
		public Node(T data)
		{
			this.data = data;
			this.next = null;
		}
	}
	void add(T data)
	{
		Node<T> node = new Node<>(data);
		if(head == null) 
		{
			head = node;
			head.next = head;
			size++;
		}
		else
		{
			Node<T> currnode = head;
			while(currnode.next != null)
			{
				currnode = currnode.next;
			}
			currnode.next = node;
			currnode.next.next = head;
			size++;
		}
	}
	void add(int index, T data)
	{
		Node<T> node = new Node<>(data);
		if(index == 0) 
		{
			head = node;
			head.next = head;
			size++;
			
		} else if (index == size+1)
		{
			
		}
		else 
		{
			int count = 0;
			Node<T> currnode = head;
			while(currnode.next != head)
			{
				if(index == count+1)
				{
					node.next = currnode.next;
					currnode.next = node; 
					size++;
					
				}
				currnode = currnode.next;
				count++;
			}
		}
		
	}

}
