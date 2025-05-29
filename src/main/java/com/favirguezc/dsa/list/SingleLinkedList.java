package com.favirguezc.dsa.list;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SingleLinkedList<T> {

    private SingleLinkedNode<T> head;
    private SingleLinkedNode<T> tail;
    @Getter
    private int size;

    public SingleLinkedList(T[] data) {
        for (T item : data) {
            insert(item);
        }
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public void insert(T data) {
        SingleLinkedNode<T> newNode = new SingleLinkedNode<>(data);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public void insert(int index, T data) {
        validateIndex(index, 0, size);
        SingleLinkedNode<T> newNode = new SingleLinkedNode<>(data);
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
            if (size == 0) {
                tail = newNode;
            }
        } else {
            SingleLinkedNode<T> previous = getNode(index - 1);
            newNode.setNext(previous.getNext());
            previous.setNext(newNode);
            if (index == size) {
                tail = newNode;
            }
        }
        size++;
    }

    public T get(int index) {
        return getNode(index).getData();
    }

    public T remove(int index) {
        validateIndex(index, 0, size - 1);
        T data;
        if (index == 0) {
            data = head.getData();
            head = head.getNext();
        } else {
            SingleLinkedNode<T> previous = getNode(index - 1);
            data = previous.getNext().getData();
            previous.setNext(previous.getNext().getNext());
            if (index == size - 1) {
                tail = previous;
            }
        }
        size--;
        return data;
    }

    public void reverse() {
        SingleLinkedNode<T> previous = null;
        SingleLinkedNode<T> current = head;
        tail = head;
        while (current != null) {
            SingleLinkedNode<T> next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        head = previous;
    }

    public void reverseRecursive() {
        reverseRecursive(head);
    }

    private SingleLinkedNode<T> getNode(int index) {
        validateIndex(index, 0, size - 1);
        SingleLinkedNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    private SingleLinkedNode<T> reverseRecursive(SingleLinkedNode<T> current) {
        if (current.getNext() == null) {
            head = current;
            return head;
        }
        SingleLinkedNode<T> next = current.getNext();
        current.setNext(null);
        SingleLinkedNode<T> newHead = reverseRecursive(next);
        next.setNext(current);
        tail = current;
        return newHead;
    }

    private void validateIndex(int index, int min, int max) {
        if (index < min || index > max) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}
