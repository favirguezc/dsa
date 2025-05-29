package com.favirguezc.dsa.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LinkedListStackTest {

    @Test
    void testClear() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        stack.clear();
        assertEquals(0, stack.getSize());
    }

    @Test
    void testGetSize() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            assertEquals(i + 1, stack.getSize());
        }
    }

    @Test
    void testIsEmpty() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        assertTrue(stack.isEmpty());
        stack.push(0);
        assertFalse(stack.isEmpty());
    }

    @Test
    void testPeek() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        assertEquals(4, stack.peek());
        assertEquals(4, stack.peek());
        stack.clear();
        assertThrows(IndexOutOfBoundsException.class, () -> stack.peek());
    }

    @Test
    void testPop() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertEquals(0, stack.pop());
        assertThrows(IndexOutOfBoundsException.class, () -> stack.pop());
    }

    @Test
    void testPush() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            assertEquals(i, stack.peek());
        }
    }
}
