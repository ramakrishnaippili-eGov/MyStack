package org.egov.bootcamp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.egov.StackException;
import org.junit.Before;
import org.junit.Test;

public class MyStackTest {
	MyStack<Integer> stack;

	@Before
	public void setUp() {
		stack = new MyStack<Integer>();
	}

	@Test
	public void pushOneElement() {
		stack.push(1);
		assertEquals(stack.peek(), Integer.valueOf(1));
		assertFalse(stack.isEmpty());
	}

	@Test
	public void pushMultipleElements() {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		assertEquals(stack.peek(), Integer.valueOf(4));
		assertTrue(4 == stack.peek());
		assertFalse(stack.isEmpty());
		assertTrue(4 == stack.pop());
		assertTrue(3 == stack.pop());
		assertTrue(2 == stack.pop());
		assertTrue(1 == stack.pop());
		assertTrue(stack.isEmpty());
	}

	@Test
	public void pushMultipleAndPopElements() {
		stack = new MyStack<Integer>(0);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		assertTrue(4 == stack.peek());
		assertFalse(stack.isEmpty());
		assertTrue(4 == stack.pop());
		assertTrue(3 == stack.pop());
		assertTrue(2 == stack.peek());
		assertFalse(stack.isEmpty());
	}

	@Test(expected = StackException.class)
	public void pushElementsUntilOverFlow() throws StackException {
		stack = new MyStack<Integer>(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		assertTrue(5 == stack.peek());
		assertFalse(stack.isEmpty());
		stack.push(6);
	}

	@Test(expected = StackException.class)
	public void clearStack() {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		assertTrue(5 == stack.peek());
		assertFalse(stack.isEmpty());
		stack.clear();
		stack.peek();
		assertTrue(stack.isEmpty());
	}
}
