package com.favirguezc.dsa.ds.list;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class AbstractLinkedList<T, N extends Node<T>> implements List<T> {

    protected static final String EMPTY_LIST_MESSAGE = "List is empty";

    @Getter
    protected int size;
    protected N head;
    protected N tail;

    @SuppressWarnings("unchecked")
    public AbstractLinkedList(T... data) {
        for (T item : data) {
            insert(item);
        }
    }

    @Override
    public T get(int index) {
        return getNode(index).getData();
    }

    @Override
    public void insert(T data) {
        insert(size, data);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public abstract void reverse();

    public void reverseRecursive() {
        reverseRecursive(head);
    }

    @Override
    public int search(T data) {
        N current = head;
        for (int i = 0; i < size; i++) {
            if (current.getData().equals(data)) {
                return i;
            }
            current = current.getNext();
        }
        return -1;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return EMPTY_LIST_MESSAGE;
        }
        StringBuilder sb = new StringBuilder();
        N current = head;
        while (current != null) {
            sb.append(current.getData());
            if (current.getNext() != null) {
                sb.append(" -> ");
            }
            current = current.getNext();
        }
        return sb.toString();
    }

    protected N getNode(int index) {
        validateIndex(index, 0, size - 1);
        if (index == size - 1) {
            return tail;
        }
        N current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    protected abstract N reverseRecursive(N current);

    protected void validateIndex(int index, int min, int max) {
        if (index < min || index > max) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

}
