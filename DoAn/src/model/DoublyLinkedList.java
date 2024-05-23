package model;

public class DoublyLinkedList extends SinglyLinkedList {
    // Tail
    private Node2P Tail;

    public Node2P getTail() {
        return Tail;
    }

    public void setTail(Node2P tail) {
        this.Tail = tail;
    }

    // Constructor
    public DoublyLinkedList() {
        super(); 
        Tail = null;
    }
    
    @Override
    public void add(Student data) {
    	Node2P tmp = new Node2P(data);
    	if(isEmpty()) {
    		Head = tmp;
    		Tail = tmp;
    	}else {
    		Tail.next = tmp;
    		tmp.prev = Tail;
    		Tail = tmp;
    	}
    }
}
