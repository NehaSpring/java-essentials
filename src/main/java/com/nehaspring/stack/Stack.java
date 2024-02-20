package com.nehaspring.stack;

public class Stack <V> {
	
	private int max_size;
	private int top;
	private V array[];
	
	@SuppressWarnings("unchecked")
	public Stack(int max_size){
		this.max_size = max_size;
		this.top = -1;
		this.array = (V[])new Object[max_size];
	}

	/**
	 * Returns Maximum Size of a Stack
	 */
	public int getMaxsize() {
		return max_size;
	}

	/**
	 * Returns True if Stack is empty
	 */
	public boolean isEmpty() {
		return top == -1;
	}
	/**
	 * Returns true if Stack reached maximum capacity
	 */
	
	public boolean isFull() {
		return top == max_size -1;
	}
	/**
	 * Returns value at the top of Stack without removing it.
	 */
	public V top() {
		if(isEmpty())
			return null;
		else
			return array[top];
	}
	
	/**
	 * @param data
	 * Inserts data at the top of the Stack
	 */
	public void push(V data) {
		if(isFull()) {
			System.out.println("Oops!! Stack is Full!");
			return;
		}
		++top;
		array[top] = data;
				
	}
	
	public V pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty!! Nothing to pop");
			return null;
		}
		
		return array[top--];
	}

}
