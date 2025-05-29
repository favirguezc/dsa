package com.favirguezc.dsa.ds.list;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SingleLinkedList<T> extends AbstractLinkedList<T, SingleLinkedNode<T>> {

    @SuppressWarnings("unchecked")
    public SingleLinkedList(T... data) {
        super(data);
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void insert(int index, T data) {
        validateIndex(index, 0, size);
        SingleLinkedNode<T> newNode = new SingleLinkedNode<>(data);
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
            if (size == 0) {
                tail = newNode;
            }
        } else {
            SingleLinkedNode<T> previous = getNode(index - 1);
            newNode.setNext(previous.getNext());
            previous.setNext(newNode);
            if (index == size) {
                tail = newNode;
            }
        }
        size++;
    }

    @Override
    public T remove(int index) {
        validateIndex(index, 0, size - 1);
        T data;
        if (index == 0) {
            data = head.getData();
            head = head.getNext();
            if (size == 1) {
                tail = null;
            }
        } else {
            SingleLinkedNode<T> previous = getNode(index - 1);
            data = previous.getNext().getData();
            previous.setNext(previous.getNext().getNext());
            if (index == size - 1) {
                tail = previous;
            }
        }
        size--;
        return data;
    }

    @Override
    public void reverse() {
        SingleLinkedNode<T> previous = null;
        SingleLinkedNode<T> current = head;
        tail = head;
        while (current != null) {
            SingleLinkedNode<T> next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        head = previous;
    }

    @Override
    protected SingleLinkedNode<T> reverseRecursive(SingleLinkedNode<T> current) {
        if (current.getNext() == null) {
            head = current;
            return head;
        }
        SingleLinkedNode<T> next = current.getNext();
        current.setNext(null);
        SingleLinkedNode<T> newHead = reverseRecursive(next);
        next.setNext(current);
        tail = current;
        return newHead;
    }
}
