package com.favirguezc.dsa.ds.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ArrayStackTest {

    @Test
    void testClear() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        stack.clear();
        assertEquals(0, stack.getSize());
    }

    @Test
    void testGetSize() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            assertEquals(i + 1, stack.getSize());
        }
    }

    @Test
    void testIsEmpty() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        assertTrue(stack.isEmpty());
        stack.push(0);
        assertFalse(stack.isEmpty());
    }

    @Test
    void testPeek() {
        ArrayStack<Integer> stack = new ArrayStack<>();
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
        ArrayStack<Integer> stack = new ArrayStack<>();
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
        ArrayStack<Integer> stack = new ArrayStack<>(5);
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            assertEquals(i, stack.peek());
        }
        assertThrows(IndexOutOfBoundsException.class, () -> stack.push(5));
    }
}
