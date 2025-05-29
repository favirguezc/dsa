package com.favirguezc.dsa.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class SigleLinkedListTest {

    @Test
    void testClear() {
        Integer[] data = { 1, 2, 3, 4, 5 };
        SingleLinkedList<Integer> list = new SingleLinkedList<>(data);
        list.clear();
        assertEquals(0, list.getSize());
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
        Integer[] data = { 1, 2, 3, 4, 5 };
        SingleLinkedList<Integer> list = new SingleLinkedList<>(data);
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
        Integer[] data = { 1, 2, 3, 4, 5 };
        SingleLinkedList<Integer> list = new SingleLinkedList<>(data);
        list.insert(0, 0);
        assertEquals(6, list.getSize());
        for (int i = 0; i < 6; i++) {
            assertEquals(i, list.get(i));
        }
    }

    @Test
    void testInsertTail() {
        Integer[] data = { 1, 2, 3, 4, 5 };
        SingleLinkedList<Integer> list = new SingleLinkedList<>(data);
        list.insert(5, 6);
        assertEquals(6, list.getSize());
        for (int i = 0; i < 6; i++) {
            assertEquals(i + 1, list.get(i));
        }
    }

    @Test
    void testInsertMiddle() {
        Integer[] data = { 1, 2, 4, 5 };
        SingleLinkedList<Integer> list = new SingleLinkedList<>(data);
        list.insert(2, 3);
        assertEquals(5, list.getSize());
        for (int i = 0; i < 5; i++) {
            assertEquals(i + 1, list.get(i));
        }
    }

    @Test
    void testInsertOutOfBounds() {
        Integer[] data = { 1, 2, 3, 4, 5 };
        SingleLinkedList<Integer> list = new SingleLinkedList<>(data);
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(-1, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(6, 6));
    }

    @Test
    void testRemoveHead() {
        Integer[] data = { 1, 2, 3, 4, 5 };
        SingleLinkedList<Integer> list = new SingleLinkedList<>(data);
        Integer removed = list.remove(0);
        assertEquals(1, removed);
        assertEquals(4, list.getSize());
        for (int i = 0; i < 4; i++) {
            assertEquals(i + 2, list.get(i));
        }
    }

    @Test
    void testRemoveTail() {
        Integer[] data = { 1, 2, 3, 4, 5 };
        SingleLinkedList<Integer> list = new SingleLinkedList<>(data);
        Integer removed = list.remove(4);
        assertEquals(5, removed);
        assertEquals(4, list.getSize());
        for (int i = 0; i < 4; i++) {
            assertEquals(i + 1, list.get(i));
        }
    }

    @Test
    void testRemoveMiddle() {
        Integer[] data = { 1, 2, 3, 3, 4, 5 };
        SingleLinkedList<Integer> list = new SingleLinkedList<>(data);
        Integer removed = list.remove(2);
        assertEquals(3, removed);
        assertEquals(5, list.getSize());
        for (int i = 0; i < 5; i++) {
            assertEquals(i + 1, list.get(i));
        }
    }

    @Test
    void testRemoveOutOfBounds() {
        Integer[] data = { 1, 2, 3, 4, 5 };
        SingleLinkedList<Integer> list = new SingleLinkedList<>(data);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(5));
    }

    @Test
    void testReverse() {
        Integer[] data = { 1, 2, 3, 4, 5 };
        SingleLinkedList<Integer> list = new SingleLinkedList<>(data);
        list.reverse();
        assertEquals(5, list.getSize());
        for (int i = 0; i < 5; i++) {
            assertEquals(5 - i, list.get(i));
        }
    }

    @Test
    void testDoubleReverse() {
        Integer[] data = { 1, 2, 3, 4, 5 };
        SingleLinkedList<Integer> list = new SingleLinkedList<>(data);
        list.reverse();
        list.reverse();
        assertEquals(5, list.getSize());
        for (int i = 0; i < 5; i++) {
            assertEquals(i + 1, list.get(i));
        }
    }

    @Test
    void testReverseRecursive() {
        Integer[] data = { 1, 2, 3, 4, 5 };
        SingleLinkedList<Integer> list = new SingleLinkedList<>(data);
        list.reverseRecursive();
        assertEquals(5, list.getSize());
        for (int i = 0; i < 5; i++) {
            assertEquals(5 - i, list.get(i));
        }
    }

    @Test
    void testDoubleReverseRecursive() {
        Integer[] data = { 1, 2, 3, 4, 5 };
        SingleLinkedList<Integer> list = new SingleLinkedList<>(data);
        list.reverseRecursive();
        list.reverseRecursive();
        assertEquals(5, list.getSize());
        for (int i = 0; i < 5; i++) {
            assertEquals(i + 1, list.get(i));
        }
    }
}
