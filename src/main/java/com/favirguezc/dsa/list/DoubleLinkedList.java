package com.favirguezc.dsa.list;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DoubleLinkedList<T> extends AbstractLinkedList<T, DoubleLinkedNode<T>> {

    @SuppressWarnings("unchecked")
    public DoubleLinkedList(T... data) {
        super(data);
    }

    @Override
    public void clear() {
        DoubleLinkedNode<T> current = head;
        while (current != null) {
            DoubleLinkedNode<T> next = current.getNext();
            current.setNext(null);
            current.setPrevious(null);
            current = next;
        }
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void insert(int index, T data) {
        validateIndex(index, 0, size);
        DoubleLinkedNode<T> newNode = new DoubleLinkedNode<>(data);
        if (index == 0) {
            newNode.setNext(head);
            if (size == 0) {
                tail = newNode;
            } else {
                head.setPrevious(newNode);
            }
            head = newNode;
        } else {
            DoubleLinkedNode<T> previous = getNode(index - 1);
            newNode.setPrevious(previous);
            newNode.setNext(previous.getNext());
            previous.setNext(newNode);
            if (index == size) {
                tail = newNode;
            } else {
                newNode.getNext().setPrevious(newNode);
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
            } else {
                head.setPrevious(null);
            }
        } else {
            DoubleLinkedNode<T> previous = getNode(index - 1);
            data = previous.getNext().getData();
            previous.setNext(previous.getNext().getNext());
            if (index == size - 1) {
                tail = previous;
            } else {
                previous.getNext().setPrevious(previous);
            }
        }
        size--;
        return data;
    }

    @Override
    public void reverse() {
        DoubleLinkedNode<T> previous = null;
        DoubleLinkedNode<T> current = head;
        tail = head;
        while (current != null) {
            DoubleLinkedNode<T> next = current.getNext();
            current.setNext(previous);
            current.setPrevious(next);
            previous = current;
            current = next;
        }
        head = previous;
    }

    public String toReversedString() {
        if (size == 0) {
            return EMPTY_LIST_MESSAGE;
        }
        StringBuilder sb = new StringBuilder();
        DoubleLinkedNode<T> current = tail;
        while (current != null) {
            sb.append(current.getData());
            if (current.getPrevious() != null) {
                sb.append(" -> ");
            }
            current = current.getPrevious();
        }
        return sb.toString();
    }

    @Override
    protected DoubleLinkedNode<T> reverseRecursive(DoubleLinkedNode<T> current) {
        if (current.getNext() == null) {
            head = current;
            head.setPrevious(null);
            return head;
        }
        DoubleLinkedNode<T> next = current.getNext();
        current.setNext(null);
        DoubleLinkedNode<T> newHead = reverseRecursive(next);
        next.setNext(current);
        current.setPrevious(next);
        tail = current;
        return newHead;
    }
}
