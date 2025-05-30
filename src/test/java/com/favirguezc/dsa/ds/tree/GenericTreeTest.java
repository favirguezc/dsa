package com.favirguezc.dsa.ds.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class GenericTreeTest {

    @Test
    void testCreate() {
        GenericTree<Integer> emptyTree = new GenericTree<>();
        assertEquals(0, emptyTree.getSize());
        GenericTree<Integer> singleNodeTree = new GenericTree<>(1);
        assertEquals(1, singleNodeTree.getSize());
        assertEquals(1, singleNodeTree.getRoot().getData());
        GenericTree<Integer> simpleTree = new GenericTree<>(new GenericNode<Integer>(1, 2, 3, 4));
        assertEquals(4, simpleTree.getSize());
        assertEquals(1, simpleTree.getRoot().getData());
        assertEquals(2, simpleTree.getRoot().getChild(0).getData());
        assertEquals(3, simpleTree.getRoot().getChild(1).getData());
        assertEquals(4, simpleTree.getRoot().getChild(2).getData());
    }

    @Test
    void testGetHeight() {
        GenericTree<Integer> emptyTree = new GenericTree<>();
        assertEquals(0, emptyTree.getHeight());
        GenericTree<Integer> singleNodeTree = new GenericTree<>(1);
        assertEquals(1, singleNodeTree.getHeight());
        GenericTree<Integer> simpleTree = new GenericTree<>(new GenericNode<Integer>(1, 2, 3, 4));
        assertEquals(2, simpleTree.getHeight());
        GenericTree<Integer> deepTree = new GenericTree<>(1);
        GenericNode<Integer> current = deepTree.getRoot();
        for (int i = 0; i < 10; i++) {
            current.addChild(new GenericNode<Integer>(i + 2));
            current = current.getChild(0);
        }
        assertEquals(11, deepTree.getHeight());
    }

    @Test
    void testBfsTraversal() {
        GenericTree<Integer> emptyTree = new GenericTree<>();
        assertEquals(List.of(), emptyTree.bfsTraversal());
        GenericTree<Integer> singleNodeTree = new GenericTree<>(1);
        assertEquals(List.of(1), singleNodeTree.bfsTraversal());
        GenericTree<Integer> simpleTree = new GenericTree<>(new GenericNode<Integer>(1, 2, 3, 4));
        assertEquals(List.of(1, 2, 3, 4), simpleTree.bfsTraversal());
        GenericTree<Integer> deepTree = new GenericTree<>(1);
        GenericNode<Integer> current = deepTree.getRoot();
        for (int i = 0; i < 5; i++) {
            current.addChild(new GenericNode<Integer>(i + 2));
            current = current.getChild(0);
        }
        assertEquals(List.of(1, 2, 3, 4, 5, 6), deepTree.bfsTraversal());
    }

    @Test
    void testDfsTraversal() {
        GenericTree<Integer> emptyTree = new GenericTree<>();
        assertEquals(List.of(), emptyTree.dfsTraversal());
        GenericTree<Integer> singleNodeTree = new GenericTree<>(1);
        assertEquals(List.of(1), singleNodeTree.dfsTraversal());
        GenericTree<Integer> simpleTree = new GenericTree<>(new GenericNode<Integer>(1, 2, 3, 4));
        assertEquals(List.of(2, 3, 4, 1), simpleTree.dfsTraversal());
        GenericTree<Integer> deepTree = new GenericTree<>(1);
        GenericNode<Integer> current = deepTree.getRoot();
        for (int i = 0; i < 5; i++) {
            current.addChild(new GenericNode<Integer>(i + 2));
            current = current.getChild(0);
        }
        assertEquals(List.of(6, 5, 4, 3, 2, 1), deepTree.dfsTraversal());
    }
}
