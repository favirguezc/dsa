package com.favirguezc.dsa.list;

import lombok.Data;
import lombok.NonNull;

@Data
public abstract class Node<T> {

    @NonNull
    private T data;

    public abstract <N extends Node<T>> N getNext();
}
