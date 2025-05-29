package com.favirguezc.dsa.stack;

import com.favirguezc.dsa.list.SingleLinkedList;

public class LinkedListStack<T> implements Stack<T> {

    private SingleLinkedList<T> list;

    public LinkedListStack() {
        this.list = new SingleLinkedList<>();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public T peek() {
        return list.get(0);
    }

    @Override
    public T pop() {
        return list.remove(0);
    }

    @Override
    public void push(T data) {
        list.insert(0, data);
    }
}
