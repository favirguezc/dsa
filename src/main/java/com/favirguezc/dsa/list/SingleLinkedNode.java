package com.favirguezc.dsa.list;

import lombok.Data;
import lombok.NonNull;

@Data
public class SingleLinkedNode<T> {

    @NonNull
    private T data;
    private SingleLinkedNode<T> next;
}
