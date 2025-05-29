package com.favirguezc.dsa.stack;

public interface Stack<T> {

    void clear();

    int getSize();

    boolean isEmpty();

    T peek();

    T pop();

    void push(T data);
}
