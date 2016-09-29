package org.egov.bootcamp;

import org.egov.StackException;

public class MyStack<T> {
	private Node<T> top;

	/**
	 * Creates a Stack
	 */
	public MyStack() {
		top = null;
	}

	/**
	 * Tests if the stack is empty.
	 */
	public boolean isEmpty() {
		return top == null;
	}

	/**
	 * Make the stack logically empty.
	 */
	public void clear() {
		top = null;
	}

	/**
	 * Inserts a new item into the stack.
	 */
	public void push(T data) {
		if (data == null)
			throw new NullPointerException();
		top = new Node<T>(data, top);
	}

	/**
	 * Removes and returns the item at the top of this stack.
	 */
	public T pop() {
		if (isEmpty())
			return null;
		T data = top.value;
		top = top.next;
		return data;
	}

	/**
	 * Returns the top item without its removal
	 */
	public T peek() {
		if (isEmpty())
			throw new StackException("Stack is empty");
		return top.value;
	}

	public int length(Node<T> listPointer, int totalLength) {
		if (listPointer == null) {
			return totalLength;
		}
		return length(listPointer.getNext(), ++totalLength);
	}

	public int length() {
		return length(top, 0);
	}
	
    public T[] toArray() {
        int listLength = this.length();
        T[] array = (T[]) new Object[listLength];
        Node listPointer = top;
        for (int i = 0; i < listLength; i++) {
            array[i] = (T) listPointer.getValue();
            listPointer = listPointer.getNext();
        }
        return array;
    }

}
