package com.nehaspring.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MiddleOfLinkedListTest {

	@Test
	void testFindMidlleNodeOfList_OddNoOFNodes() {
		DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<Integer>();
		doublyLinkedList.insertFirst(5);
		doublyLinkedList.insertFirst(4);
		doublyLinkedList.insertFirst(3);
		doublyLinkedList.insertFirst(2);
		doublyLinkedList.insertFirst(1);
		
		Integer mid = MiddleOfLinkedList.findMidlleNodeOfList(doublyLinkedList);
		assertEquals(3, mid);
	}

	
	@Test
	void testFindMidlleNodeOfList_EvenNoOfNodes() {
		DoublyLinkedList<String> doublyLinkedListOfStrings = new DoublyLinkedList<String>();
		doublyLinkedListOfStrings.insertFirst("Elen");
		doublyLinkedListOfStrings.insertFirst("Dean");
		doublyLinkedListOfStrings.insertFirst("Cat");
		doublyLinkedListOfStrings.insertFirst("Bob");
		
		String mid = MiddleOfLinkedList.findMidlleNodeOfList(doublyLinkedListOfStrings);
		assertEquals("Cat", mid);
	}
	
	@Test
	void testFindMidlleNodeOfList_SinglefNodes() {
		DoublyLinkedList<Character> doublyLinkedListOfChar = new DoublyLinkedList<Character>();
		doublyLinkedListOfChar.insertFirst('A');
				
		Character mid = MiddleOfLinkedList.findMidlleNodeOfList(doublyLinkedListOfChar);
		assertEquals('A', mid);
	}
	
	@Test
	void testFindMidlleNodeOfList_EmptyList() {
		DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<Integer>();
		
		Integer mid = MiddleOfLinkedList.findMidlleNodeOfList(doublyLinkedList);
		assertEquals(null, mid);
	}
}
