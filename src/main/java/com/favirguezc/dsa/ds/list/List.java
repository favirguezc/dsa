package com.favirguezc.dsa.ds.list;

public interface List<T> {

    void clear();

    T get(int index);

    int getSize();

    void insert(T data);

    void insert(int index, T data);

    boolean isEmpty();

    T remove(int index);

    int search(T data);
}
