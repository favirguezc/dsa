package com.favirguezc.dsa.ds.stack;

public class ArrayStack<T> implements Stack<T> {

    private static final int DEFAULT_CAPACITY = 50;

    private int size;
    private int capacity;
    private T[] stack;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.stack = (T[]) new Object[capacity];
    }

    @Override
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            stack[i] = null;
        }
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Index: " + 0 + ", Size: " + size);
        }
        return (T) stack[size - 1];
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Index: " + 0 + ", Size: " + size);
        }
        T data = (T) stack[size - 1];
        stack[size - 1] = null;
        size--;
        return data;
    }

    @Override
    public void push(T data) {
        if (size == capacity) {
            throw new IndexOutOfBoundsException("Index: " + size + ", Size: " + size);
        }
        stack[size] = data;
        size++;
    }
}
