package com.nehaspring.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListChallengesTest {

	@Test
	void testRemoveDuplicates() {
		
		DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
		doublyLinkedList.insertFirst(22);
		doublyLinkedList.insertFirst(14);
		doublyLinkedList.insertFirst(21);
		doublyLinkedList.insertFirst(14);
		doublyLinkedList.insertFirst(7);
		LinkedListChallenges.removeDuplicates(doublyLinkedList);
	}

}
