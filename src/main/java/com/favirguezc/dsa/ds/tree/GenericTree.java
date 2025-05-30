package com.favirguezc.dsa.ds.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GenericTree<T> {

    private GenericNode<T> root;

    public GenericTree(T data) {
        root = new GenericNode<T>(data);
    }

    public int getHeight() {
        if (root == null) {
            return 0;
        }
        Queue<Pair<GenericNode<T>, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<GenericNode<T>, Integer>(root, 1));
        int maxHeight = 0;
        while (!queue.isEmpty()) {
            Pair<GenericNode<T>, Integer> pair = queue.poll();
            pair.left.getChildren()
                    .forEach(child -> queue.add(new Pair<GenericNode<T>, Integer>(child, pair.right + 1)));
            maxHeight = Math.max(maxHeight, pair.right);
        }
        return maxHeight;
    }

    public int getSize() {
        if (root == null) {
            return 0;
        }
        Queue<GenericNode<T>> queue = new LinkedList<>();
        queue.add(root);
        int size = 0;
        while (!queue.isEmpty()) {
            GenericNode<T> node = queue.poll();
            node.getChildren().forEach(child -> queue.add(child));
            size++;
        }
        return size;
    }

    public List<T> bfsTraversal() {
        List<T> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Queue<GenericNode<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            GenericNode<T> node = queue.poll();
            list.add(node.getData());
            node.getChildren()
                    .forEach(child -> queue.add(child));
        }
        return list;
    }

    public List<T> dfsTraversal() {
        if (root == null) {
            return new LinkedList<>();
        }
        return dfsTraversal(root);
    }

    private List<T> dfsTraversal(GenericNode<T> node) {
        List<T> list = new LinkedList<>();
        node.getChildren().forEach(child -> list.addAll(dfsTraversal(child)));
        list.add(node.getData());
        return list;
    }

    @Data
    @AllArgsConstructor
    static class Pair<A, B> {
        private A left;
        private B right;
    }
}
