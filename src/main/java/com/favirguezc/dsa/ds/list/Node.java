package com.favirguezc.dsa.ds.list;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Node<T> {

    private T data;

    public abstract <N extends Node<T>> N getNext();
}
