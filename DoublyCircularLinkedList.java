import java.util.Collection;

public class DoublyCircularLinkedList<T> {

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
    void add(T data)
    {
        Node<T> newNode = new Node<>(data);
        if(head == null) addFirst(data);
    
        else 
        {
            Node<T> currNode = head;
            while(currNode.next != head )
            {
                currNode = currNode.next;
            }
            currNode.next = newNode;
            newNode.prev = currNode;
            head.prev = newNode;
            newNode.next = head;
            

        }
        
    }
    void addFirst(T data)
    {
        Node<T> newNode = new Node<>(data);
        if(head == null)
        {
            head = newNode;
            head.next = head;
            head.prev = head;
            
        }
        else 
        {
            head.prev.next = newNode;
            newNode.prev = head.prev;
            newNode.next = head;
            head.prev = newNode;
            head = newNode;

        }
      
    }
    void add(int index, T data)
    {
        
        if(head == null) addFirst(data);
        else if(index == getSize()) add(data);
        else if ((index > 0) && (index < getSize()))
        {
            int i = 0;
            Node<T> newNode = new Node<>(data);
            Node<T> currNode = head;
            while(i != index)
            {
                currNode = currNode.next;
                i++;
            }
            currNode.prev.next = newNode;
            newNode.prev = currNode.prev;
            currNode.prev = newNode;
            newNode.next = currNode;
            
        }
        
    }
    void removeLast()
    {
        if(head.next == head) head = null;

        else if(head != null)
        {
            Node<T> currNode = head.next;
            while (currNode.next != head)
            {
                currNode = currNode.next;
            }
            currNode.prev.next = head;
            head.prev = currNode.prev;
            
        }
        else throw new NullPointerException("Empty Linked List");   
        
        
    }
    void remove(int index)
    {
        if(index == 0) removeFirst();
        else if(index == getSize()-1) removeLast();
        else if ((index > 0) && (index < getSize() - 1))
        {
            int i = 0;
            
            Node<T> currNode = head;
            while(i != index)
            {
                currNode = currNode.next;
                i++;
            }
            currNode.prev.next = currNode.next;
            currNode.next.prev = currNode.prev;
            
        }
        else System.out.println("Index Out of Bounds");
    }
    void addAll(Collection<? extends T> list)
	{
		for (T data: list)
		{
			add(data);
            
		}
	}
    void removeFirst()
    {
        if(head != null)
        {
            Node<T> currNode = head.next;
            currNode.prev = head.prev;
            head.prev.next = currNode;
            head = currNode;
            
        }
        else throw new NullPointerException("Empty Linked List");
    }
    void clear()
    {
        head = null;
       
    }
    boolean isEmpty()
    {
        return head == null;
    }
    boolean contains(Object Value)
    {
        if(isEmpty()) return false;
        Node<T> currNode = head;
        while(currNode.next != head)
        {
            if(currNode.data.equals(Value)) return true;
            currNode = currNode.next;
        }
        return false;
        
    }
    T getFrist()
    {
        if(head == null) return null;
        return head.data;
    }
    T getLast()
	{
		if(isEmpty()) return null;
		
		Node<T> currNode = head;
		while (currNode.next != head)
		{
			currNode = currNode.next;
		}
		return currNode.data;
		
	}
    T getIndex(int index)
    {
        if(isEmpty()) return null;
        Node<T> currNode = head;
        int i = 0;
        if(index >= 0) //let the index be greater than size
        {
            while(index != i)
            {
                i++;
                currNode = currNode.next;
            }
            return currNode.data;
        } else return null;
    }
    int indexOf(Object value)
    {
        int index = 0;
        if(isEmpty()) return -1;
        else 
        {
            Node<T> currNode = head;
            while(currNode.next != head)
            {
                if(currNode.data.equals(value)) return index;
                currNode = currNode.next;
                index++;
            }
        }
        return -1;
    }
    Node<T> peekFirst()
    {
        if(isEmpty()) return null;
        return head;
    }
    Node<T> peekLast()
    {
        if(isEmpty()) return null;
        else
        {
            Node<T> currNode = head;
            while(currNode.next != head)
            {
                currNode = currNode.next;
            }
            return currNode;
        }
    }
    Node<T> peekIndex(int index)
    {
        if(isEmpty()) return null;
        else if(index >= 0) 
        {
            int i = 0;
            Node<T> currNode = head;
            while (i != index)
            {
                i++;
                currNode = currNode.next;
                
            }
            return currNode;
        }else return null;
    }
    Node<T> pollFirst()
    {
        if(isEmpty()) return null;
        else 
        {
            Node<T> temp = head;
            removeFirst();
           
            return temp;
        }
    }
    
    Node<T> pollLast()
    {
        if(isEmpty()) return null;
        Node<T> currNode = head;
        while(currNode.next != head)
        {
            currNode = currNode.next;
        }
        removeLast();
        
        return currNode;
    }
    Node<T> pollIndex(int index)
    {
        if(isEmpty()) return null;
        Node<T> currNode = head;
        if(index >= 0)
        {
            int i = 0;
            while(i != index)
            {
                i++;
                currNode = currNode.next;
            }
            Node<T> temp = currNode;
            currNode.prev.next = currNode.next;
            currNode.next.prev = currNode.prev;
            
            return temp;
        }
        else return null;
    }
    Object[] toArray() {
		Object[] array = new Object[getSize()];
		for (int i = 0; i < array.length; i++) {
			Node<T> currnode = pollFirst();
			array[i] = currnode.data;
		}
		return array;
	}
 
    void set(int index, T data)
    {
        if(isEmpty()) return;
        if((index < 0) || (index > getSize())) 
        {
            System.out.println("index out of bounds");
        }else 
        {
            int i = 0;
            Node<T> currNode = head;
            while (currNode.next != head) 
            {
                if(i == index)
                {
                    currNode.data = data;
                    return;
                }  
                i++;
                currNode = currNode.next;  
            }
        }
    }
    int getSize()
    {
        int size = 1;
        if(head == null) return 0;
        Node<T> currNode = head;
        while(currNode.next != head)
        {
            size++;
            currNode = currNode.next;
        }
        return size;
    }
    void print()
    {
        if(head == null) return;
        Node<T> currNode = head;
        int i = 0;
        int size = getSize();
        while (i < size)
        {
            System.out.print(currNode.data + " ");
            i++;
            currNode = currNode.next;
        }
        
    }
    void goInCircles() {
		if (head == null)
			return;
		Node<T> currnode = head;
		int times = 1;
        System.out.println(times + " Go around");
		while (times < 5) {
			if (currnode.next == head) {
                times++;
                System.out.println();
				 System.out.println(times + " Go around");
				System.out.println();
				
			}
			System.out.print(currnode.data + " ");
			currnode = currnode.next;
		}
	}
    void forwardThenBackward() {
		if (head == null) {
			System.out.println("Custom Doubly Linked List is EMPTY!");
			return;
		} else {
			System.out.println("Custom Doubly Linked List: ");
	
			// Forward traversal
            print();
			
            Node<T> currNode = head.prev;
            int index = getSize();

			// Backward traversal
            System.out.println();
            System.out.println("backward traversal");
            System.out.println();
			
			
			while (index > 0 ) {
				System.out.print(currNode.data + " ");
                index --;
				currNode = currNode.prev;
			}
		}
	}


    public static void main(String[] args) {
        DoublyCircularLinkedList<Integer> list = new DoublyCircularLinkedList<>();

        for(int i = 0; i <= 100; i++)
        {
            list.add(i);
        }
        list.addFirst(1000);
        list.add(98, 100000);
        list.pollIndex(98);
        // list.clear();
        list.pollFirst();
        // list.print();
        // System.out.println();
        // System.out.println("size is " + list.getSize());
        // System.out.println(list.pollLast().data);
        list.forwardThenBackward();



    }
}