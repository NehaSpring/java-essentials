package com.nehaspring.queue;

public class Queue<E> {

	private int maxSize;
	private E[] array;
	private int front;
	private int rear;
	private int currentSize;
	
	@SuppressWarnings("unchecked")
	public Queue(int maxSize) {
		this.maxSize = maxSize;
		this.array = (E[]) new Object[maxSize];
		this.front = 0;
		this.rear = -1;
		this.currentSize =0;
	}
	
	public boolean isEmpty() {
		return front == 0;
	}
	
	public boolean isFull() {
		return currentSize == maxSize;
	}
	
	public E top() {
		return array[front];
	}
	
	public int getMaxSize() {
		return this.maxSize;
	}
	
	public int getCurrentSize() {
		return this.currentSize;
	}
	
	public void enqueue(E value) {
        if (isFull()) {
        	System.out.println("Queue is full. Cannot Insert more!");
            return;
        }
        rear = (rear + 1) % maxSize;
        array[rear] = value;
        currentSize++;
    }

    public E dequeue() {
        if (isEmpty()) {
        	System.out.println("Queue is empty!");
            return null;
        }

        E temp = array[front];
        front = (front + 1) % maxSize;
        currentSize--;

        return temp;
    }
	
}
