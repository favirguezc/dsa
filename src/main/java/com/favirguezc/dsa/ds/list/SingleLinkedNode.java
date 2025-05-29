package com.favirguezc.dsa.ds.list;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SingleLinkedNode<T> extends Node<T> {
    private SingleLinkedNode<T> next;

    public SingleLinkedNode(T data) {
        super(data);
    }
}
