package com.nehaspring.linkedlist;

import com.nehaspring.linkedlist.DoublyLinkedList.Node;

public class LinkedListChallenges {

	/**
	 * Remove Duplicates from LinkedList
	 * @param list
	 * @return Void
	 * Here I am using two loops Outer loop and inner loop.
	 * Then Compare the each element with inner loop elements.
	 * IF duplicate element is found then that node will be deleted.
	 */
	public static <T> void removeDuplicates(DoublyLinkedList<T> linkedList) {
		
		Node<T> ouertLoop = linkedList.headNode;
		Node<T> innerLoop = null;
		
		while(ouertLoop!= null && ouertLoop.nextNode != null) {
			innerLoop = ouertLoop;
			while(innerLoop.nextNode != null) {
				 T outerLoopdataElement = ouertLoop.data;
				 T innerLoopdataElement = innerLoop.nextNode.data;
				if(outerLoopdataElement.equals(innerLoopdataElement)) {
					System.out.println("Found Duplicate:"+innerLoopdataElement );
					innerLoop.nextNode = innerLoop.nextNode.nextNode;
				}else {
					innerLoop= innerLoop.nextNode;
				}
				
			}
			ouertLoop = ouertLoop.nextNode;
		}
		
	}
}
