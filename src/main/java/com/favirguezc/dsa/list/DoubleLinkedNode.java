package com.favirguezc.dsa.list;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoubleLinkedNode<T> extends Node<T> {
    private DoubleLinkedNode<T> next;
    private DoubleLinkedNode<T> previous;

    public DoubleLinkedNode(T data) {
        super(data);
    }
}
