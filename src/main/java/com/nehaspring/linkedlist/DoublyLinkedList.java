package com.nehaspring.linkedlist;

import java.util.NoSuchElementException;

/**
 * Doubly Linked List.
 */
public class DoublyLinkedList<T> {
	
	 /**
     * Class member variables 
     */
	public Node<T> headNode;
	public Node<T> tailNode;
	public int size;
	
	//Inner class Node
	private static class Node<T>{
		T data;
		Node<T> nextNode;
		Node<T> previousNode;
	}

	public DoublyLinkedList() {
		this.headNode = null;
		this.tailNode = null;
		this.size = 0;
	}
	
	public boolean isEmpty() {
		
		if(this.headNode == null) {
			return true;
		}
		return false;
	}
	
	/**
     * Prints list if not empty
     */
	public void print() {
		if(isEmpty()) {
			System.out.println(" List is empty");
			return;
		}
		Node<T> tempNode = this.headNode;
		while (tempNode.nextNode != null) {
			System.out.print(" "+tempNode.data +" ->");
			tempNode = tempNode.nextNode;
		}
		System.out.println(tempNode.data +"-> null");
	}
	
	/**
     * Inserts at the beginning of the List
     * Here New Node will become the Head node.
     * If Head node is not empty then new Node becomes its previous node 
     * And whatever there in the Head node becomes the next node of the new Node
     */
	public void insertFirst(T data) {
		
		Node<T> newNode = new Node<>();
		newNode.data = data;
		newNode.previousNode = null;
		newNode.nextNode = headNode;
		
		if(headNode != null) {
			headNode.previousNode = newNode;
		}
		this.headNode = newNode;
	}
	
	/**
     * Inserts at the last of the List
     * Using While loop go till end of the list
     * New Node becomes the next node at last. And last Node become previous of new Node.
     * <strong>New Node will point to null</strong>.
     */
	public void insertLast(T data) {
		
		if(isEmpty()) {
			insertFirst(data);
			return;
		}
		
		Node<T> tempNode = headNode;
		while(tempNode.nextNode != null) {
			tempNode = tempNode.nextNode;
		}
		
		Node<T> newNode = new Node<>();
		newNode.data = data;
		newNode.previousNode = tempNode;
		tempNode.nextNode = newNode;
		newNode.nextNode = null;
	}
	
	/**
     * Deletes node at the beginning of the List
     * Here Head Node's next Node will become the Head Node.
     * <strong> Don't forget to decrease the size</strong>
     */
	public void deleteFirst() {
		if(isEmpty()) {
			System.out.println("List is empty!!!!");
			return;
		}
		
		headNode = headNode.nextNode;
		headNode.previousNode = null;
		size--;
	}
	
	/**
     * Deletes node at the last of the List
     * Traverse till the end of the list.
     * Last Node's previous becomes Last so PreviosesNode's Next become null
     * <strong> Don't forget to decrease the size</strong>
     */
	public void deleteLast() {
		if(isEmpty()) {
			System.out.println("List is empty!!!!");
			return;
		}
		
		Node<T> tempNode = headNode;
		while(tempNode.nextNode != null) {
			tempNode = tempNode.nextNode;
		}
		tempNode.previousNode.nextNode = null;
		size--;
	}
	/**
     * Deletes node which has provided value
     * Traverse till you find the Element in the list.
     * <strong> Don't forget to decrease the size</strong>
     * Throws Runtime Exception NoSuchElementException() if element is not found
     */
	public void deleteByValue(T data) {
		if(isEmpty()) {
			System.out.println("List is empty!!!!");
			return;
		}
		boolean found = false;
		Node<T> nodeToBeDeleted= this.headNode;
		while(nodeToBeDeleted.nextNode != null) {
			if(nodeToBeDeleted.data.equals(data)){
				found = true;
				nodeToBeDeleted.previousNode.nextNode = nodeToBeDeleted.nextNode;
				
				if(nodeToBeDeleted.nextNode != null) {
					nodeToBeDeleted.nextNode.previousNode = nodeToBeDeleted.previousNode;
				}
				size--;
				
			}
			nodeToBeDeleted = nodeToBeDeleted.nextNode;
		}
		
		if(!found) {
			throw new NoSuchElementException();
		}
	
		
	}
}
