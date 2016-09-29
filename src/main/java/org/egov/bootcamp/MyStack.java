package org.egov.bootcamp;

import org.egov.StackException;

public class MyStack<E> {
	private static final int DEFAULT_CAPACITY = 10;
	private int top; // top element index
	private Object[] elements;

	/**
	 * Creates a Stack of the size initialCapacity
	 */
	public MyStack(int initialCapacity) {
		if (initialCapacity > 0)
			elements = (Object[]) new Object[initialCapacity];
		else
			elements = (Object[]) new Object[DEFAULT_CAPACITY];

		top = -1; // stack is empty
	}

	/**
	 * Creates a Stack with the default capacity
	 */
	public MyStack() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * checks if the stack is empty.
	 */
	public boolean isEmpty() {
		return top == -1;
	}

	/**
	 * Returns the top element.
	 */
	@SuppressWarnings("unchecked")
	public E peek() {
		if (isEmpty())
			throw new StackException("Stack is empty");
		return (E) elements[top];
	}

	/**
	 * Removes and returns the item at the top of this stack.
	 */
	public E pop() {
		E e = peek();
		elements[top] = null; // make sure the object is destroyed
		top--;
		return e;
	}

	/**
	 * Inserts an item onto the top of the stack.
	 */
	public void push(E e) {
		if (top == elements.length-1)
			throw new StackException("Stack has overflowed");
		top++;
		elements[top] = e;
	}

	/**
	 * Removes all items from the Stack.
	 */
	public void clear() {
		for (int i = 0; i <= top; i++)
			elements[i] = null;
		top = -1;
	}
}
