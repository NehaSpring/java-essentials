package com.nehaspring.linkedlist;

/**
 * Find middle of the Linked List
 * Input List : 1->2-3->4->5->null
 * Output : 3
 */
public class MiddleOfLinkedList {
	/**
	 * 
	 * @param <T>
	 * @param list
	 * @return data
	 * Here I am using two pointers point1 and pointer2
	 * pointer2 will be two steps ahead of pointer1. 
	 * When ponter2 reaches to end of the List pointer1 will be at the middle of the List
	 * And will will return the Value of Node ponted by pointer1.
	 */
	public static <T> T findMidlleNodeOfList(DoublyLinkedList<T> list) {
		
		if(list.isEmpty()) {
			System.out.println("List is empty!!");
			return null;
		}
		
		DoublyLinkedList.Node<T> pointer1 = list.headNode;
		DoublyLinkedList.Node<T> pointer2 = list.headNode;
		
		while(pointer1.nextNode!=null) {
			pointer1 = pointer1.nextNode;
			pointer2 = pointer1.nextNode.nextNode;
			if(pointer2.nextNode == null) {
				break;
			}
		}
		
		return pointer1.data;
	}

}
