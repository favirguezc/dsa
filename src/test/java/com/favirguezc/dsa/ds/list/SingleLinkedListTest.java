package com.favirguezc.dsa.ds.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SingleLinkedListTest {

    @Test
    void testClear() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>(1, 2, 3, 4, 5);
        list.clear();
        assertEquals(0, list.getSize());
        assertTrue(list.isEmpty());
    }

    @Test
    void testCreateEmptyList() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        assertEquals(0, list.getSize());
    }

    @Test
    void testCreatePopulatedList() {
        Integer[] data = { 1, 2, 3, 4, 5 };
        SingleLinkedList<Integer> list = new SingleLinkedList<>(data);
        assertEquals(data.length, list.getSize());
        for (int i = 0; i < data.length; i++) {
            assertEquals(data[i], list.get(i));
        }
    }

    @Test
    void testGet() {
        Integer[] data = { 1, 2, 3, 4, 5 };
        SingleLinkedList<Integer> list = new SingleLinkedList<>(data);
        for (int i = 0; i < data.length; i++) {
            assertEquals(data[i], list.get(i));
        }
    }

    @Test
    void testGetOutOfBounds() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>(1, 2, 3, 4, 5);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
    }

    @Test
    void testInsertEmptyList() {
        Integer data = 5;
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.insert(data);
        assertEquals(1, list.getSize());
        assertEquals(data, list.get(0));
    }

    @Test
    void testInsertHead() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>(1, 2, 3, 4, 5);
        list.insert(0, 0);
        assertEquals(6, list.getSize());
        for (int i = 0; i < 6; i++) {
            assertEquals(i, list.get(i));
        }
    }

    @Test
    void testInsertTail() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>(1, 2, 3, 4, 5);
        list.insert(5, 6);
        assertEquals(6, list.getSize());
        for (int i = 0; i < 6; i++) {
            assertEquals(i + 1, list.get(i));
        }
    }

    @Test
    void testInsertMiddle() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>(1, 2, 4, 5);
        list.insert(2, 3);
        assertEquals(5, list.getSize());
        for (int i = 0; i < 5; i++) {
            assertEquals(i + 1, list.get(i));
        }
    }

    @Test
    void testInsertOutOfBounds() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>(1, 2, 3, 4, 5);
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(-1, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(6, 6));
    }

    @Test
    void testIsEmpty() {
        assertTrue(new SingleLinkedList<>().isEmpty());
        assertFalse(new SingleLinkedList<>(1, 2, 3, 4, 5).isEmpty());
    }

    @Test
    void testRemoveHead() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>(1, 2, 3, 4, 5);
        Integer removed = list.remove(0);
        assertEquals(1, removed);
        assertEquals(4, list.getSize());
        for (int i = 0; i < 4; i++) {
            assertEquals(i + 2, list.get(i));
        }
    }

    @Test
    void testRemoveTail() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>(1, 2, 3, 4, 5);
        Integer removed = list.remove(4);
        assertEquals(5, removed);
        assertEquals(4, list.getSize());
        for (int i = 0; i < 4; i++) {
            assertEquals(i + 1, list.get(i));
        }
    }

    @Test
    void testRemoveUnique() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>(1);
        Integer removed = list.remove(0);
        assertEquals(1, removed);
        assertTrue(list.isEmpty());
    }

    @Test
    void testRemoveMiddle() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>(1, 2, 3, 3, 4, 5);
        Integer removed = list.remove(2);
        assertEquals(3, removed);
        assertEquals(5, list.getSize());
        for (int i = 0; i < 5; i++) {
            assertEquals(i + 1, list.get(i));
        }
    }

    @Test
    void testRemoveOutOfBounds() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>(1, 2, 3, 4, 5);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(5));
    }

    @Test
    void testReverse() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>(1, 2, 3, 4, 5);
        list.reverse();
        assertEquals(5, list.getSize());
        for (int i = 0; i < 5; i++) {
            assertEquals(5 - i, list.get(i));
        }
    }

    @Test
    void testDoubleReverse() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>(1, 2, 3, 4, 5);
        list.reverse();
        list.reverse();
        assertEquals(5, list.getSize());
        for (int i = 0; i < 5; i++) {
            assertEquals(i + 1, list.get(i));
        }
    }

    @Test
    void testReverseRecursive() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>(1, 2, 3, 4, 5);
        list.reverseRecursive();
        assertEquals(5, list.getSize());
        for (int i = 0; i < 5; i++) {
            assertEquals(5 - i, list.get(i));
        }
    }

    @Test
    void testDoubleReverseRecursive() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>(1, 2, 3, 4, 5);
        list.reverseRecursive();
        list.reverseRecursive();
        assertEquals(5, list.getSize());
        for (int i = 0; i < 5; i++) {
            assertEquals(i + 1, list.get(i));
        }
    }

    @Test
    void testSearch() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>(1, 2, 3, 4, 5);
        assertEquals(0, list.search(1));
        assertEquals(2, list.search(3));
        assertEquals(4, list.search(5));
        assertEquals(-1, list.search(6));
    }

    @Test
    void testToString() {
        assertEquals(SingleLinkedList.EMPTY_LIST_MESSAGE, new SingleLinkedList<>().toString());
        assertEquals("1 -> 2 -> 3 -> 4 -> 5", new SingleLinkedList<>(1, 2, 3, 4, 5).toString());
    }
}
