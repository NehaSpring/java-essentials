package com.nehaspring.linkedlist;

import java.util.NoSuchElementException;

/**
 * Doubly Linked List with tail. deleteLast() will take constant time O(1)
 * because we have tail pointer.
 */
public class DoublyLinkedListWithTail<T> {

	/**
	 * Class member variables new member variable tailNode.
	 */
	public Node<T> headNode;
	public Node<T> tailNode;
	public int size;

	/**
	 * Inner Class Node
	 */
	private static class Node<T> {
		T data;
		Node<T> nextNode;
		Node<T> prevNode;
	}

	/**
	 * Constructor
	 */
	public DoublyLinkedListWithTail() {
		this.headNode = null;
		this.tailNode = null;
		this.size = 0;
	}

	/**
	 * isEmpty() will check if both Head and Tail node are pointing to null
	 */
	public boolean isEmpty() {
		if (headNode == null && tailNode == null) {
			return true;
		}
		return false;
	}

	public int size() {
		return size;
	}

	public T getFirst() {
		final Node<T> first = headNode;
		if (first == null)
			throw new NoSuchElementException();
		return first.data;
	}

	public T getLast() {
		final Node<T> last = tailNode;
		if (last == null)
			throw new NoSuchElementException();
		return last.data;
	}

	public void print() {

		if (isEmpty()) {
			System.out.println("List is empty");
			return;
		}
		Node<T> tempNode = this.headNode;
		while (tempNode.nextNode != null) {
			System.out.print(" " + tempNode.data + "->");
			tempNode = tempNode.nextNode;
		}
		// printing last element
		System.out.println(tempNode.data + "-> null");
	}

	/**
	 * Inserts at the beginning of the List Here New Node will become the Head node.
	 * If Head node is not empty then new Node becomes its previous node And
	 * whatever there in the Head node becomes the next node of the new Node
	 * <strong>IF List is empty then this new Node becomes the Tail Node as
	 * well</strong> <strong> Don't forget to increase the size</strong>
	 */

	public void insertFirst(T data) {

		Node<T> newNode = new Node<>();
		newNode.data = data;
		newNode.nextNode = headNode;
		if (headNode != null) {
			this.headNode.prevNode = newNode;
		} else {
			// It means the List is empty so the new Node becomes the tail Node
			this.tailNode = newNode;
		}
		this.headNode = newNode;
		size++;
	}

	/**
	 * Inserts at the last of the List Using While loop go till end of the list New
	 * Node becomes the next node at last. And last Node become previous of new
	 * Node. <strong>New Node will point to null</strong>. <strong> Don't forget to
	 * increase the size</strong>
	 */
	public void insertLast(T data) {

		if (isEmpty()) {
			insertFirst(data);
			return;
		}

		Node<T> newNode = new Node<>();
		newNode.data = data;
		newNode.nextNode = null;
		tailNode.nextNode = newNode;
		newNode.prevNode = tailNode;
		tailNode = newNode;
		size++;
	}

	/**
	 * Deletes node at the beginning of the List Here Head Node's next Node will
	 * become the Head Node. 
	 * If we have only one node in the List then we need make tail Node also point to null.
	 * <strong> Don't forget to decrease the size</strong>
	 */
	public void deleteFirst() {

		if (isEmpty()) {
			System.out.println("List is empty");
			return;
		}
		if(headNode == tailNode) {
			headNode = null;
			tailNode = null;
			return;
		}
		headNode = headNode.nextNode;
		headNode.prevNode = null;
		size--;
	}

	/**
	 * Here we have reference to Tail Node so we will just delete it
	 * Tail Node's previous becomes new Tail Node so Previous Node's Next become null 
	 * If list has only one Node then we need to mark Head node as null
	 * Here we need not to traverse whole list we just remove the Tail node.
	 * <strong>Don't forget to decrease the size</strong>
	 */
	public void deleteLast() {
		
		if (isEmpty()) {
			System.out.println("List is empty");
			return;
		}
		
		tailNode = tailNode.prevNode;
		if(tailNode == null) {
			headNode = null;
		}else {
			tailNode.nextNode = null;
		}		
		size--;
	}

}
