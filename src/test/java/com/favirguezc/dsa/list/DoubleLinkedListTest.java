package com.favirguezc.dsa.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DoubleLinkedListTest {

    @Test
    void testClear() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>(1, 2, 3, 4, 5);
        list.clear();
        assertEquals(0, list.getSize());
    }

    @Test
    void testCreateEmptyList() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        assertEquals(0, list.getSize());
    }

    @Test
    void testCreatePopulatedList() {
        Integer[] data = { 1, 2, 3, 4, 5 };
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>(data);
        assertEquals(data.length, list.getSize());
        for (int i = 0; i < data.length; i++) {
            assertEquals(data[i], list.get(i));
        }
    }

    @Test
    void testGet() {
        Integer[] data = { 1, 2, 3, 4, 5 };
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>(data);
        for (int i = 0; i < data.length; i++) {
            assertEquals(data[i], list.get(i));
        }
    }

    @Test
    void testGetOutOfBounds() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>(1, 2, 3, 4, 5);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
    }

    @Test
    void testInsertEmptyList() {
        Integer data = 5;
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.insert(data);
        assertEquals(1, list.getSize());
        assertEquals(data, list.get(0));
    }

    @Test
    void testInsertHead() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>(1, 2, 3, 4, 5);
        list.insert(0, 0);
        assertEquals(6, list.getSize());
        for (int i = 0; i < 6; i++) {
            assertEquals(i, list.get(i));
        }
    }

    @Test
    void testInsertTail() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>(1, 2, 3, 4, 5);
        list.insert(5, 6);
        assertEquals(6, list.getSize());
        for (int i = 0; i < 6; i++) {
            assertEquals(i + 1, list.get(i));
        }
    }

    @Test
    void testInsertMiddle() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>(1, 2, 4, 5);
        list.insert(2, 3);
        assertEquals(5, list.getSize());
        for (int i = 0; i < 5; i++) {
            assertEquals(i + 1, list.get(i));
        }
    }

    @Test
    void testInsertNull() {
        assertThrows(IllegalArgumentException.class, () -> new DoubleLinkedList<>().insert(null));

    }

    @Test
    void testInsertOutOfBounds() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>(1, 2, 3, 4, 5);
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(-1, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(6, 6));
    }

    @Test
    void testRemoveHead() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>(1, 2, 3, 4, 5);
        Integer removed = list.remove(0);
        assertEquals(1, removed);
        assertEquals(4, list.getSize());
        for (int i = 0; i < 4; i++) {
            assertEquals(i + 2, list.get(i));
        }
    }

    @Test
    void testRemoveTail() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>(1, 2, 3, 4, 5);
        Integer removed = list.remove(4);
        assertEquals(5, removed);
        assertEquals(4, list.getSize());
        for (int i = 0; i < 4; i++) {
            assertEquals(i + 1, list.get(i));
        }
    }

    @Test
    void testRemoveUnique() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>(1);
        Integer removed = list.remove(0);
        assertEquals(1, removed);
        assertTrue(list.isEmpty());
    }

    @Test
    void testRemoveMiddle() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>(1, 2, 3, 3, 4, 5);
        Integer removed = list.remove(2);
        assertEquals(3, removed);
        assertEquals(5, list.getSize());
        for (int i = 0; i < 5; i++) {
            assertEquals(i + 1, list.get(i));
        }
    }

    @Test
    void testRemoveOutOfBounds() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>(1, 2, 3, 4, 5);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(5));
    }

    @Test
    void testReverse() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>(1, 2, 3, 4, 5);
        list.reverse();
        assertEquals(5, list.getSize());
        for (int i = 0; i < 5; i++) {
            assertEquals(5 - i, list.get(i));
        }
        assertEquals("5 -> 4 -> 3 -> 2 -> 1", list.toString());
        assertEquals("1 -> 2 -> 3 -> 4 -> 5", list.toReversedString());
    }

    @Test
    void testDoubleReverse() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>(1, 2, 3, 4, 5);
        list.reverse();
        list.reverse();
        assertEquals(5, list.getSize());
        for (int i = 0; i < 5; i++) {
            assertEquals(i + 1, list.get(i));
        }
        assertEquals("1 -> 2 -> 3 -> 4 -> 5", list.toString());
        assertEquals("5 -> 4 -> 3 -> 2 -> 1", list.toReversedString());
    }

    @Test
    void testReverseRecursive() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>(1, 2, 3, 4, 5);
        list.reverseRecursive();
        assertEquals(5, list.getSize());
        for (int i = 0; i < 5; i++) {
            assertEquals(5 - i, list.get(i));
        }
        assertEquals("5 -> 4 -> 3 -> 2 -> 1", list.toString());
        assertEquals("1 -> 2 -> 3 -> 4 -> 5", list.toReversedString());
    }

    @Test
    void testDoubleReverseRecursive() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>(1, 2, 3, 4, 5);
        list.reverseRecursive();
        list.reverseRecursive();
        assertEquals(5, list.getSize());
        for (int i = 0; i < 5; i++) {
            assertEquals(i + 1, list.get(i));
        }
        assertEquals("1 -> 2 -> 3 -> 4 -> 5", list.toString());
        assertEquals("5 -> 4 -> 3 -> 2 -> 1", list.toReversedString());
    }

    @Test
    void testSearch() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>(1, 2, 3, 4, 5);
        assertEquals(0, list.search(1));
        assertEquals(2, list.search(3));
        assertEquals(4, list.search(5));
        assertEquals(-1, list.search(6));
    }

    @Test
    void testSearchNull() {
        assertThrows(IllegalArgumentException.class, () -> new SingleLinkedList<>().search(null));
    }

    @Test
    void testToString() {
        assertEquals(DoubleLinkedList.EMPTY_LIST_MESSAGE, new DoubleLinkedList<>().toString());
        assertEquals("1 -> 2 -> 3 -> 4 -> 5", new DoubleLinkedList<>(1, 2, 3, 4, 5).toString());
    }

    @Test
    void testToReversedString() {
        assertEquals(DoubleLinkedList.EMPTY_LIST_MESSAGE, new DoubleLinkedList<>().toReversedString());
        assertEquals("5 -> 4 -> 3 -> 2 -> 1", new DoubleLinkedList<>(1, 2, 3, 4, 5).toReversedString());
    }
}
