package com.favirguezc.dsa.ds.stack;

public interface Stack<T> {

    void clear();

    int getSize();

    boolean isEmpty();

    T peek();

    T pop();

    void push(T data);
}
