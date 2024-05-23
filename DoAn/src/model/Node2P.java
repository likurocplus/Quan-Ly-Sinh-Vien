package model;

public class Node2P extends Node {
	Node prev;

	public Node2P(Student data) {
        this.data = data;
        this.next = null;
        this.prev = null; 
    }
	public Node2P() {
        this.data = null;
        this.next = null;
        this.prev = null; 
    }
}
