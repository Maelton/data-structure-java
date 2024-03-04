package main.data_structures.lists.linked_lists.doubly_linked_list;

import main.data_structures.lists.linked_lists.INode;

public class Node<T> implements INode<T> {
    
    private Node<T> previous;
    private T data;
    private Node<T> next;

    public boolean equals(Object element) {
        return this.data == element || this.data.equals(element);
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return (String) this.getData();
    }

    public Node(T element) {
        this.previous = null;
        this.data = element;
        this.next = null;
    }
}
