import java.util.NoSuchElementException;

public class QueueLInkedList<T> {

    Node<T> head;

    class Node<T>
    {
        T data;
        Node<T> next;
        public Node(T data)
        {
            this.data = data;
            this.next = null;
        }
    }

    boolean add(T data)
    {
        Node<T> newNode = new Node<>(data);
        if(head == null)
        {
            head = newNode;
            return true;
        }
        else 
        {
            Node<T> currNode = head;
            while (currNode.next != null)
            {
                currNode = currNode.next;
            }
            currNode.next = newNode;
            return true;
        }
    }
    Node<T> peek()
    {
        if(head != null) return head;
        else throw new IllegalStateException("Empty Queue");
    }
    Node<T> element()
    {
        if(head != null) return head;
        else throw new NoSuchElementException("Empty List");
    }
    Node<T> remove()
    {
        if(head == null) throw new NoSuchElementException("Empty List");
        else 
        {
            Node<T> temp = head;
            head = head.next;
            return temp;
        }
    }
    void dequeue()
    {
        remove();
    }
    Node<T> poll()
    {
        if(head != null) 
        {
            Node<T> temp = head;
            head = head.next;
            return temp;
        }
        return null;
    }
    boolean offer(T data)
    {
        Node<T> newNode = new Node<>(data);
        Node<T> currNode = head;
        if(currNode == null)
        {
            head = newNode;
            return true;
        }
        else {
            while(currNode.next != null)
            {
                currNode = currNode.next;
            }
            currNode.next = newNode;
            return true;
        }
    }
    boolean enqueue(T data)
    {
        return offer(data);
    }
    int size()
    {
        Node<T> currNode = head;
        int size = 0;
        while(currNode != null)
        {
            currNode = currNode.next;
            size++;
        }
        return size;
    }
    public Node<T> front() {
        return head;
    }
    void display()
    {
        Node<T> currNode = head;
        while(currNode != null)
        {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }
    
    public static void main(String a[]){  
        QueueLInkedList<Integer> queue = new QueueLInkedList<>();  
        queue.enqueue(6);  
        queue.enqueue(3);  
        queue.display();  
        System.out.println();
        queue.enqueue(12);  
        queue.enqueue(24);  
        queue.dequeue();  
        queue.dequeue();  
        queue.enqueue(9);   
        queue.display();  
        }  

}
