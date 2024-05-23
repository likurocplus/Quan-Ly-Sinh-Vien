package model;

public class Node {
	Student data;
	Node next;
	//Contructor
	public Node(Student data){
		this.data = data;
		this.next = null;
	}
	public Node() {
		this.next = null;
	}
	
}