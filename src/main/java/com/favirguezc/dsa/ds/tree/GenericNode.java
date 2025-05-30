package com.favirguezc.dsa.ds.tree;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class GenericNode<T> {

    @Getter
    private T data;
    @Getter
    private List<GenericNode<T>> children;

    public GenericNode(T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    public GenericNode(T data, T... children) {
        this.data = data;
        this.children = new ArrayList<>(children.length);
        for (int i = 0; i < children.length; i++) {
            this.children.add(new GenericNode<>(children[i]));
        }
    }

    @SuppressWarnings("unchecked")
    public GenericNode(T data, GenericNode<T>... children) {
        this.data = data;
        this.children = new ArrayList<>(children.length);
        for (int i = 0; i < children.length; i++) {
            this.children.add(children[i]);
        }
    }

    public GenericNode<T> getChild(int index) {
        return children.get(index);
    }

    public void addChild(GenericNode<T> child) {
        children.add(child);
    }

    public T removeChild(int index) {
        return children.remove(index).getData();
    }

    public boolean removeChild(T data) {
        return children.remove(data);
    }
}
